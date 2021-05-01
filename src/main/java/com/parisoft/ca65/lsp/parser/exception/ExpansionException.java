package com.parisoft.ca65.lsp.parser.exception;

import com.parisoft.ca65.lsp.parser.symbol.Expansible;
import org.eclipse.lsp4j.Position;

public class ExpansionException extends RuntimeException {

    private final Expansible  expansible;
    private final Position position;

    public ExpansionException(Expansible expansible, Position position) {
        this.expansible = expansible;
        this.position = position;
    }

    public Expansible getExpansible() {
        return expansible;
    }

    public Position getPosition() {
        return position;
    }
}
