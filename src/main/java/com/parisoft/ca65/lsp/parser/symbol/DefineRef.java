package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class DefineRef extends Expansion {

    public DefineRef(String name, Path path, Position pos, Expansible definition, Expansible.Args args) {
        super(name, path, pos, definition, args);
    }
}
