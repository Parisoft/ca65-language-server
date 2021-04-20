package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class LabelRef extends Symbol {

    public LabelRef(String name, Path path, int line) {
        super(name, path, line);
    }
}
