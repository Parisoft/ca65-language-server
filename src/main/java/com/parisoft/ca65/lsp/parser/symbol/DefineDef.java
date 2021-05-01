package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DefineDef extends Expansible {

    public DefineDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    @Override
    public void validate(Args args) {
        args.setInvalid(args.size() != params.size());
    }
}
