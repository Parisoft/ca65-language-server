package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.grammar.CA65Token;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Visitor;
import com.parisoft.ca65.lsp.parser.lang.PseudoVar;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
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

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.System.lineSeparator;

public class CodeParser extends AbstractParseTreeVisitor<Integer> implements CA65Visitor<Integer> {

    private Path path;
    private String code;
    private int checkpoint = 0;
    private boolean eval = false;
    private int cpu = PseudoVar.CPU_6502;
    private int asize = 8;
    private int isize = 8;
    private Deque<Integer> cpuStack = new ArrayDeque<>();
    private Deque<Integer> asizeStack = new ArrayDeque<>();
    private Deque<Integer> isizeStack = new ArrayDeque<>();
    private List<String> macros = new ArrayList<>();
    private List<String> defines = new ArrayList<>();

    public static void main(String[] args) {
        String code = ""
                + "foo: ;comment"
                + lineSeparator()
                + "oba boba"
                + lineSeparator()
                + "bar:"
                + lineSeparator()
                + "\t.mac lza\n"
                + "\tlda #0\n"
                + "\t.endmac";
        CA65ErrorListener errorListener = new CA65ErrorListener();
        CodePointCharStream input = CharStreams.fromString(code);
//        input.seek(23);//start before "bar:"
        CA65Lexer lexer = new CA65Lexer(input);
        CA65Parser parser = new CA65Parser(new CommonTokenStream(lexer));
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);
        new CA65POCVisitor(parser, lexer).visit(parser.program());
        System.out.println("Errors: " + errorListener.errors);
    }

    @Override
    public Integer visitProgram(CA65Parser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLine(CA65Parser.LineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitInstruction(CA65Parser.InstructionContext ctx) {
        setCheckpoint(ctx);
        return visitChildren(ctx);
    }

    @Override
    public Integer visitIndirectInstruction(CA65Parser.IndirectInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLabelEqu(CA65Parser.LabelEquContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLabelDef(CA65Parser.LabelDefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitVarDef(CA65Parser.VarDefContext ctx) {
        setCheckpoint(ctx);

        Token token = ctx.identifier().Identifier().getSymbol();
        String name = token.getText();
        int line = token.getLine();
        VarDef symbol = new VarDef(name, path, line);

        eval = true;
        symbol.setValue(visitChildren(ctx));
        eval = false;

        Symbol.TABLE
                .computeIfAbsent(name, s -> new ConcurrentHashMap<>())
                .computeIfAbsent(path, s->new ConcurrentHashMap<>())
                .put(line, symbol);

        return symbol.getValue();
    }

    @Override
    public Integer visitInlineLabel(CA65Parser.InlineLabelContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMultiplicative(CA65Parser.MultiplicativeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitAdditive(CA65Parser.AdditiveContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitBitwise(CA65Parser.BitwiseContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitNegation(CA65Parser.NegationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitPrimary(CA65Parser.PrimaryContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitExtraction(CA65Parser.ExtractionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitUnary(CA65Parser.UnaryContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitComparative(CA65Parser.ComparativeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitPrimaryExpression(CA65Parser.PrimaryExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLabelRef(CA65Parser.LabelRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitVarRef(CA65Parser.VarRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitFunctionRef(CA65Parser.FunctionRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitIdentifier(CA65Parser.IdentifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLiteral(CA65Parser.LiteralContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStatement(CA65Parser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitProc(CA65Parser.ProcContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitScope(CA65Parser.ScopeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitEnumerator(CA65Parser.EnumeratorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStruct(CA65Parser.StructContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitUnion(CA65Parser.UnionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitField(CA65Parser.FieldContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitIfStmt(CA65Parser.IfStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitElseif(CA65Parser.ElseifContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitElseStmt(CA65Parser.ElseStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitRepeat(CA65Parser.RepeatContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitDefine(CA65Parser.DefineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMacro(CA65Parser.MacroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitMacline(CA65Parser.MaclineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStorage(CA65Parser.StorageContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitControl(CA65Parser.ControlContext ctx) {
        return visitChildren(ctx);
    }

    private void setCheckpoint(ParserRuleContext ctx) {
        checkpoint = ((CA65Token) ctx.start).getPrvIndex();
    }

    static class CA65ErrorListener extends BaseErrorListener {

        int errors = 0;

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errors++;

            super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        }
    }
}
