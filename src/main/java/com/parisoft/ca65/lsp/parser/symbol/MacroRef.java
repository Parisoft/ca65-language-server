package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class MacroRef extends Reference {

    public MacroRef(String name, Path path, Position pos, Reference ancestor) {
        super(name, path, pos, ancestor);
    }
}
