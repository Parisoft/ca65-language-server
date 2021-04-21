package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class ProcDef extends Symbol {

    public ProcDef(String name, Path path, int line) {
        super(name, path, line);
    }
}
