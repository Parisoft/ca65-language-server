package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class MacroRef extends Expansion {

    public MacroRef(String name, Path path, Position pos, Expansible definition) {
        super(name, path, pos, definition);
    }
}
