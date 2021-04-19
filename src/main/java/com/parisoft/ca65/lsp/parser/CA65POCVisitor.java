package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.grammar.CA65BaseVisitor;
import com.parisoft.ca65.lsp.grammar.CA65Lexer;
import com.parisoft.ca65.lsp.grammar.CA65Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import static java.lang.System.lineSeparator;

public class CA65POCVisitor extends CA65BaseVisitor<Void> {

    private final CA65Parser parser;
    private final CA65Lexer lexer;

    public CA65POCVisitor(CA65Parser parser, CA65Lexer lexer) {
        this.parser = parser;
        this.lexer = lexer;
    }

    @Override
    public Void visitLabelDef(CA65Parser.LabelDefContext labelDef) {
        if (labelDef.identifier() != null) {
            printState();

            if (labelDef.identifier().IDENT() != null) {
                System.out.println("[.ident]");
            } else {
                Token symbol = labelDef.identifier().Identifier().getSymbol();
                System.out.println("[label] " + symbol.getText() + " at " + symbol.getLine());

                if (symbol.getText().equals("oba")){
                    String code = ""
                            + "foo:"
                            + lineSeparator()
                            + ".boba:"
                            + lineSeparator()
                            + "bar:";
                    lexer.reset();
                    lexer.setInputStream(CharStreams.fromString(code));
                    parser.reset();
                    parser.setInputStream(new CommonTokenStream(lexer));
                }
            }

            return null;
        }

        return visitChildren(labelDef);
    }

    @Override
    public Void visitInlineLabel(CA65Parser.InlineLabelContext label) {
        printState();
        String name = label.identifier() != null
                ? label.identifier().Identifier().getSymbol().getText()
                : ":";
        System.out.println("[label] " + name + " at ?");

        return null;
    }

    @Override
    public Void visitMacro(CA65Parser.MacroContext mac) {
        printState();
        System.out.println("[macro] " + getText(mac));
        return super.visitMacro(mac);
    }

    private static String getText(ParserRuleContext ctx) {
        return ctx.getStart().getInputStream().getText(new Interval(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex()));
    }

    private void printState() {
        System.out.println("[state:" + lexer.getState() + "]");
    }
}
