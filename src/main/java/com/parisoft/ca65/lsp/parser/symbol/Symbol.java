package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;

public abstract class Symbol {

    @SuppressWarnings("unused") static final Logger log = LoggerFactory.getLogger(Symbol.class);

    final String name;
    final Path path;
    final Position pos;
    Symbol parent;

    Symbol(String name, Path path, Position pos) {
        this.name = name;
        this.path = path;
        this.pos = pos;
    }

    public boolean match(Position position) {
        return pos.getLine() == position.getLine()
                && pos.getCharacter() <= position.getCharacter()
                && pos.getCharacter() + name.length() >= position.getCharacter();
    }

    public Location toLocation() {
        Position end = new Position(pos.getLine(), pos.getCharacter());
        end.setCharacter(end.getCharacter() + name.length());
        return new Location(path.toUri().toString(), new Range(pos, end));
    }

    public abstract <S extends Symbol> S save();

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public Position getPos() {
        return pos;
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

    boolean sameParents(Symbol that) {
        if (that == null) {
            return false;
        }

        Symbol thisParent = this.parent;
        Symbol thatParent = that.parent;

        while (thisParent != null && thisParent.equals(thatParent)) {
            thisParent = thisParent.parent;
            thatParent = thatParent.parent;
        }

        return thatParent == null;
    }

    public static class Table {

        public static final Map<Path, Set<Definition>> definitions = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Reference>> references = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Import>> imports = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Export>> exports = new ConcurrentHashMap<>();
        public static final Map<Path, Set<Global>> globals = new ConcurrentHashMap<>();
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

        public static Stream<Import> imports(Path path) {
            return imports.getOrDefault(path, emptySet()).stream();
        }

        public static Stream<Import> imports() {
            return imports.values().stream().flatMap(Set::stream);
        }

        public static Stream<Export> exports(Path path) {
            return exports.getOrDefault(path, emptySet()).stream();
        }

        public static Stream<Export> exports() {
            return exports.values().stream().flatMap(Set::stream);
        }

        public static Stream<Global> globals(Path path) {
            return globals.getOrDefault(path, emptySet()).stream();
        }

        public static Stream<Global> globals() {
            return globals.values().stream().flatMap(Set::stream);
        }

        public static Stream<Include> includes(Path path) {
            return includes.get(path).stream();
        }
    }
}
