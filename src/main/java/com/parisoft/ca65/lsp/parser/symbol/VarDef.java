package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class VarDef extends Symbol {

    private int value;

    public VarDef(String name, Path path, int line) {
        super(name, path, line);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
