package com.parisoft.ca65.lsp.parser.grammar;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class CA65Token extends CommonToken {

    private final int prvIndex;

    public CA65Token(Token oldToken, int prvIndex) {
        super(oldToken);
        this.prvIndex = prvIndex;
    }

    public int getPrvIndex() {
        return prvIndex;
    }
}
