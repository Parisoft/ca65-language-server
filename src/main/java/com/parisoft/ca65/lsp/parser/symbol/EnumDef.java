package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class EnumDef extends Definition {

    public EnumDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }
}
