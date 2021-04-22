package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class FieldDef extends Constant {

    private int size;

    public FieldDef(String name, Path path, int line, int offset) {
        super(name, path, line, offset);
    }

    public int getOffset() {
        return value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
