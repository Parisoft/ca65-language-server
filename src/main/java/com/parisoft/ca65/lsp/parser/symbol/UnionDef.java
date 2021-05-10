package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class UnionDef extends StructDef {

    public UnionDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    @Override
    public void addSize(int other) {
        size = Math.max(size, other);
    }
}
