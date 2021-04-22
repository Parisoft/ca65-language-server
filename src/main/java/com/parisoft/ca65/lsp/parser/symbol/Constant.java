package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class Constant extends Symbol {

    final int value;

    Constant(String name, Path path, int line, int value) {
        super(name, path, line);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
