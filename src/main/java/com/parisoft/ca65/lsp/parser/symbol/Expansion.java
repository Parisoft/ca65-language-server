package com.parisoft.ca65.lsp.parser.symbol;

import com.parisoft.ca65.lsp.parser.symbol.Expansible.Args;
import org.eclipse.lsp4j.Position;

import java.nio.file.Path;

public class Expansion extends Reference {

    final Expansible definition;
    final Args args;
    String text;

    Expansion(String name, Path path, Position pos, Expansible definition, Args args) {
        super(name, path, pos, null);
        this.definition = definition;
        this.args = args;
    }

    @Override
    public Expansible getDefinition() {
        return definition;
    }

    public Args getArgs() {
        return args;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
