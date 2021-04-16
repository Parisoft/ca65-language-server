package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.grammar.CA65BaseVisitor;
import com.parisoft.ca65.lsp.grammar.CA65Parser;
import org.antlr.v4.runtime.Token;

public class CA65POCVisitor extends CA65BaseVisitor<Void> {

    @Override
    public Void visitLabelDef(CA65Parser.LabelDefContext labelDef) {
        if (labelDef.identifier() != null) {
            if (labelDef.identifier().IDENT() != null) {
                System.out.println("[.ident]");
            } else {
                Token symbol = labelDef.identifier().Identifier().getSymbol();
                System.out.println("[label] " + symbol.getText() + " at " + symbol.getLine());
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

}
