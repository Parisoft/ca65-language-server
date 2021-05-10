package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class EnumDef extends Definition {

    private int lastValue;

    public EnumDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    public int getLastValue() {
        return lastValue;
    }

    public void setLastValue(int lastValue) {
        this.lastValue = lastValue;
    }

    public int getAndIncLastValue() {
        return lastValue++;
    }
}
