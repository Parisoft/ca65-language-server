package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class StructDcl extends Symbol {

    private int size;

    public StructDcl(String name, Path path, int line) {
        super(name, path, line);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
