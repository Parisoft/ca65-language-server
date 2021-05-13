package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.Arrays;

public class UnnamedRef extends Reference {

    private final int fwd;
    private final int bwd;

    public UnnamedRef(String name, Path path, Position pos) {
        super(name, path, pos, null);

        if (name.length() == 0) {
            fwd = bwd = 0;
        } else if (name.charAt(0) == '+') {
            fwd = name.length();
            bwd = 0;
        } else {
            fwd = 0;
            bwd = name.length();
        }
    }

    @Override
    public Definition getDefinition() {
        if (fwd > 0) {
            Definition[] definitions = Table.definitions()
                    .filter(Symbol::isUnnamed)
                    .filter(def -> def.compareLine(this) > 0)
                    .sorted(Definition::compareLine)
                    .toArray(Definition[]::new);
            if (definitions.length >= fwd) {
                return definitions[fwd - 1];
            }
        } else if (bwd > 0) {
            Definition[] definitions = Table.definitions()
                    .filter(Symbol::isUnnamed)
                    .filter(def -> def.compareLine(this) < 0
                            || (def.pos.getLine() == this.pos.getLine() && def.path.equals(this.path)))
                    .sorted(Definition::compareLine)
                    .toArray(Definition[]::new);
            if (definitions.length >= bwd) {
                return definitions[definitions.length - bwd];
            }
        }

        return null;
    }

    @Override
    public boolean isUnnamed() {
        return true;
    }
}
