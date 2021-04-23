package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;

public abstract class Symbol {

    final String name;
    final Path path;
    final Position pos;
    Symbol parent;

    Symbol(String name, Path path, Position pos) {
        this.name = name;
        this.path = path;
        this.pos = pos;
    }

    public abstract <S extends Symbol> S save();

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public Symbol getParent() {
        return parent;
    }

    public Symbol setParent(Symbol parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Symbol symbol = (Symbol) o;

        return name.equals(symbol.name) &&
                path.equals(symbol.path) &&
                pos.equals(symbol.pos) &&
                Objects.equals(parent, symbol.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, pos, parent);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", path=" + path +
                ", pos=" + pos +
                ", parent=" + parent +
                '}';
    }

    public static class Table {

        public static final Map<Path, Set<Definition>> definitions = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Reference>> references = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Import>> imports = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Export>> exports = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Include>> includes = new ConcurrentHashMap<>();
        public static final Set<Path> autoimport = ConcurrentHashMap.newKeySet();

        public static Stream<Definition> definitions(Path path) {
            return definitions.getOrDefault(path, emptySet()).stream();
        }

        public static Stream<Definition> definitions() {
            return definitions.values().stream().flatMap(Set::stream);
        }

        public static Stream<Reference> references(Path path) {
            return references.getOrDefault(path, emptySet()).stream();
        }

        public static Stream<Reference> references() {
            return references.values().stream().flatMap(Set::stream);
        }

        public static Stream<Symbol> symbols(Path path) {
            return Stream.concat(definitions(path), references(path));
        }

        public static Stream<Symbol> symbols() {
            return Stream.concat(definitions(), references());
        }
    }
}
