package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class DefineRef extends Symbol {

    public DefineRef(String name, Path path, int line) {
        super(name, path, line);
    }
}