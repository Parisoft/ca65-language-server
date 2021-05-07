package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.exception.ExitMacroException;
import com.parisoft.ca65.lsp.parser.exception.ExpansionException;
import com.parisoft.ca65.lsp.parser.grammar.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65BaseVisitor;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Visitor;
import com.parisoft.ca65.lsp.parser.lang.PseudoVar;
import com.parisoft.ca65.lsp.parser.symbol.Constant;
import com.parisoft.ca65.lsp.parser.symbol.DefineDef;
import com.parisoft.ca65.lsp.parser.symbol.Definition;
import com.parisoft.ca65.lsp.parser.symbol.EnumDef;
import com.parisoft.ca65.lsp.parser.symbol.Enumeration;
import com.parisoft.ca65.lsp.parser.symbol.Expansible;
import com.parisoft.ca65.lsp.parser.symbol.Expansion;
import com.parisoft.ca65.lsp.parser.symbol.Export;
import com.parisoft.ca65.lsp.parser.symbol.FieldDef;
import com.parisoft.ca65.lsp.parser.symbol.Global;
import com.parisoft.ca65.lsp.parser.symbol.Import;
import com.parisoft.ca65.lsp.parser.symbol.Include;
import com.parisoft.ca65.lsp.parser.symbol.LabelDef;
import com.parisoft.ca65.lsp.parser.symbol.MacroDef;
import com.parisoft.ca65.lsp.parser.symbol.ParamDef;
import com.parisoft.ca65.lsp.parser.symbol.ProcDef;
import com.parisoft.ca65.lsp.parser.symbol.Reference;
import com.parisoft.ca65.lsp.parser.symbol.RepeatDef;
import com.parisoft.ca65.lsp.parser.symbol.ScopeDef;
import com.parisoft.ca65.lsp.parser.symbol.StructDef;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
import com.parisoft.ca65.lsp.parser.symbol.UnnamedRef;
import com.parisoft.ca65.lsp.parser.symbol.VarDef;
import com.parisoft.ca65.lsp.util.Contexts;
import com.parisoft.ca65.lsp.util.Paths;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.eclipse.lsp4j.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.AUTOIMPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXPORTZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.GLOBAL;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.GLOBALZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.IMPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.IMPORTZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.INCLUDE;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.VOCABULARY;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.BANKBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoVar.CPU.CPU_6502;
import static com.parisoft.ca65.lsp.server.CA65LanguageServer.workspaceDir;
import static com.parisoft.ca65.lsp.util.Contexts.sourceText;
import static com.parisoft.ca65.lsp.util.Strings.repeat;
import static com.parisoft.ca65.lsp.util.Strings.splitLines;
import static com.parisoft.ca65.lsp.util.Strings.unquote;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;
import static java.util.Collections.singletonList;

@SuppressWarnings("Duplicates")
public class CodeParser extends AbstractParseTreeVisitor<String> implements CA65Visitor<String>, Runnable {

    private static final Logger log = LoggerFactory.getLogger(CodeParser.class);
    private static final Map<Path, String> codeCache = new ConcurrentHashMap<>();
    public static final ExecutorService pool = Executors.newSingleThreadExecutor();//ThreadPool.newThreadPool();

    private String code;
    private Path path;
    private int offset = 0;
    private boolean eval = false;
    private int cpu = CPU_6502.value();
    private int asize = 8;
    private int isize = 8;
    private final Deque<Integer> cpuStack = new ArrayDeque<>();
    private final Deque<Integer> asizeStack = new ArrayDeque<>();
    private final Deque<Integer> isizeStack = new ArrayDeque<>();
    private final Map<String, Expansible> macros = new HashMap<>();
    private final Deque<Expansion> expansion = new ArrayDeque<>();
    private final Deque<Symbol> layer = new ArrayDeque<>();
    private final Map<String, Function<CA65Parser.ControlContext, String>> controlCommands = new HashMap<>();

    public static void main(String[] args) {
        Path path = Paths.fromURI(args[0]);
        new CodeParser(path).run();
    }

    public CodeParser(Path path) {
        this.path = path;

        controlCommands.put(VOCABULARY.getSymbolicName(IMPORT), this::visitImport);
        controlCommands.put(VOCABULARY.getSymbolicName(IMPORTZP), this::visitImport);
        controlCommands.put(VOCABULARY.getSymbolicName(EXPORT), this::visitExport);
        controlCommands.put(VOCABULARY.getSymbolicName(EXPORTZP), this::visitExport);
        controlCommands.put(VOCABULARY.getSymbolicName(GLOBAL), this::visitGlobal);
        controlCommands.put(VOCABULARY.getSymbolicName(GLOBALZP), this::visitGlobal);
        controlCommands.put(VOCABULARY.getSymbolicName(INCLUDE), this::visitInclude);
        controlCommands.put(VOCABULARY.getSymbolicName(AUTOIMPORT), this::visitAutoImport);

        layer.push(new ScopeDef("", path, new Position(0, 0))); // Push the global scope
    }

    public String getCode() {
        return code;
    }

    public Path getPath() {
        return path;
    }

    public static void parseWorkspace() {
        workspaceDir.forEach(workspace -> {
            try {
                Files.walk(workspace, FileVisitOption.FOLLOW_LINKS)
                        .filter(Paths::isASM)
                        .map(CodeParser::new)
                        .forEach(CompletableFuture::runAsync);
            } catch (IOException e) {
                log.warn("Could not read workspace directory {}: {}", workspace, e.toString());
            }
        });
    }

    public CodeParser save(String code) {
        codeCache.put(path, code);
        return this;
    }

    @Override
    public void run() {
        Symbol.Table.clean(path)
                .parallel()
                .map(CodeParser::new)
                .forEach(pool::submit);

        parse(getCode(path));
    }

    public void parse() {
        pool.submit(this);
    }

    private void parse(String code) {
        if (code == null) {
            return;
        }

        log.debug("Parsing {}", path);

        this.code = code;

        try {
            visit(newParser(code).program());
        } catch (ExpansionException e) {
            reParse(e);
        }
    }

    private void reParse(ExpansionException e) {
        Position position = e.getPosition();
        String[] originalLines = splitLines(code);
        String originalLine = originalLines[position.getLine()];
        Expansible def = e.getExpansible();

        Symbol.Table.clean(path);

        // Get the macro arguments
        Expansible.Args args = def.getArgs(originalLine, position);

        if (args.isInvalid()) {
            return;
        }

        // Replace parameters by arguments
        String expandedBody = replaceParams(def.getParams(), args, def.getBody());

        // Expand the macro
        String expansion = String.format("#expansion-push %s %d \"%s\"%n", def.getName(), position.getCharacter(), originalLine)
                + originalLine.substring(0, position.getCharacter()) + expandedBody + lineSeparator()
                + "#expansion-pop " + def.getBody().length;
        String[] expandedLines = splitLines(expansion);

        if (expandedLines.length == 3 && expandedLines[1].equals(originalLine)) {
            return;
        }

        String[] mergedLines = new String[originalLines.length + expandedLines.length - 1];

        if (position.getLine() > 0) {
            System.arraycopy(originalLines, 0, mergedLines, 0, position.getLine());
        }

        System.arraycopy(expandedLines, 0, mergedLines, position.getLine(), expandedLines.length);

        int srcPos = position.getLine() + 1;
        int dstPos = position.getLine() + expandedLines.length;
        int length = originalLines.length - position.getLine() - 1;

        if (length > 0
                && srcPos + length <= originalLines.length
                && dstPos + length <= mergedLines.length) {
            System.arraycopy(originalLines, srcPos, mergedLines, dstPos, length);
        }

        String expandedCode = String.join(lineSeparator(), mergedLines);
        log.debug("Expansion\n{}", expandedCode);

        // Parse the expanded code
        new CodeParser(path).parse(expandedCode);
    }

    @Override
    public String visitProgram(CA65Parser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLine(CA65Parser.LineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitInstruction(CA65Parser.InstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIndirectInstruction(CA65Parser.IndirectInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLabelEqu(CA65Parser.LabelEquContext ctx) {
        String name = visitIdentifier(ctx.identifier());
        new LabelDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        visit(ctx.expression());

        return name;
    }

    @Override
    public String visitLabelDef(CA65Parser.LabelDefContext ctx) {
        if (ctx.inlineLabel() != null) {
            return visitInlineLabel(ctx.inlineLabel());
        }

        String name = visit(ctx.identifier());
        new LabelDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        return name;
    }

    @Override
    public String visitVarDef(CA65Parser.VarDefContext ctx) {
        String name = visitIdentifier(ctx.identifier());
        int value = parseInt(eval(ctx.expression()));
        new VarDef(name, path, positionOf(ctx.identifier()), value)
                .setParent(layer.peek())
                .save();

        return name;
    }

    @Override
    public String visitInlineLabel(CA65Parser.InlineLabelContext ctx) {
        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : "";
        Symbol symbol = new LabelDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        layer.push(symbol);

        return name;
    }

    @Override
    public String visitExpression(CA65Parser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMultiplicative(CA65Parser.MultiplicativeContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expr(0)));
            int right = parseInt(visit(ctx.expr(1)));

            if (ctx.MUL() != null) {
                return valueOf(left * right);
            } else if (ctx.DIV() != null) {
                return valueOf(left / right);
            } else if (ctx.MOD() != null) {
                return valueOf(left % right);
            } else if (ctx.BITAND() != null) {
                return valueOf(left & right);
            } else if (ctx.BITXOR() != null) {
                return valueOf(left ^ right);
            } else if (ctx.SHL() != null) {
                return valueOf(left << right);
            } else if (ctx.SHR() != null) {
                return valueOf(left >> right);
            } else {
                throw new IllegalArgumentException("Unknown Multiplicative operator: " + ctx.op.getText());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitAdditive(CA65Parser.AdditiveContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expr(0)));
            int right = parseInt(visit(ctx.expr(1)));

            if (ctx.PLUS() != null) {
                return valueOf(left + right);
            } else if (ctx.MINUS() != null) {
                return valueOf(left - right);
            } else if (ctx.BITOR() != null) {
                return valueOf(left | right);
            } else {
                throw new IllegalArgumentException("Unknown Additive operator: " + ctx.op.getText());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitBitwise(CA65Parser.BitwiseContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expr(0)));
            int right = parseInt(visit(ctx.expr(1)));

            if (ctx.AND_() != null) {
                return valueOf(left != 0 && right != 0);
            } else if (ctx.OR() != null) {
                return valueOf(left != 0 || right != 0);
            } else if (ctx.XOR() != null) {
                return valueOf(left ^ right);
            } else {
                throw new IllegalArgumentException("Unknown Bitwise operator: " + ctx.op.getText());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitNegation(CA65Parser.NegationContext ctx) {
        if (eval) {
            return parseInt(visit(ctx.expr())) == 0 ? "0" : "1";
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitPrimary(CA65Parser.PrimaryContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitExtraction(CA65Parser.ExtractionContext ctx) {
        if (eval) {
            int value = parseInt(visit(ctx.expr()));

            if (ctx.LOBYTE() != null) {
                return valueOf(LOBYTE(value));
            } else if (ctx.HIBYTE() != null) {
                return valueOf(HIBYTE(value));
            } else if (ctx.LOWORD() != null) {
                return valueOf(LOWORD(value));
            } else if (ctx.HIWORD() != null) {
                return valueOf(HIWORD(value));
            } else {
                return valueOf(BANKBYTE(value));
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitUnary(CA65Parser.UnaryContext ctx) {
        if (eval) {
            int value = parseInt(visit(ctx.expr()));

            if (ctx.PLUS() != null) {
                return valueOf(value);
            } else if (ctx.MINUS() != null) {
                return valueOf(-value);
            } else if (ctx.BITNOT() != null) {
                return valueOf(~value);
            } else if (ctx.prefix.getText().equals("<")) {
                return valueOf(LOBYTE(value));
            } else if (ctx.prefix.getText().equals(">")) {
                return valueOf(HIBYTE(value));
            } else if (ctx.prefix.getText().equals("^")) {
                return valueOf(BANKBYTE(value));
            } else {
                throw new IllegalArgumentException("Unknown Unary operator: " + ctx.prefix.getText());
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitComparative(CA65Parser.ComparativeContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expr(0)));
            int right = parseInt(visit(ctx.expr(1)));

            if (ctx.EQ() != null) {
                return valueOf(left == right ? 1 : 0);
            } else if (ctx.NE() != null) {
                return valueOf(left != right ? 1 : 0);
            } else if (ctx.LT() != null) {
                return valueOf(left < right ? 1 : 0);
            } else if (ctx.GT() != null) {
                return valueOf(left > right ? 1 : 0);
            } else if (ctx.LE() != null) {
                return valueOf(left <= right ? 1 : 0);
            } else if (ctx.GE() != null) {
                return valueOf(left >= right ? 1 : 0);
            } else throw new IllegalArgumentException("Unknown Comparative operator: " + ctx.op.getText());
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitPrimaryExpression(CA65Parser.PrimaryExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLabelRef(CA65Parser.LabelRefContext ctx) {
        if (ctx.UnnamedLabel() != null) {
            Token symbol = ctx.UnnamedLabel().getSymbol();
            String name = symbol.getText().substring(1);
            Position pos = new Position(symbol.getLine() - 1, symbol.getCharPositionInLine());
            new UnnamedRef(name, path, pos)
                    .setParent(layer.peek())
                    .save();

            return name;
        }

        Reference ancestor = ctx.global != null ? new Reference("", path, positionOf(ctx), null) : null;

        for (int i = 0; i < ctx.identifier().size(); i++) {
            CA65Parser.IdentifierContext identifier = ctx.identifier(i);
            String name = visitIdentifier(identifier);
            ancestor = new Reference(name, path, positionOf(identifier), ancestor)
                    .setParent(layer.peek())
                    .save();
        }

        if (ancestor != null) {
            if (eval) {
                Definition def = ancestor.getDefinition();
                return def instanceof Constant
                        ? valueOf(((Constant) def).getValue())
                        : null;
            }

            return ancestor.getName();
        }

        return null;
    }

    @Override
    public String visitVarRef(CA65Parser.VarRefContext ctx) {
        if (eval) {
            String var = ctx.var.getText().toUpperCase();

            switch (var) {
                case ".ASIZE":
                    return valueOf(asize);
                case ".ISIZE":
                    return valueOf(isize);
                case ".CPU":
                    return valueOf(cpu);
                case ".TIME":
                    return valueOf(System.currentTimeMillis() / 1000);
                case ".VERSION": //TODO find out a way to get version
                    return "0";
                case ".PARAMCOUNT":
                    try {
                        return valueOf(expansion.element().getArgs().size());
                    } catch (NoSuchElementException e) {
                        return "0";
                    }
                default:
                    return valueOf(PseudoVar.CPU.valueOf(var).value());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitFunctionRef(CA65Parser.FunctionRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
        if (ctx.IDENT() != null) {
            return unquote(visitExpression(ctx.expression()));
        }

        String name = ctx.Identifier().getSymbol().getText();
        Expansible expansible = macros.get(name);

        if (expansible != null) {
            throw new ExpansionException(expansible, Contexts.positionOf(ctx.Identifier().getSymbol()));
        }

        return name;
    }

    @Override
    public String visitLiteral(CA65Parser.LiteralContext ctx) {
        String text = ctx.getText();

        if (ctx.NUMBER() != null) {
            if (text.contains("$") || text.contains("h") || text.contains("H")) {
                return valueOf(parseInt(text, 16));
            } else if (text.contains("%")) {
                return valueOf(parseInt(text, 2));
            } else {
                return valueOf(parseInt(text));
            }
        }

        return text;
    }

    @Override
    public String visitStatement(CA65Parser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitProc(CA65Parser.ProcContext ctx) {
        String name = visitIdentifier(ctx.identifier());
        Symbol proc = new ProcDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        layer.push(proc);
        ctx.line().forEach(this::visitLine);
        layer.pop();

        return name;
    }

    @Override
    public String visitScope(CA65Parser.ScopeContext ctx) {
        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : "";
        Position position = positionOf(ctx.identifier() != null ? ctx.identifier() : ctx);
        ScopeDef scope = new ScopeDef(name, path, position)
                .setParent(layer.peek())
                .save();

        layer.push(scope);
        ctx.line().forEach(this::visitLine);
        layer.pop();

        return name;
    }

    @Override
    public String visitEnumerator(CA65Parser.EnumeratorContext ctx) {
        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            EnumDef enumDcl = new EnumDef(name, path, positionOf(ctx.identifier()))
                    .setParent(layer.peek())
                    .save();

            layer.push(enumDcl);
        }

        int value = 0;
        CA65Parser.IdentifierContext identifier;

        for (CA65Parser.EnumMemberContext member : ctx.enumMember()) {
            if (member.labelEqu() != null) {
                identifier = member.labelEqu().identifier();
                value = parseInt(visit(member.labelEqu().expression()));
            } else {
                identifier = member.identifier();
            }

            new Enumeration(visitIdentifier(identifier), path, positionOf(identifier), value++)
                    .setParent(layer.peek())
                    .save();
        }

        if (ctx.identifier() != null) {
            layer.poll();
        }

        return null;
    }

    @Override
    public String visitEnumMember(CA65Parser.EnumMemberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitStruct(CA65Parser.StructContext ctx) {
        StructDef structDef = null;
        int structSize = 0;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            structDef = new StructDef(name, path, positionOf(ctx.identifier()))
                    .setParent(layer.peek())
                    .save();

            layer.push(structDef);
        }

        for (CA65Parser.StructMemberContext member : ctx.structMember()) {
            if (member.struct() != null) {
                structSize += parseInt(visitStruct(member.struct()));
            } else if (member.union() != null) {
                structSize += parseInt(visitUnion(member.union()));
            } else {
                CA65Parser.FieldContext field = member.field();

                String name = field.identifier() != null ? visitIdentifier(field.identifier()) : null;
                Position pos = positionOf(field.identifier() != null ? field.identifier() : field.expression());
                int fieldSize = field.expression() != null ? parseInt(visit(field.expression())) : 1;

                if (field.WORD() != null || field.DWORD() != null || field.ADDR() != null) {
                    fieldSize *= 2;
                } else if (field.FARADDR() != null) {
                    fieldSize *= 3;
                }

                if (name != null) {
                    new FieldDef(name, path, pos, structSize, fieldSize)
                            .setParent(layer.peek())
                            .save();
                }

                structSize += fieldSize;
            }
        }

        if (structDef != null) {
            structDef.setSize(structSize);
        }

        return valueOf(structSize);
    }

    @Override
    public String visitUnion(CA65Parser.UnionContext ctx) {
        StructDef unionDef = null;
        int unionSize = 0;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            unionDef = new StructDef(name, path, positionOf(ctx.identifier()))
                    .setParent(layer.peek())
                    .save();
            layer.push(unionDef);
        }

        for (CA65Parser.StructMemberContext member : ctx.structMember()) {
            if (member.struct() != null) {
                unionSize = Math.max(unionSize, parseInt(visitStruct(member.struct())));
            } else if (member.union() != null) {
                unionSize = Math.max(unionSize, parseInt(visitUnion(member.union())));
            } else {
                CA65Parser.FieldContext field = member.field();

                String name = field.identifier() != null ? visitIdentifier(field.identifier()) : null;
                Position pos = positionOf(field.identifier() != null ? field.identifier() : field.expression());
                int fieldSize = field.expression() != null ? parseInt(visit(field.expression())) : 1;

                if (field.WORD() != null || field.DWORD() != null || field.ADDR() != null) {
                    fieldSize *= 2;
                } else if (field.FARADDR() != null) {
                    fieldSize *= 3;
                }

                if (name != null) {
                    new FieldDef(name, path, pos, unionSize, fieldSize)
                            .setParent(layer.peek())
                            .save();
                }

                unionSize = Math.max(unionSize, fieldSize);
            }
        }

        if (unionDef != null) {
            unionDef.setSize(unionSize);
        }

        return valueOf(unionSize);
    }

    @Override
    public String visitStructMember(CA65Parser.StructMemberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitField(CA65Parser.FieldContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIfStmt(CA65Parser.IfStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitElseif(CA65Parser.ElseifContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitElseStmt(CA65Parser.ElseStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitRepeat(CA65Parser.RepeatContext ctx) {
        int repN = parseInt(eval(ctx.expression()));

        if (ctx.identifier() != null) {
            int tmpOffset = offset;
            String repI = visitIdentifier(ctx.identifier());

            Symbol repeatDef = new RepeatDef(path, positionOf(ctx))
                    .setParent(layer.peek())
                    .save();

            new ParamDef(repI, path, positionOf(ctx.identifier()))
                    .setParent(repeatDef)
                    .save();

            CA65Visitor<String> iVisitor = new CA65BaseVisitor<String>() {

                @Override
                public String visitLabelRef(CA65Parser.LabelRefContext ctx) {
                    if (ctx.identifier().size() == 1
                            && ctx.identifier(0).IDENT() == null
                            && ctx.identifier(0).Identifier().getSymbol().getText().equals(repI)) {
                        new Reference(repI, path, positionOf(ctx.identifier(0)), null)
                                .setParent(repeatDef)
                                .save();
                    }

                    return visitChildren(ctx);
                }
            };

            ctx.line().forEach(iVisitor::visitLine);

            for (int i = 0; i < repN; i++) {
                offset = tmpOffset + ctx.start.getLine();

                String[] body = ctx.line().stream()
                        .map(line -> repeat(' ', line.start.getCharPositionInLine()) + sourceText(line))
                        .toArray(String[]::new);
                Expansible.Args args = new Expansible.Args(new Expansible.Arg(valueOf(i), 0, 0));
                List<String> params = singletonList(repI);
                String expandedBody = replaceParams(params, args, body);

                visit(newParser(expandedBody).program());
            }

            offset = tmpOffset;
        } else {
            for (int i = 0; i < repN; i++) {
                ctx.line().forEach(this::visitLine);
            }
        }

        return null;
    }

    @Override
    public String visitDefine(CA65Parser.DefineContext ctx) {
        String name = visitIdentifier(ctx.name);
        DefineDef define = new DefineDef(name, path, positionOf(ctx.name))
                .setParent(layer.peekFirst())
                .save();
        macros.put(name, define);

        for (CA65Parser.IdentifierContext param : ctx.param) {
            String paramName = visitIdentifier(param);
            new ParamDef(paramName, path, positionOf(param))
                    .setParent(define)
                    .save();
            define.addParam(paramName);
        }

        define.setBody(new String[]{sourceText(ctx.expression())});

        layer.push(define);
        visitExpression(ctx.expression());
        layer.poll();

        return name;
    }

    @Override
    public String visitMacro(CA65Parser.MacroContext ctx) {
        return visitMacro(ctx.name, ctx.param, ctx.macline(), false);
    }

    private String visitMacro(CA65Parser.IdentifierContext identifier, List<CA65Parser.IdentifierContext> params, List<CA65Parser.MaclineContext> lines, boolean inner) {
        String name = visitIdentifier(identifier);
        MacroDef macro = new MacroDef(name, path, positionOf(identifier));

        if (inner) {
            macro.setParent(layer.peek()).save();
        } else {
            macro.setParent(layer.peekFirst()).save();
            macros.put(name, macro);
        }

        for (CA65Parser.IdentifierContext param : params) {
            String paramName = visitIdentifier(param);
            new ParamDef(paramName, path, positionOf(param))
                    .setParent(macro)
                    .save();
            macro.addParam(paramName);
        }

        layer.push(macro);
        String[] body = new String[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            body[i] = sourceText(lines.get(i));
            visitMacline(lines.get(i));
        }

        macro.setBody(body);
        layer.poll();

        return name;
    }

    @Override
    public String visitMacline(CA65Parser.MaclineContext ctx) {
        if (ctx.LOCAL() != null) {
            Symbol parent = layer.peek();

            if (parent instanceof MacroDef) {
                MacroDef macro = (MacroDef) parent;

                for (CA65Parser.IdentifierContext identifier : ctx.identifier()) {
                    macro.addLocal(visitIdentifier(identifier));
                }
            }

            return null;
        } else if (ctx.MACRO() != null) {
            return visitMacro(ctx.identifier, ctx.param, ctx.macline(), true);
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitStorage(CA65Parser.StorageContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitControl(CA65Parser.ControlContext ctx) {
        String command = ctx.command.getText().substring(1).toUpperCase();
        return controlCommands.getOrDefault(command, this::visitUnknownControl).apply(ctx);
    }

    @Override
    public String visitExpansion(CA65Parser.ExpansionContext ctx) {
        Expansible def = macros.get(ctx.name.getText());
        Position argPos = new Position(ctx.start.getLine() - 1, parseInt(ctx.col.getText()));
        Expansible.Args args = def.getArgs(unquote(ctx.source.getText()), argPos);

        // Parse the arguments for new references
        for (Expansible.Arg arg : args) {
            CA65Visitor<String> argVisitor = new CA65BaseVisitor<String>() {

                @Override
                public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
                    if (ctx.IDENT() != null) {
                        return unquote(visit(ctx.expression()));
                    }

                    return ctx.Identifier().getSymbol().getText();
                }

                @Override
                public String visitLabelRef(CA65Parser.LabelRefContext ctx) {
                    Position pos = new Position(argPos.getLine(), arg.getIni());

                    if (ctx.UnnamedLabel() != null) {
                        String name = ctx.UnnamedLabel().getSymbol().getText().substring(1);
                        new UnnamedRef(name, path, pos)
                                .setParent(layer.peek())
                                .save();

                        return name;
                    }

                    Reference ancestor = ctx.global != null ? new Reference("", path, positionOf(ctx), null) : null;

                    for (int i = 0; i < ctx.identifier().size(); i++) {
                        CA65Parser.IdentifierContext identifier = ctx.identifier(i);
                        String name = visitIdentifier(identifier);
                        ancestor = new Reference(name, path, positionOf(identifier, pos), ancestor)
                                .setParent(layer.peek())
                                .save();
                    }

                    return visitChildren(ctx);
                }
            };

            argVisitor.visit(newParser(arg.getText()).expression());
        }

        offset--;
        Position position = new Position(ctx.start.getLine() + offset, parseInt(ctx.col.getText()));
        Expansion ref = new Expansion(def.getName(), path, position, def, args)
                .setParent(layer.peek())
                .save();
        expansion.push(ref);

        for (CA65Parser.LineContext line : ctx.line()) {
            try {
                visitLine(line);
            } catch (ExitMacroException e) {
                break;
            }
        }

        expansion.pop();
        offset -= parseInt(ctx.offset.getText());

        return null;
    }

    private String visitImport(CA65Parser.ControlContext ctx) {
        for (CA65Parser.ExpressionContext expression : ctx.expression()) {
            String name = visitExpression(expression);
            new Import(name, path, positionOf(ctx))
                    .setParent(layer.peek())
                    .save();
        }

        return null;
    }

    private String visitAutoImport(CA65Parser.ControlContext ctx) {
        if (ctx.PLUS() != null) {
            Symbol.Table.autoimport.add(path);
        } else if (ctx.MINUS() != null) {
            Symbol.Table.autoimport.remove(path);
        }

        return null;
    }

    private String visitExport(CA65Parser.ControlContext ctx) {
        for (CA65Parser.ExpressionContext expression : ctx.expression()) {
            String name = visitExpression(expression);
            new Export(name, path, positionOf(ctx))
                    .setParent(layer.peek())
                    .save();
        }

        return null;
    }

    private String visitGlobal(CA65Parser.ControlContext ctx) {
        for (CA65Parser.ExpressionContext expression : ctx.expression()) {
            String name = visitExpression(expression);
            new Global(name, path, positionOf(ctx))
                    .setParent(layer.peek())
                    .save();
        }

        return null;
    }

    private String visitInclude(CA65Parser.ControlContext ctx) {
        if (ctx.expression().isEmpty()) {
            return visitChildren(ctx);
        }

        String incName = unquote(visit(ctx.expression(0)));
        File incFile = new File(incName);
        Path incPath = null;

        // find the file
        if (incFile.exists()) {
            incPath = incFile.toPath().toAbsolutePath().normalize();
        } else {
            AtomicReference<Path> searchPath = new AtomicReference<>(path.getParent());

            while (incPath == null
                    && searchPath.get() != null
                    && workspaceDir.stream().anyMatch(dir -> dir.compareTo(searchPath.get()) <= 0)) {
                try {
                    incPath = Files.walk(searchPath.get(), 10, FileVisitOption.FOLLOW_LINKS)
                            .filter(visited -> visited.getFileName().toString().equals(incFile.getName()))
                            .map(visited -> visited.toAbsolutePath().normalize())
                            .findFirst()
                            .orElse(null);
                } catch (IOException e) {
                    log.error("Could not search included file: {}", incFile, e);
                }

                searchPath.set(searchPath.get().getParent());
            }
        }

        if (incPath != null) {
            new Include(incName, path, positionOf(ctx.expression(0)), incPath)
                    .setParent(layer.peek())
                    .save();
            // parse included file
            Path tmpPath = path;
            String tmpCode = code;
            path = incPath;

            parse(getCode(incPath));

            path = tmpPath;
            code = tmpCode;
        } else {
            log.warn("Included file not found in workspace: {}", incFile.getName());
        }

        for (int i = 1; i < ctx.expression().size(); i++) {
            visitExpression(ctx.expression(i)); // consumes invalid args
        }

        return null;
    }

    private String visitUnknownControl(CA65Parser.ControlContext ctx) {
        log.warn("Unknown control command: {}", ctx.command.getText());
        return visitChildren(ctx);
    }

    private Position positionOf(ParserRuleContext ctx) {
        try {
            return expansion.element().getPos();
        } catch (NoSuchElementException e) {
            return addOffset(Contexts.positionOf(ctx));
        }
    }

    private Position positionOf(ParserRuleContext ctx, Position posOffset) {
        try {
            return expansion.element().getPos();
        } catch (NoSuchElementException e) {
            return addOffset(Contexts.positionOf(ctx, posOffset));
        }
    }

    private Position addOffset(Position position) {
        position.setLine(position.getLine() + offset);
        return position;
    }

    private String eval(ParserRuleContext ctx) {
        eval = true;

        try {
            return visit(ctx);
        } finally {
            eval = false;
        }
    }

    private String replaceParams(List<String> params, Expansible.Args args, String[] body) {
        StringBuilder bodyBuilder = new StringBuilder();
        AtomicInteger lineOffset = new AtomicInteger(0);

        for (String line : body) {
            lineOffset.set(0);
            CA65Visitor<String> bodyVisitor = new CA65BaseVisitor<String>() {

                @Override
                public String visitExpansion(CA65Parser.ExpansionContext ctx) {
                    lineOffset.set(Integer.MAX_VALUE);
                    return visitChildren(ctx);
                }

                @Override
                @SuppressWarnings("StringOperationCanBeSimplified")
                public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
                    String paramText = ctx.Identifier().getText();

                    if (ctx.Identifier() != null) {
                        for (int i = 0; i < params.size(); i++) {
                            if (params.get(i).equals(paramText)) {
                                int paramCol = ctx.Identifier().getSymbol().getCharPositionInLine();
                                String arg = i < args.size() ? args.get(i).getText() : "";
                                bodyBuilder.append(line.substring(lineOffset.get(), paramCol)).append(arg);
                                lineOffset.set(paramCol + paramText.length());
                            }
                        }
                    }

                    return visitChildren(ctx);
                }
            };

            bodyVisitor.visit(newParser(line).program());

            if (lineOffset.get() < line.length()) {
                bodyBuilder.append(line.substring(lineOffset.get()));
            }

            bodyBuilder.append(lineSeparator());
        }

        char lastChar;
        int lastPos = bodyBuilder.length() - 1;
        while ((lastChar = bodyBuilder.charAt(lastPos)) == '\n' || lastChar == '\r') {
            bodyBuilder.deleteCharAt(lastPos--);
        }

        return bodyBuilder.toString();
    }

    private static String getCode(Path path) {
        return codeCache.computeIfAbsent(path, Paths::read);
    }

    private static CA65Parser newParser(String code) {
        CA65ErrorListener errorListener = new CA65ErrorListener();
        CodePointCharStream input = CharStreams.fromString(code);

        CA65Lexer lexer = new CA65Lexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CA65Parser parser = new CA65Parser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        return parser;
    }

    static class CA65ErrorListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            log.warn("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }
}
