package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public abstract class Constant extends Definition {

    final int value;

    Constant(String name, Path path, Position pos, int value) {
        super(name, path, pos);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
