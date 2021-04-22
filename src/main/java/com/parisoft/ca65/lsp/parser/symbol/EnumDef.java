package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class EnumDef extends Constant {

    public EnumDef(String name, Path path, int line, int value) {
        super(name, path, line, value);
    }
}
