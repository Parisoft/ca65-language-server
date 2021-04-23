package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Global extends Symbol {

    public Global(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Global save() {
        Table.globals.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}
