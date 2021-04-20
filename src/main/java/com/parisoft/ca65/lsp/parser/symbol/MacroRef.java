package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class MacroRef extends Symbol {

    public MacroRef(String name, Path path, int line) {
        super(name, path, line);
    }
}
