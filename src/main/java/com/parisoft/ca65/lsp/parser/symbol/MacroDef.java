package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MacroDef extends Expansible {

    private List<String> locals = new ArrayList<>();

    public MacroDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    @Override
    public void validate(Args args) {
        args.setInvalid(false);
    }

    public List<String> getLocals() {
        return locals;
    }

    public void addLocal(String local) {
        locals.add(local);
    }
}
