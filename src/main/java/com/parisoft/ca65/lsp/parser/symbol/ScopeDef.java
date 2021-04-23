package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class ScopeDef extends Definition {

    public ScopeDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }
}
