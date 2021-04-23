package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class VarDef extends Constant {

    public VarDef(String name, Path path, Position pos, int value) {
        super(name, path, pos, value);
    }
}
