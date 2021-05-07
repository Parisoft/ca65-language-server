package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class RepeatDef extends Definition {

    public RepeatDef(Path path, Position pos) {
        super("", path, pos);
    }
}
