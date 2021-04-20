package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.grammar.CA65Token;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Visitor;
import com.parisoft.ca65.lsp.parser.lang.PseudoVar;
import com.parisoft.ca65.lsp.parser.symbol.LabelDef;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
import com.parisoft.ca65.lsp.parser.symbol.VarDef;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.BANKBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOWORD;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;

public class CodeParser extends AbstractParseTreeVisitor<String> implements CA65Visitor<String> {

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
    private Deque<Symbol> layer = new ArrayDeque<>();

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

        String name = visit(ctx.identifier());
        int line = getLine(ctx);
        LabelDef symbol = new LabelDef(name, path, line);
        symbol.setParent(layer.peek());

        visit(ctx.expression());

        Symbol.Table.put(symbol);

        return name;
    }

    @Override
    public String visitLabelDef(CA65Parser.LabelDefContext ctx) {
        if (ctx.inlineLabel() != null) {
            return visit(ctx.inlineLabel());
        }

        setCheckpoint(ctx);

        String name = visit(ctx.identifier());
        int line = getLine(ctx);
        LabelDef symbol = new LabelDef(name, path, line);
        symbol.setParent(layer.peek());

        layer.push(symbol);

        Symbol.Table.put(symbol);

        return name;
    }

    @Override
    public String visitVarDef(CA65Parser.VarDefContext ctx) {
        setCheckpoint(ctx);

        String name = visit(ctx.identifier());
        int line = getLine(ctx);
        VarDef symbol = new VarDef(name, path, line);
        symbol.setParent(layer.peek());
        symbol.setValue(parseInt(eval(ctx.expression())));

        Symbol.Table.put(symbol);

        return name;
    }

    @Override
    public String visitInlineLabel(CA65Parser.InlineLabelContext ctx) {
        setCheckpoint(ctx);

        String name = ctx.identifier() != null ? visit(ctx.identifier()) : "";
        int line = getLine(ctx);
        LabelDef symbol = new LabelDef(name, path, line);
        symbol.setParent(layer.peek());

        layer.push(symbol);

        Symbol.Table.put(symbol);

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
        return visitChildren(ctx);
    }

    @Override
    public String visitVarRef(CA65Parser.VarRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitFunctionRef(CA65Parser.FunctionRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLiteral(CA65Parser.LiteralContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitStatement(CA65Parser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitProc(CA65Parser.ProcContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitScope(CA65Parser.ScopeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitEnumerator(CA65Parser.EnumeratorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitStruct(CA65Parser.StructContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitUnion(CA65Parser.UnionContext ctx) {
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
        return visitChildren(ctx);
    }

    @Override
    public String visitControl(CA65Parser.ControlContext ctx) {
        return visitChildren(ctx);
    }

    private void setCheckpoint(ParserRuleContext ctx) {
        checkpoint = ((CA65Token) ctx.start).getPrvIndex();
    }

    private static int getLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
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

        int errors = 0;

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errors++;

            super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        }
    }
}
