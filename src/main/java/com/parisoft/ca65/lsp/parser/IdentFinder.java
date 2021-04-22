package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.grammar.g4.CA65BaseVisitor;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.RuleNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IdentFinder extends CA65BaseVisitor<String> {

    public static final String SEPARATOR = ",";

    private final int column;

    public IdentFinder(int column) {
        this.column = column;
    }

    public static String find(Path path, int line, int column) throws IOException {
        String text = Files.readAllLines(path).get(line);
        CA65Lexer lexer = new CA65Lexer(CharStreams.fromString(text));
        lexer.removeErrorListeners();
        CA65Parser parser = new CA65Parser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();

        return new IdentFinder(column).visitProgram(parser.program());
    }

    @Override
    public String visitLabelRef(CA65Parser.LabelRefContext ctx) {
        if (ctx.UnnamedLabel() == null) {
            for (int i = 0; i < ctx.identifier().size(); i++) {
                String identifier = visitIdentifier(ctx.identifier(i));

                if (identifier == null || identifier.isEmpty()) {
                    continue;
                }

                if (i > 0) {
                    return ctx.identifier(i - 1).Identifier().getSymbol().getText() + SEPARATOR + identifier;
                }

                return identifier;
            }
        }

        return super.visitLabelRef(ctx);
    }

    @Override
    public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
        if (ctx.IDENT() != null) {
            return null;
        }

        Token symbol = ctx.Identifier().getSymbol();
        int column = symbol.getCharPositionInLine();
        String text = symbol.getText();

        if (this.column >= column && this.column <= column + text.length()) {
            return text;
        }

        return visitChildren(ctx);
    }

    @Override
    protected boolean shouldVisitNextChild(RuleNode node, String currentResult) {
        return currentResult == null || currentResult.isEmpty();
    }

}
