package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class MacroDef extends Expansible {

    public MacroDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    @Override
    public void validate(Args args) {
        args.setInvalid(false);
    }
}
