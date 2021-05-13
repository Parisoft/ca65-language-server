package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public abstract class Definition extends Symbol {

    Definition(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    public boolean isDefinitionOf(Reference reference) {
        if (reference == null) {
            return false;
        }

        if (this.name.equals(reference.name)) {
            Definition that = reference.getDefinition();

            if (this == that) {
                return true;
            }

            if (that == null || this.getClass() != that.getClass()) {
                return false;
            }

            return this.name.equals(that.name) &&
                    this.path.equals(that.path) &&
                    this.pos.equals(that.pos);
        }

        return false;
    }

    public int compareLine(Symbol that) {
        if (this.path.equals(that.path)) {
            return Integer.compare(this.pos.getLine(), that.pos.getLine());
        }

        return Table.includes(path)
                .filter(include -> include.isOrIncludes(that.path))
                .mapToInt(include -> Integer.compare(this.pos.getLine(), include.pos.getLine()))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(0);
    }

    boolean isExported() {
        return Stream.concat(Table.exports(), Table.globals())
                .filter(export -> export.name.equals(this.name))
                .anyMatch(this::equalParents);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Definition save() {
        Table.definitions.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}
