package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.stream.Stream;

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
            LoggerFactory.getLogger(Reference.class).debug("Comparing\n{}\nVS\n{}", refAncestor, defParent);
            if (defParent == null || !refAncestor.getName().equals(defParent.getName())) {
                return false;
            }

            refAncestor = refAncestor.ancestor;
            defParent = defParent.parent;
        }

        // same file, no need to export/import
        if (this.path.equals(def.path)) {
            return this.canAccess(def);
        }

        // definition file included into reference file
        if (Table.includes(this.path).anyMatch(include -> include.path.equals(def.path))) {
            return this.canAccess(def);
        }

        if (def instanceof LabelDef) {
            if (Stream.concat(Table.exports(), Table.globals())
                    .filter(export -> export.name.equals(def.name))
                    .allMatch(this::canAccess)) {
                return false; // definition not exported
            }

            return Table.autoimport.contains(this.path) // return if it is imported
                    || Stream.concat(Table.imports(), Table.globals())
                    .filter(imp -> imp.name.equals(def.name))
                    .anyMatch(this::canAccess);
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Reference save() {
        Table.references.computeIfAbsent(path, p -> newKeySet()).add(this);
        return this;
    }
}
