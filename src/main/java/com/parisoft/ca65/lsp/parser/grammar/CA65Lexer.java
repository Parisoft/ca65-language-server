package com.parisoft.ca65.lsp.parser.grammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class CA65Lexer extends com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer {

    public CA65Lexer(CharStream input) {
        super(input);
    }

    @Override
    public Token nextToken() {
        int prvIndex = getInputStream().index();
        Token curToken = super.nextToken();
        return new CA65Token(curToken, prvIndex);
    }
}
