package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class LabelDef extends Definition {

    public LabelDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    @Override
    public boolean isUnnamed() {
        return name.isEmpty();
    }
}
