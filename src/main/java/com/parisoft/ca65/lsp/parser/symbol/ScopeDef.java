package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class ScopeDef extends Definition {

    public ScopeDef(String name, Path path, int line) {
        super(name, path, line);
    }
}
