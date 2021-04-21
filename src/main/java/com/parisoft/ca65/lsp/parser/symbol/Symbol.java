package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Symbol {

    private final String name;
    private final Path path;
    private final int line;
    private Symbol parent;

    public Symbol(String name, Path path, int line) {
        this.name = name;
        this.path = path;
        this.line = line;
    }

    public void save(){
        Table.put(this);
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public int getLine() {
        return line;
    }

    public Symbol getParent() {
        return parent;
    }

    public void setParent(Symbol parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Symbol that = (Symbol) o;

        return this.line == that.line &&
                this.name.equals(that.name) &&
                this.path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, line);
    }

    public static class Table {

        public static final Map<String, Map<Path, Map<Integer, Symbol>>> map = new ConcurrentHashMap<>();

        public static Symbol put(Symbol symbol) {
            return map.computeIfAbsent(symbol.name, s -> new HashMap<>())
                    .computeIfAbsent(symbol.path, p -> new HashMap<>())
                    .put(symbol.line, symbol);
        }
    }
}
