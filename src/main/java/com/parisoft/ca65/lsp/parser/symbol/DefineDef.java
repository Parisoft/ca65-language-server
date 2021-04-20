package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class DefineDef extends Symbol {

    public DefineDef(String name, Path path, int line) {
        super(name, path, line);
    }
}
