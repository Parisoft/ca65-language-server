package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class VarDef extends Symbol {

    private final int value;

    public VarDef(String name, Path path, int line, int value) {
        super(name, path, line);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
