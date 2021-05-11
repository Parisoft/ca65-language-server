package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.exception.ExpansionException;
import com.parisoft.ca65.lsp.parser.exception.NonConstantException;
import com.parisoft.ca65.lsp.parser.exception.StopException;
import com.parisoft.ca65.lsp.parser.grammar.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65BaseVisitor;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser.ControlContext;
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
import com.parisoft.ca65.lsp.parser.symbol.UnionDef;
import com.parisoft.ca65.lsp.parser.symbol.UnnamedRef;
import com.parisoft.ca65.lsp.parser.symbol.VarDef;
import com.parisoft.ca65.lsp.util.Contexts;
import com.parisoft.ca65.lsp.util.Paths;
import com.parisoft.ca65.lsp.util.Strings;
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
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.AUTOIMPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXITMACRO;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXPORTZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.GLOBAL;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.GLOBALZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.IMPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.IMPORTZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.INCLUDE;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.LOCAL;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.VOCABULARY;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.BANKBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoVar.CPU.CPU_6502;
import static com.parisoft.ca65.lsp.server.CA65LanguageServer.workspaceDir;
import static com.parisoft.ca65.lsp.util.Contexts.sourceText;
import static com.parisoft.ca65.lsp.util.Strings.isBlank;
import static com.parisoft.ca65.lsp.util.Strings.isNotBlank;
import static com.parisoft.ca65.lsp.util.Strings.removeTrailingLineBreaks;
import static com.parisoft.ca65.lsp.util.Strings.repeat;
import static com.parisoft.ca65.lsp.util.Strings.splitLines;
import static com.parisoft.ca65.lsp.util.Strings.unquote;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;
import static java.util.Collections.singletonList;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("Duplicates")
public class CodeParser extends AbstractParseTreeVisitor<String> implements CA65Visitor<String>, Runnable {

    private static final Logger log = LoggerFactory.getLogger(CodeParser.class);
    private static final Map<Path, String> codeCache = new ConcurrentHashMap<>();
    public static final ExecutorService pool = Executors.newSingleThreadExecutor();//ThreadPool.newThreadPool();
    private static final String EXPANSION_PUSH = "#expansion-push";
    private static final String EXPANSION_POP = "#expansion-pop";

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
    private final Deque<ProcDef> procStack = new ArrayDeque<>();
    private final Deque<ScopeDef> scopeStack = new ArrayDeque<>();
    private final Deque<EnumDef> enumStack = new ArrayDeque<>();
    private final Deque<StructDef> structStack = new ArrayDeque<>();
    private final Deque<MacroDef> macroStack = new ArrayDeque<>();
    private final Deque<Integer> repeatStack = new ArrayDeque<>();
    private final Deque<Boolean> ifStack = new ArrayDeque<>();
    private final Deque<Boolean> refStack = new ArrayDeque<>();
    private final Deque<Expansion> expansionStack = new ArrayDeque<>();
    private final Deque<Expansion> exitmacroStack = new ArrayDeque<>();
    private final Deque<Symbol> layer = new ArrayDeque<>();
    private final Map<String, Expansible> macros = new HashMap<>();
    private final Map<String, Function<ControlContext, String>> controlCommands = new HashMap<>();

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
        controlCommands.put(VOCABULARY.getSymbolicName(LOCAL), this::visitLocal);
        controlCommands.put(VOCABULARY.getSymbolicName(EXITMACRO), this::visitExitMacro);

        layer.push(new ScopeDef(Strings.EMPTY, path, new Position(0, 0))); // Push the global scope
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
        String expansion = String.format(EXPANSION_PUSH + " %s %d \"%s\"%n", def.getName(), position.getCharacter(), originalLine)
                + originalLine.substring(0, position.getCharacter()) + expandedBody + lineSeparator()
                + EXPANSION_POP + " " + def.getBody().length;
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
    @SuppressWarnings("ConstantConditions")
    public String visitLine(CA65Parser.LineContext ctx) {
        if (Thread.interrupted()) {
            throw new StopException();
        }

        boolean isNotExpanding = ctx.expansion() == null;

        if (exitMacro() && isNotExpanding) {
            return null;
        }

        boolean isNotEvaluatingIf = ctx.statement() == null || ctx.statement().ifStmt() == null;

        if (isIfConditionFalse() && isNotEvaluatingIf && isNotExpanding) {
            return null;
        }

        boolean isNotEndingMacro = ctx.statement() == null || ctx.statement().endStmt() == null || ctx.statement().endStmt().ENDMACRO() == null;

        if (isDefiningMacro() && isNotEndingMacro && isNotExpanding) {
            macroStack.peek().addLine(sourceText(ctx));
        }

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
        cache(new LabelDef(name, path, positionOf(ctx.identifier())));

        visit(ctx.expression());

        return name;
    }

    @Override
    public String visitLabelDef(CA65Parser.LabelDefContext ctx) {
        if (ctx.inlineLabel() != null) {
            return visitInlineLabel(ctx.inlineLabel());
        }

        String name = visit(ctx.identifier());
        cache(new LabelDef(name, path, positionOf(ctx.identifier())));

        return name;
    }

    @Override
    public String visitVarDef(CA65Parser.VarDefContext ctx) {
        String name = visitIdentifier(ctx.identifier());
        int value = parseInt(eval(ctx.expression()));
        cache(new VarDef(name, path, positionOf(ctx.identifier()), value));

        return name;
    }

    @Override
    public String visitInlineLabel(CA65Parser.InlineLabelContext ctx) {
        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : Strings.EMPTY;
        Symbol symbol = cache(new LabelDef(name, path, positionOf(ctx.identifier() != null ? ctx.identifier() : ctx)));

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
        boolean fake = isDefiningMacro() || isEvaluatingRef();

        if (ctx.UnnamedLabel() != null) {
            Token symbol = ctx.UnnamedLabel().getSymbol();
            String name = symbol.getText().substring(1);
            Position pos = new Position(symbol.getLine() - 1, symbol.getCharPositionInLine());
            cache(new UnnamedRef(name, path, pos)).setFake(fake);

            return name;
        }

        Reference ancestor = ctx.global != null ? new Reference(Strings.EMPTY, path, positionOf(ctx), null) : null;

        for (int i = 0; i < ctx.identifier().size(); i++) {
            CA65Parser.IdentifierContext identifier = ctx.identifier(i);
            String name = visitIdentifier(identifier);
            ancestor = cache(new Reference(name, path, positionOf(identifier), ancestor));
            ancestor.setFake(fake);
        }

        if (ancestor != null) {
            if (eval) {
                Definition def = ancestor.getDefinition();

                if (def instanceof Constant) {
                    return valueOf(((Constant) def).getValue());
                }

                throw new NonConstantException();
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
                        return valueOf(expansionStack.element().getArgs().size());
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
        ProcDef proc = cache(new ProcDef(name, path, positionOf(ctx.identifier())));

        procStack.push(proc);
        layer.push(proc);

        return name;
    }

    @Override
    public String visitScope(CA65Parser.ScopeContext ctx) {
        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : Strings.EMPTY;
        Position position = positionOf(ctx.identifier() != null ? ctx.identifier() : ctx);
        ScopeDef scope = cache(new ScopeDef(name, path, position));

        scopeStack.push(scope);
        layer.push(scope);

        return name;
    }

    @Override
    public String visitEnumerator(CA65Parser.EnumeratorContext ctx) {
        EnumDef enumerator;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            enumerator = cache(new EnumDef(name, path, positionOf(ctx.identifier())));
            layer.push(enumerator);
        } else {
            enumerator = cache(new EnumDef(Strings.EMPTY, path, positionOf(ctx)));
        }

        enumStack.push(enumerator);

        ctx.member.forEach(this::visitEnumMember);

        return enumerator.getName();
    }

    @Override
    public String visitEnumMember(CA65Parser.EnumMemberContext ctx) {
        EnumDef enumerator = enumStack.peek();

        if (enumerator == null) {
            return visitChildren(ctx);
        }

        CA65Parser.LabelEquContext equ = ctx.labelEqu();
        CA65Parser.IdentifierContext identifier;
        String name;

        if (equ != null) {
            identifier = equ.identifier();
            name = visitIdentifier(identifier);
            enumerator.setLastValue(parseInt(visitExpression(equ.expression())));
        } else {
            identifier = ctx.identifier();
            name = visitIdentifier(identifier);
        }

        cache(new Enumeration(name, path, positionOf(identifier), enumerator.getAndIncLastValue()));

        return name;
    }

    @Override
    public String visitStruct(CA65Parser.StructContext ctx) {
        StructDef struct;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            struct = cache(new StructDef(name, path, positionOf(ctx.identifier())));
            layer.push(struct);
        } else {
            struct = cache(new StructDef(Strings.EMPTY, path, positionOf(ctx.identifier())));
        }

        structStack.push(struct);

        ctx.member.forEach(this::visitStructMember);

        return valueOf(struct.getSize());
    }

    @Override
    public String visitUnion(CA65Parser.UnionContext ctx) {
        UnionDef union;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            union = cache(new UnionDef(name, path, positionOf(ctx.identifier())));
            layer.push(union);
        } else {
            union = cache(new UnionDef(Strings.EMPTY, path, positionOf(ctx.identifier())));
        }

        structStack.push(union);

        ctx.member.forEach(this::visitStructMember);

        return valueOf(union.getSize());
    }

    @Override
    public String visitStructMember(CA65Parser.StructMemberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitField(CA65Parser.FieldContext ctx) {
        StructDef struct = structStack.peek();

        if (struct == null) {
            return visitChildren(ctx);
        }

        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : null;
        Position pos = positionOf(ctx.identifier() != null ? ctx.identifier() : ctx.expression());
        int fieldSize = ctx.expression() != null ? parseInt(visitExpression(ctx.expression())) : 1;

        if (ctx.WORD() != null || ctx.DWORD() != null || ctx.ADDR() != null) {
            fieldSize *= 2;
        } else if (ctx.FARADDR() != null) {
            fieldSize *= 3;
        }

        if (name != null) {
            cache(new FieldDef(name, path, pos, struct.getSize(), fieldSize));
        }

        struct.addSize(fieldSize);

        return valueOf(fieldSize);
    }

    @Override
    public String visitIf(CA65Parser.IfContext ctx) {
        boolean condition = false;

        switch (ctx.type.getText().toUpperCase()) {
            case ".IF":
                condition = parseInt(eval(ctx.expression())) != 0;
                break;
            case ".IFBLANK":
                condition = isBlank(unquote(visitExpression(ctx.expression())));
                break;
            case ".IFCONST":
                try {
                    eval(ctx.expression());
                    condition = true;
                } catch (NonConstantException e) {
                    condition = false;
                }
                break;
            case ".IFDEF":
                condition = macros.get(eval(ctx.expression())) instanceof DefineDef;
                break;
            case ".IFNBLANK":
                condition = isNotBlank(unquote(visitExpression(ctx.expression())));
                break;
            case ".IFNDEF":
                condition = !(macros.get(eval(ctx.expression())) instanceof DefineDef);
                break;
            case ".IFNREF":
                refStack.push(true);
                visitExpression(ctx.expression());
                refStack.poll();

                Position exprPos = positionOf(ctx.expression());

                Definition def = Symbol.Table.references(path)
                        .filter(ref -> ref.getPos().getLine() == exprPos.getLine())
                        .max(comparingInt(ref -> ref.getPos().getCharacter()))
                        .map(Reference::getDefinition)
                        .orElse(null);

                if (def != null) {
                    condition = Symbol.Table.references().parallel().filter(Reference::isNotFake).noneMatch(def::isDefinitionOf);
                }
                break;
            case ".IFP02":
                condition = (cpu & PseudoVar.CPU.CPU_ISET_6502.value()) != 0;
                break;
            case ".IFP4510":
                condition = (cpu & PseudoVar.CPU.CPU_ISET_4510.value()) != 0;
                break;
            case ".IFP816":
                condition = (cpu & PseudoVar.CPU.CPU_ISET_65816.value()) != 0;
                break;
            case ".IFPC02":
                condition = (cpu & PseudoVar.CPU.CPU_ISET_65C02.value()) != 0;
                break;
            case ".IFPDTV":
                condition = (cpu & PseudoVar.CPU.CPU_ISET_6502DTV.value()) != 0;
                break;
            case ".IFPSC02":
                condition = (cpu & PseudoVar.CPU.CPU_ISET_65SC02.value()) != 0;
                break;
            case ".IFREF":
                refStack.push(true);
                visitExpression(ctx.expression());
                refStack.poll();

                exprPos = positionOf(ctx.expression());

                def = Symbol.Table.references(path)
                        .filter(ref -> ref.getPos().getLine() == exprPos.getLine())
                        .max(comparingInt(ref -> ref.getPos().getCharacter()))
                        .map(Reference::getDefinition)
                        .orElse(null);

                if (def != null) {
                    condition = Symbol.Table.references().parallel().filter(Reference::isNotFake).anyMatch(def::isDefinitionOf);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown if statement: " + ctx.type.getText());
        }

        if (isNotDefiningMacro()) {
            ifStack.push(condition);
        }

        return null;
    }

    @Override
    public String visitElseIf(CA65Parser.ElseIfContext ctx) {
        boolean elseifCondition = parseInt(eval(ctx.expression())) != 0;

        if (isNotDefiningMacro()) {
            Boolean ifCondition = ifStack.poll();

            if (ifCondition != null && ifCondition) {
                ifStack.push(false);
            } else {
                ifStack.push(elseifCondition);
            }
        }

        return null;
    }

    @Override
    public String visitElse(CA65Parser.ElseContext ctx) {
        if (isNotDefiningMacro()) {
            Boolean ifCondition = ifStack.poll();
            ifStack.push(ifCondition == null || !ifCondition);
        }

        return null;
    }

    @Override
    public String visitRepeat(CA65Parser.RepeatContext ctx) {
        int repN = parseInt(eval(ctx.expression()));

        if (ctx.identifier() != null) {
            int tmpOffset = offset;
            String repI = visitIdentifier(ctx.identifier());

            Symbol repeatDef = cache(new RepeatDef(path, positionOf(ctx)));

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
                repeatStack.push(i);
                offset = tmpOffset + ctx.start.getLine();

                String[] body = ctx.line().stream()
                        .map(line -> repeat(' ', line.start.getCharPositionInLine()) + sourceText(line))
                        .toArray(String[]::new);
                Expansible.Args args = new Expansible.Args(new Expansible.Arg(valueOf(i), 0, 0));
                List<String> params = singletonList(repI);
                String expandedBody = replaceParams(params, args, body);

                visit(newParser(expandedBody).program());
                repeatStack.poll();
            }

            offset = tmpOffset;
        } else {
            for (int i = 0; i < repN; i++) {
                repeatStack.push(i);
                ctx.line().forEach(this::visitLine);
                repeatStack.poll();
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

        define.addLine(sourceText(ctx.expression()));

        layer.push(define);
        visitExpression(ctx.expression());
        layer.poll();

        return name;
    }

    @Override
    public String visitMacro(CA65Parser.MacroContext ctx) {
        Expansible parentMac = macroStack.peek();
        String name = visitIdentifier(ctx.name);
        MacroDef macro = new MacroDef(name, path, positionOf(ctx.name));

        if (parentMac != null) {// It's a inner macro
            macro.setParent(parentMac).save();
        } else {
            macro.setParent(layer.peekFirst()).save();
            macros.put(name, macro);
        }

        for (CA65Parser.IdentifierContext param : ctx.param) {
            String paramName = visitIdentifier(param);
            new ParamDef(paramName, path, positionOf(param))
                    .setParent(macro)
                    .save();
            macro.addParam(paramName);
        }

        macroStack.push(macro);
        layer.push(macro);

        return name;
    }

    @Override
    public String visitEndStmt(CA65Parser.EndStmtContext ctx) {
        switch (ctx.end.getText().substring(1).toUpperCase()) {
            case "ENDPROC":
                ProcDef proc = procStack.poll();

                if (proc != null && isNotBlank(proc.getName())) {
                    layer.poll();
                }

                break;
            case "ENDSCOPE":
                ScopeDef scope = scopeStack.poll();

                if (scope != null && isNotBlank(scope.getName())) {
                    layer.poll();
                }

                break;
            case "ENDENUM":
                EnumDef enumerator = enumStack.poll();

                if (enumerator != null && isNotBlank(enumerator.getName())) {
                    layer.poll();
                }

                break;
            case "ENDSTRUCT":
            case "ENDUNION":
                StructDef struct = structStack.poll();
                StructDef parent = structStack.peek();

                if (struct != null) {
                    if (isNotBlank(struct.getName())) {
                        layer.poll();
                    }

                    if (parent != null) {
                        parent.addSize(struct.getSize());
                    }
                }

                break;
            case "ENDMACRO":
            case "ENDMAC":
                macroStack.poll();
                layer.poll();
                break;

            case "ENDIF":
                ifStack.poll();
                break;
        }

        return null;
    }

    @Override
    public String visitStorage(CA65Parser.StorageContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitControl(ControlContext ctx) {
        String command = ctx.command.getText().substring(1).toUpperCase();
        return controlCommands.getOrDefault(command, this::visitUnknownControl).apply(ctx);
    }

    @Override
    public String visitExpansion(CA65Parser.ExpansionContext ctx) {
        Integer repeatI = repeatStack.peek();

        if (repeatI != null && repeatI > 0) {// Only process an Expansion once inside a repeat loop
            return null;
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitExpansionPush(CA65Parser.ExpansionPushContext ctx) {
        Expansible def = macros.get(ctx.name.getText());
        Position argPos = new Position(ctx.start.getLine() - 1, parseInt(ctx.col.getText()));
        Expansible.Args args = def.getArgs(unquote(ctx.source.getText()), argPos);

        // Parse the arguments for new references
        for (Expansible.Arg arg : args) {
            CA65Visitor<String> argVisitor = new CA65BaseVisitor<String>() {

                @Override
                public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
                    if (ctx.IDENT() != null) {
                        return unquote(visitExpression(ctx.expression()));
                    }

                    return ctx.Identifier().getSymbol().getText();
                }

                @Override
                public String visitLabelRef(CA65Parser.LabelRefContext ctx) {
                    Position pos = new Position(argPos.getLine(), arg.getIni());

                    if (ctx.UnnamedLabel() != null) {
                        String name = ctx.UnnamedLabel().getSymbol().getText().substring(1);
                        cache(new UnnamedRef(name, path, pos));

                        return name;
                    }

                    Reference ancestor = ctx.global != null ? new Reference(Strings.EMPTY, path, positionOf(ctx), null) : null;

                    for (int i = 0; i < ctx.identifier().size(); i++) {
                        CA65Parser.IdentifierContext identifier = ctx.identifier(i);
                        String name = visitIdentifier(identifier);
                        ancestor = cache(new Reference(name, path, positionOf(identifier, pos), ancestor));
                    }

                    return visitChildren(ctx);
                }
            };

            argVisitor.visit(newParser(arg.getText()).expression());
        }

        offset--;
        Position position = new Position(ctx.start.getLine() + offset, parseInt(ctx.col.getText()));
        Expansion ref = cache(new Expansion(def.getName(), path, position, def, args));
        expansionStack.push(ref);

        return null;
    }

    @Override
    public String visitExpansionPop(CA65Parser.ExpansionPopContext ctx) {
        Expansion expansion = expansionStack.poll();
        offset -= parseInt(ctx.offset.getText());

        if (Objects.equals(expansion, exitmacroStack.peek())) {
            exitmacroStack.poll();
        }

        return null;
    }

    private String visitImport(ControlContext ctx) {
        for (CA65Parser.ExpressionContext expression : ctx.expression()) {
            String name = visitExpression(expression);
            cache(new Import(name, path, positionOf(ctx)));
        }

        return null;
    }

    private String visitAutoImport(ControlContext ctx) {
        if (ctx.PLUS() != null) {
            Symbol.Table.autoimport.add(path);
        } else if (ctx.MINUS() != null) {
            Symbol.Table.autoimport.remove(path);
        }

        return null;
    }

    private String visitExport(ControlContext ctx) {
        for (CA65Parser.ExpressionContext expression : ctx.expression()) {
            String name = visitExpression(expression);
            cache(new Export(name, path, positionOf(ctx)));
        }

        return null;
    }

    private String visitGlobal(ControlContext ctx) {
        for (CA65Parser.ExpressionContext expression : ctx.expression()) {
            String name = visitExpression(expression);
            cache(new Global(name, path, positionOf(ctx)));
        }

        return null;
    }

    private String visitInclude(ControlContext ctx) {
        if (ctx.expression().isEmpty()) {
            return visitChildren(ctx);
        }

        String incName = unquote(visitExpression(ctx.expression(0)));
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
            cache(new Include(incName, path, positionOf(ctx.expression(0)), incPath));
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

    private String visitLocal(ControlContext ctx) {
        MacroDef macro = macroStack.peek();

        if (macro != null) {
            for (CA65Parser.ExpressionContext expression : ctx.expression()) {
                macro.addLocal(visitExpression(expression));
            }

            return null;
        }

        return visitChildren(ctx);
    }

    private String visitExitMacro(ControlContext ctx) {
        Expansion expansion = expansionStack.peek();

        if (expansion != null) {
            exitmacroStack.push(expansion);
        }

        return visitChildren(ctx);
    }

    private String visitUnknownControl(ControlContext ctx) {
        log.warn("Unknown control command: {}", ctx.command.getText());
        return visitChildren(ctx);
    }

    private boolean isDefiningMacro() {
        return macroStack.size() > 0;
    }

    private boolean isNotDefiningMacro() {
        return macroStack.isEmpty();
    }

    private boolean isIfConditionFalse() {
        try {
            return !ifStack.element();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isEvaluatingRef() {
        return refStack.size() > 0;
    }

    private boolean exitMacro() {
        return exitmacroStack.size() > 0;
    }

    private Position positionOf(ParserRuleContext ctx) {
        try {
            return expansionStack.element().getPos();
        } catch (NoSuchElementException e) {
            return addOffset(Contexts.positionOf(ctx));
        }
    }

    private Position positionOf(ParserRuleContext ctx, Position posOffset) {
        try {
            return expansionStack.element().getPos();
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

    private <T extends Symbol> T cache(T symbol) {
        return symbol.setParent(layer.peek()).save();
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
                                String arg = i < args.size() ? args.get(i).getText() : Strings.EMPTY;
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

        return removeTrailingLineBreaks(bodyBuilder).toString();
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
