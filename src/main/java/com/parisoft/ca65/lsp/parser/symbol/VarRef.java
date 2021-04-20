package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class VarRef extends Symbol {

    public VarRef(String name, Path path, int line) {
        super(name, path, line);
    }
}
