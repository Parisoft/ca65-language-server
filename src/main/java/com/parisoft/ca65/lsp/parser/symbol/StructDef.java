package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class StructDef extends Definition {

    int size = 0;

    public StructDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addSize(int amount) {
        size += amount;
    }
}
