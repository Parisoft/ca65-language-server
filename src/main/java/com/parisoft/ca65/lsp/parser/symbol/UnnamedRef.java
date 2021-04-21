package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class UnnamedRef extends Symbol {

    private final int fwd;
    private final int bwd;

    public UnnamedRef(String name, Path path, int line) {
        super(name, path, line);

        if (name.charAt(1) == '+') {
            fwd = name.length();
            bwd = 0;
        } else {
            fwd = 0;
            bwd = name.length();
        }
    }

    public int getFwd() {
        return fwd;
    }

    public int getBwd() {
        return bwd;
    }
}
