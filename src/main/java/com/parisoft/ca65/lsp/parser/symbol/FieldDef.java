package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class FieldDef extends Constant {

    final int size;

    public FieldDef(String name, Path path, Position pos, int offset, int size) {
        super(name, path, pos, offset);
        this.size = size;
    }

    public int getOffset() {
        return value;
    }

    public int getSize() {
        return size;
    }
}
