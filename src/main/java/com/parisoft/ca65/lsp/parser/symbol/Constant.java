package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public abstract class Constant extends Definition {

    final int value;

    Constant(String name, Path path, int line, int value) {
        super(name, path, line);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
