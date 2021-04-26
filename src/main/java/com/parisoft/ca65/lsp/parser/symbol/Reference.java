package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

import static java.util.Comparator.comparingInt;
import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Reference extends Symbol {

    private final Reference ancestor;

    public Reference(String name, Path path, Position pos, Reference ancestor) {
        super(name, path, pos);
        this.ancestor = ancestor;
    }

    public Definition getDefinition() {
        return Table.definitions()
                .filter(this::canReference)
                .min(comparingInt(this::distanceFrom))
                .orElse(null);
    }

    private boolean canReference(Definition def) {
        if (canAccess(def)) { // reference and definition in same file
            if (def instanceof LabelDef) {
                return true; // labels can have forward reference
            }

            if (def.path.equals(this.path)) { // reference and definition in exactly same file
                return def.pos.getLine() <= this.pos.getLine();
            } else { // definition is included by the reference
                return Table.includes(this.path)
                        .anyMatch(include -> include.isOrIncludes(def.path));
            }
        }

        return def instanceof LabelDef
                && ((LabelDef) def).isExported()
                && this.isImported();
    }

    private boolean canAccess(Symbol symbol) {
        // matches the reference ancestry with symbol hierarchy
        Symbol thatTopParent = topParentOf(symbol);

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
        return thisTopParent.sameParents(thatTopParent);
    }

    private Symbol topParentOf(Symbol symbol) {
        Reference ancestor = this;

        while (ancestor != null) {
            if (symbol == null || !ancestor.name.equals(symbol.name)) {
                return null;
            }

            ancestor = ancestor.ancestor;
            symbol = symbol.parent;
        }

        return symbol;
    }

    private boolean isImported() {
        return Table.imports()
                .filter(anImport -> anImport.name.equals(this.name))
                .anyMatch(this::canAccess);
    }

    private int distanceFrom(Definition def) {
        Symbol defParent = topParentOf(def);
        Symbol refParent = this.parent;
        int dist = 0;

        while (refParent != null && !refParent.equals(defParent)){
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
}
