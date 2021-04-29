package com.parisoft.ca65.lsp.parser.exception;

import com.parisoft.ca65.lsp.parser.symbol.DefineDef;
import org.eclipse.lsp4j.Position;

public class DefineExpansionException extends RuntimeException {

    private final DefineDef define;
    private final Position position;

    public DefineExpansionException(DefineDef define, Position position) {
        this.define = define;
        this.position = position;
    }

    public DefineDef getDefine() {
        return define;
    }

    public Position getPosition() {
        return position;
    }
}
