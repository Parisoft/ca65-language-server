package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class LocalDef extends Definition {

    public LocalDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }
}
