package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class LabelDef extends Symbol {

    public LabelDef(String name, Path path, int line) {
        super(name, path, line);
    }
}
