package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;

public class SymbolRef extends Reference {

    private String owner;

    public SymbolRef(String name, Path path, int line) {
        super(name, path, line);
    }

    public String getOwner() {
        return owner;
    }

    public SymbolRef setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
