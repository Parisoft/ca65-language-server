package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.grammar.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.CA65Token;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Visitor;
import com.parisoft.ca65.lsp.parser.lang.PseudoVar;
import com.parisoft.ca65.lsp.parser.symbol.EnumDef;
import com.parisoft.ca65.lsp.parser.symbol.Enumeration;
import com.parisoft.ca65.lsp.parser.symbol.Export;
import com.parisoft.ca65.lsp.parser.symbol.FieldDef;
import com.parisoft.ca65.lsp.parser.symbol.Import;
import com.parisoft.ca65.lsp.parser.symbol.Include;
import com.parisoft.ca65.lsp.parser.symbol.LabelDef;
import com.parisoft.ca65.lsp.parser.symbol.ProcDef;
import com.parisoft.ca65.lsp.parser.symbol.Reference;
import com.parisoft.ca65.lsp.parser.symbol.ScopeDef;
import com.parisoft.ca65.lsp.parser.symbol.StructDef;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
import com.parisoft.ca65.lsp.parser.symbol.UnnamedRef;
import com.parisoft.ca65.lsp.parser.symbol.VarDef;
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
import java.net.URI;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.AUTOIMPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.EXPORTZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.IMPORT;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.IMPORTZP;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.INCLUDE;
import static com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer.VOCABULARY;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.BANKBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOWORD;
import static com.parisoft.ca65.lsp.server.CA65LanguageServer.workspaceDir;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@SuppressWarnings("Duplicates")
public class CodeParser extends AbstractParseTreeVisitor<String> implements CA65Visitor<String> {

    private static final Logger log = LoggerFactory.getLogger(CodeParser.class);

    private String code;
    private Path path;
    private int checkpoint = 0;
    private int paramcount = 0;
    private boolean eval = false;
    private int cpu = PseudoVar.CPU.CPU_6502.value();
    private int asize = 8;
    private int isize = 8;
    private Deque<Integer> cpuStack = new ArrayDeque<>();
    private Deque<Integer> asizeStack = new ArrayDeque<>();
    private Deque<Integer> isizeStack = new ArrayDeque<>();
    private List<String> macros = new ArrayList<>();
    private List<String> defines = new ArrayList<>();
    private Deque<Symbol> layer = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(URI.create(args[0])).normalize();
        byte[] bytes = Files.readAllBytes(path);
        new CodeParser(new String(bytes), path).parse();
        System.out.println(IdentFinder.find(path, 6, 16));
    }

    public CodeParser(String code, Path path) {
        this.code = code;
        this.path = path;

        layer.push(new ScopeDef("", path, new Position(0, 0))); // Push the global scope
    }

    public void parse() {
        CA65ErrorListener errorListener = new CA65ErrorListener();
        CodePointCharStream input = CharStreams.fromString(code);

        CA65Lexer lexer = new CA65Lexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CA65Parser parser = new CA65Parser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        visit(parser.program());
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
        setCheckpoint(ctx);
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
        setCheckpoint(ctx);

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

        setCheckpoint(ctx);

        String name = visit(ctx.identifier());
        Symbol symbol = new LabelDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        layer.push(symbol);

        return name;
    }

    @Override
    public String visitVarDef(CA65Parser.VarDefContext ctx) {
        setCheckpoint(ctx);

        String name = visitIdentifier(ctx.identifier());
        int value = parseInt(eval(ctx.expression()));
        new VarDef(name, path, positionOf(ctx.identifier()), value)
                .setParent(layer.peek())
                .save();

        return name;
    }

    @Override
    public String visitInlineLabel(CA65Parser.InlineLabelContext ctx) {
        setCheckpoint(ctx);

        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : "";
        Symbol symbol = new LabelDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        layer.push(symbol);

        return name;
    }

    @Override
    public String visitMultiplicative(CA65Parser.MultiplicativeContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

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
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

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
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

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
            return parseInt(visit(ctx.expression())) == 0 ? "0" : "1";
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
            int value = parseInt(visit(ctx.expression()));

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
            int value = parseInt(visit(ctx.expression()));

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
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

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
            new UnnamedRef(name, path, pos, null)
                    .setParent(layer.peek())
                    .save();

            return name;
        }

        Reference ancestor = null;

        for (int i = 0; i < ctx.identifier().size(); i++) {
            CA65Parser.IdentifierContext identifier = ctx.identifier(i);
            String name = visitIdentifier(identifier);
            Reference ref = new Reference(name, path, positionOf(identifier), ancestor)
                    .setParent(layer.peek())
                    .save();

            if (eval && i == ctx.identifier().size() - 1) {
                // TODO Search for a constant definition whose parent is owner
                return null;
            }

            ancestor = ref;
        }

        return ancestor == null ? null : ancestor.getName();
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
                    return valueOf(paramcount);
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
        //TODO check if identifier is a macro/define

        if (ctx.IDENT() != null) {
            return visit(ctx.expression());
        }

        return ctx.Identifier().getSymbol().getText();
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
        setCheckpoint(ctx);

        String name = visitIdentifier(ctx.identifier());
        Symbol proc = new ProcDef(name, path, positionOf(ctx.identifier()))
                .setParent(layer.peek())
                .save();

        layer.push(proc);
        ctx.line().forEach(this::visitLine);
        pop(proc);

        return name;
    }

    @Override
    public String visitScope(CA65Parser.ScopeContext ctx) {
        setCheckpoint(ctx);

        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : "";
        Position position = positionOf(ctx.identifier() != null ? ctx.identifier() : ctx);
        ScopeDef scope = new ScopeDef(name, path, position)
                .setParent(layer.peek())
                .save();

        layer.push(scope);
        ctx.line().forEach(this::visitLine);
        pop(scope);

        return name;
    }

    @Override
    public String visitEnumerator(CA65Parser.EnumeratorContext ctx) {
        setCheckpoint(ctx);

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
            setCheckpoint(member);

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
        setCheckpoint(ctx);

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
                setCheckpoint(field);

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
        setCheckpoint(ctx);

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
                setCheckpoint(field);

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
        return visitChildren(ctx);
    }

    @Override
    public String visitDefine(CA65Parser.DefineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMacro(CA65Parser.MacroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMacline(CA65Parser.MaclineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitStorage(CA65Parser.StorageContext ctx) {
        setCheckpoint(ctx);
        return visitChildren(ctx);
    }

    @Override
    public String visitControl(CA65Parser.ControlContext ctx) {
        setCheckpoint(ctx);

        String command = ctx.command.getText().substring(1);

        if (command.equalsIgnoreCase(VOCABULARY.getSymbolicName(IMPORT))
                || command.equalsIgnoreCase(VOCABULARY.getSymbolicName(IMPORTZP))) {
            for (CA65Parser.ExpressionContext expression : ctx.expression()) {
                String name = visit(expression);
                new Import(name, path, positionOf(ctx))
                        .setParent(layer.peek())
                        .save();
            }

            return null;
        }

        if (command.equalsIgnoreCase(VOCABULARY.getSymbolicName(AUTOIMPORT))) {
            if (ctx.PLUS() != null) {
                Symbol.Table.autoimport.add(path);
            } else if (ctx.MINUS() != null) {
                Symbol.Table.autoimport.remove(path);
            }

            return null;
        }

        if (command.equalsIgnoreCase(VOCABULARY.getSymbolicName(EXPORT))
                || command.equalsIgnoreCase(VOCABULARY.getSymbolicName(EXPORTZP))) {
            for (CA65Parser.ExpressionContext expression : ctx.expression()) {
                String name = visit(expression);
                new Export(name, path, positionOf(ctx))
                        .setParent(layer.peek())
                        .save();
            }

            return null;
        }

        if (command.equalsIgnoreCase(VOCABULARY.getSymbolicName(INCLUDE))) {
            if (ctx.expression().isEmpty()) {
                return visitChildren(ctx);
            }

            File incFile = new File(visit(ctx.expression(0)));
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
                        incPath = Files.walk(searchPath.get(), 5, FileVisitOption.FOLLOW_LINKS)
                                .filter(visited -> visited.getFileName().toString().equals(incFile.getName()))
                                .findFirst()
                                .orElse(null);
                    } catch (IOException e) {
                        log.error("Could not search included file: {}", incFile, e);
                    }

                    searchPath.set(searchPath.get().getParent());
                }
            }

            if (incPath != null) {
                new Include(incPath, positionOf(ctx))
                        .setParent(layer.peek())
                        .save();
                // parse included file
                try {
                    Path tmpPath = path;
                    String tmpCode = code;
                    path = incPath;
                    code = new String(Files.readAllBytes(incPath));
                    parse();
                    path = tmpPath;
                    code = tmpCode;
                } catch (IOException e) {
                    log.error("Could not open included file to parse: {}", incPath, e);
                }
            }

            for (int i = 1; i < ctx.expression().size(); i++) {
                visit(ctx.expression(i)); // consumes invalid args
            }

            return null;
        }

        return visitChildren(ctx);
    }

    private void setCheckpoint(ParserRuleContext ctx) {
        checkpoint = ((CA65Token) ctx.start).getPrvIndex();
    }

    private static Position positionOf(ParserRuleContext ctx) {
        return new Position(ctx.getStart().getLine() - 1, ctx.getStart().getCharPositionInLine());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private void pop(Symbol symbol) {
        while (layer.poll() != symbol) ;
    }

    private String eval(ParserRuleContext ctx) {
        eval = true;

        try {
            return visit(ctx);
        } finally {
            eval = false;
        }
    }

    static class CA65ErrorListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            log.warn("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }
}
