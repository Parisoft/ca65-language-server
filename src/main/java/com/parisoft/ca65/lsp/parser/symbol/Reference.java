package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Reference extends Symbol {

    private final Reference ancestor;
    private boolean fake = false; // it's a .ifref argument

    public Reference(String name, Path path, Position pos, Reference ancestor) {
        super(name, path, pos);
        this.ancestor = ancestor;
    }

    public boolean isFake() {
        return fake;
    }

    public boolean isNotFake() {
        return !fake;
    }

    public void setFake() {
        this.fake = true;
    }

    public Definition getDefinition() {
        return Table.definitions()
                .filter(this::canReference)
                .min(comparingInt(this::distanceFrom))
                .orElse(null);
    }

    private boolean canReference(Definition def) {
        if (canAccess(def)) { // reference and definition in same file
            if (def instanceof LabelDef || def instanceof ProcDef) {
                return true; // labels can have forward reference
            }

            if (def.path.equals(this.path)) { // reference and definition in exactly same file
                return def.pos.getLine() <= this.pos.getLine();
            } else {
                return Table.includes(this.path)// definition is included by the reference
                        .filter(include -> include.isOrIncludes(def.path))
                        .anyMatch(include -> include.pos.getLine() <= this.pos.getLine())
                        || Table.includes(def.path)// OR reference is included by the definition
                        .filter(include -> include.isOrIncludes(this.path))
                        .anyMatch(include -> include.pos.getLine() >= def.pos.getLine());
            }
        }

        return (def instanceof LabelDef || def instanceof ProcDef)
                && def.isExported()
                && this.isImported();
    }

    private boolean canAccess(Symbol symbol) {
        // matches the reference ancestry with symbol hierarchy
        Symbol thatTopParent = relativeParentOf(symbol);

        if (thatTopParent == null) {
            return false;
        }

        // reference must access the symbol parent
        Symbol thisTopParent = this.parent;

        while (thisTopParent != null && !thisTopParent.equals(thatTopParent)) {
            thisTopParent = thisTopParent.parent;
        }

        if (thisTopParent == null) {
            return false;
        }

        // matches left most ancestor hierarchy with symbol hierarchy
        return thisTopParent.equalParents(thatTopParent);
    }

    private Symbol relativeParentOf(Symbol symbol) {
        Reference ancestor = this;

        while (ancestor != null) {
            if (!ancestor.name.equals(symbol.name)) {
                return null;
            }

            ancestor = ancestor.ancestor;

            if (symbol.parent != null) {
                symbol = symbol.parent;
            } else if (ancestor != null) {
                return null;
            }
        }

        return symbol;
    }

    private boolean isImported() {
        return Stream.concat(Table.imports(), Table.globals())
                .filter(anImport -> anImport.name.equals(this.name))
                .anyMatch(this::canAccess);
    }

    private int distanceFrom(Definition def) {
        Symbol defParent = relativeParentOf(def);
        Symbol refParent = this.parent;
        int dist = 0;

        while (refParent != null && !refParent.equals(defParent)) {
            refParent = refParent.parent;
            dist++;
        }

        return dist;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Reference save() {
        Table.references.computeIfAbsent(path, p -> newKeySet()).add(this);
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

        if (!super.equals(o)) {
            return false;
        }

        Reference reference = (Reference) o;

        return Objects.equals(ancestor, reference.ancestor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ancestor);
    }
}
