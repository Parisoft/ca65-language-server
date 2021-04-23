package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Reference extends Symbol {

    final Reference ancestor;

    public Reference(String name, Path path, Position pos, Reference ancestor) {
        super(name, path, pos);
        this.ancestor = ancestor;
    }

    public boolean canReference(Definition def) {
        Reference refAncestor = this.ancestor;
        Symbol defParent = def.parent;

        // matches the reference ancestry with definition hierarchy
        while (refAncestor != null) {
            if (defParent == null || !refAncestor.getName().equals(defParent.getName())) {
                return false;
            }

            refAncestor = refAncestor.ancestor;
            defParent = defParent.parent;
        }

        // matches the reference hierarchy with definition hierarchy


        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Reference save() {
        Table.references.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}
