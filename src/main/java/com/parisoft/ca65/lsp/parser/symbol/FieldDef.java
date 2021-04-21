package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class FieldDef extends Symbol {

    private final int offset;
    private final int size;

    public FieldDef(String name, Path path, int line, int offset, int size) {
        super(name, path, line);
        this.offset = offset;
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }
}
