package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class SymbolRef extends Symbol {

    private final String owner;

    public SymbolRef(String name, Path path, int line, String owner) {
        super(name, path, line);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
