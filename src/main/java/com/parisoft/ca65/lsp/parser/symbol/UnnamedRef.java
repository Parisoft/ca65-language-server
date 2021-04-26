package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class UnnamedRef extends Reference {

    final int fwd;
    final int bwd;

    public UnnamedRef(String name, Path path, Position pos) {
        super(name, path, pos, null);

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
