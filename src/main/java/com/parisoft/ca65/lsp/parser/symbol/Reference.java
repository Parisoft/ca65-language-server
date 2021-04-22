package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public abstract class Reference extends Symbol {

    public Reference(String name, Path path, int line) {
        super(name, path, line);
    }
}
