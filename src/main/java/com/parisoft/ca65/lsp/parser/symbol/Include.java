package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Include extends Symbol {

    public Include(Path path, Position pos) {
        super("", path, pos);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Include save() {
        Table.includes.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}