package com.parisoft.ca65.lsp.parser.symbol;

import org.apache.commons.text.StringSubstitutor;
import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static com.parisoft.ca65.lsp.util.Strings.countLines;
import static com.parisoft.ca65.lsp.util.Strings.splitLines;
import static java.lang.System.lineSeparator;

public class Expansion extends Reference {

    final Expansible definition;
    String text;

    Expansion(String name, Path path, Position pos, Expansible definition) {
        super(name, path, pos, null);
        this.definition = definition;
    }

    public String[] expand(String line, Position position, Expansible.Args args) {
        Map<String, String> argMap = new HashMap<>();

        for (int i = 0; i < args.size(); i++) {
            argMap.put(definition.params.get(i), args.get(i).text);
        }

        for (int i = args.size(); i < definition.params.size(); i++) {
            argMap.put(definition.params.get(i), "");
        }

        text = line.substring(0, position.getCharacter())
                + new StringSubstitutor(argMap).replace(definition.body)
                + (args.end < line.length() ? line.substring(args.end) : "");

        String expansion = "#expansion-push " + definition.getName()
                + lineSeparator() + text + lineSeparator()
                + "#expansion-pop " + countLines(text);

        return splitLines(expansion);
    }

    @Override
    public Expansible getDefinition() {
        return definition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
