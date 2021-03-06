package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

import java.nio.file.Path;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Include extends Symbol {

    private final Path target;

    public Include(String name, Path path, Position pos, Path target) {
        super(name, path, new Position(pos.getLine(), pos.getCharacter() + 1));
        this.target = target;
    }

    public boolean match(Position position) {
        return pos.getLine() == position.getLine()
                && pos.getCharacter() <= position.getCharacter()
                && pos.getCharacter() + name.length() >= position.getCharacter();
    }

    public LocationLink toLocationLink() {
        Range targetRange = new Range(new Position(0, 0), new Position(10, 0));
        Range originSelectionRange = new Range(pos, new Position(pos.getLine(), pos.getCharacter() + name.length()));
        Range targetSelectionRange = new Range(targetRange.getStart(), new Position(0, 0));

        return new LocationLink(target.toUri().toString(), targetRange, targetSelectionRange, originSelectionRange);
    }

    boolean isOrIncludes(Path path) {
        return target.equals(path)
                || Table.includes(target).anyMatch(include -> include.isOrIncludes(path));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Include save() {
        Table.includes.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}
