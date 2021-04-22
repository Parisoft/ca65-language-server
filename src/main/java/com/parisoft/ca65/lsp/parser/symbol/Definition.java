package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public abstract class Definition extends Symbol {

    Definition(String name, Path path, int line) {
        super(name, path, line);
    }
}
