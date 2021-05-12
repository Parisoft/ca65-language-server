package com.parisoft.ca65.lsp.parser.symbol;

import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.parisoft.ca65.lsp.util.Strings.isNotBlank;

public class RepeatDef extends Definition {

    private final List<String> lines = new ArrayList<>();
    private final int offset;
    private final int n;
    private int i;

    public RepeatDef(String iName, Path path, Position pos, int n, int offset) {
        super(iName, path, pos);
        this.n = n;
        this.offset = offset;
    }

    public List<String> getLines() {
        return lines;
    }

    public int getOffset() {
        return offset;
    }

    public int getN() {
        return n;
    }

    public int getI() {
        return i;
    }

    public int incI() {
        return ++i;
    }

    public boolean hasParam(){
        return isNotBlank(name);
    }
}
