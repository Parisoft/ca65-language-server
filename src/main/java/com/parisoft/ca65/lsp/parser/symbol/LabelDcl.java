package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class LabelDcl extends Symbol {

    public LabelDcl(String name, Path path, int line) {
        super(name, path, line);
    }
}
