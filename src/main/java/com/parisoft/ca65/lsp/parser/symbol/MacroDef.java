package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class MacroDef extends Definition {

    public MacroDef(String name, Path path, int line) {
        super(name, path, line);
    }
}
