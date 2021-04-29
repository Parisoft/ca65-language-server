package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DefineDef extends Definition {

    private final List<String> params = new ArrayList<>();
    private final List<String> args = new ArrayList<>();
    private String body;

    public DefineDef(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    public List<String> getParams() {
        return params;
    }

    public void addParam(String param) {
        params.add(param);
        args.add("${" + param + "}");
    }

    public void setBody(String body) {
        for (String param : params) {
            Pattern pattern = Pattern.compile("([^a-zA-Z0-9_@\\\\?$])(" + param + ")([^a-zA-Z0-9_@\\\\?$])");
            body = pattern.matcher(body).replaceAll("$1\\${" + param + "}$2");
        }

        this.body = body;
    }
}
