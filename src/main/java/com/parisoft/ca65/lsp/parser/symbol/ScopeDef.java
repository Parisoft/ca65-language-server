package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class ScopeDef extends Symbol {

    public ScopeDef(String name, Path path, int line) {
        super(name, path, line);
    }
}
