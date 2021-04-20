package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.grammar.g4.CA65BaseVisitor;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

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
            if (labelDef.identifier().IDENT() != null) {
                System.out.println("[.ident]");
            } else {
                Token symbol = labelDef.identifier().Identifier().getSymbol();
                System.out.println("[label] " + symbol.getText() + " at " + symbol.getLine());
                System.out.println(symbol);
            }

            return null;
        }

        return visitChildren(labelDef);
    }

    @Override
    public Void visitInlineLabel(CA65Parser.InlineLabelContext label) {
        String name = label.identifier() != null
                ? label.identifier().Identifier().getSymbol().getText()
                : ":";
        System.out.println("[label] " + name + " at ?");

        return null;
    }

    @Override
    public Void visitMacro(CA65Parser.MacroContext mac) {
        System.out.println("[macro] " + getText(mac));
        return super.visitMacro(mac);
    }

    private static String getText(ParserRuleContext ctx) {
        return ctx.getStart().getInputStream().getText(new Interval(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex()));
    }

}
