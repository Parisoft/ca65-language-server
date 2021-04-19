package com.parisoft.ca65.lsp.parser.symbol;

import java.nio.file.Path;
import java.util.Objects;

public class Symbol {

    private final String name;
    private final Path path;
    private final int line;

    public Symbol(String name, Path path, int line) {
        this.name = name;
        this.path = path;
        this.line = line;
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
}
