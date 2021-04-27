package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.stream.Stream;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public abstract class Definition extends Symbol {

    Definition(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    boolean isExported() {
        return Stream.concat(Table.exports(), Table.globals())
                .filter(export -> export.name.equals(this.name))
                .anyMatch(this::sameParents);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Definition save() {
        Table.definitions.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}
