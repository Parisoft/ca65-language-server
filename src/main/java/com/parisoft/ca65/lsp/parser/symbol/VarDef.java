package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class VarDef extends Constant {

    public VarDef(String name, Path path, int line, int value) {
        super(name, path, line, value);
    }
}
