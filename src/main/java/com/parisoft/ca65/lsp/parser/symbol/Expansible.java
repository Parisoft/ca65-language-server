package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.parisoft.ca65.lsp.util.Strings.indexOfNonSpace;
import static com.parisoft.ca65.lsp.util.Strings.removeTrailingLineBreaks;
import static com.parisoft.ca65.lsp.util.Strings.splitLines;
import static java.lang.System.lineSeparator;

public abstract class Expansible extends Definition {

    final List<String> params = new ArrayList<>();
    private final StringBuilder lines = new StringBuilder();
    private String[] body;

    Expansible(String name, Path path, Position pos) {
        super(name, path, pos);
    }

    public abstract void validate(Args args);

    public List<String> getParams() {
        return params;
    }

    public void addParam(String param) {
        params.add(param);
    }

    public void addLine(String line) {
        lines.append(line).append(lineSeparator());
    }

    public String[] getBody() {
        if (body == null) {
            body = splitLines(removeTrailingLineBreaks(lines).toString());
        }

        return body;
    }

    public Args getArgs(String line, Position position) {
        int startIndex = indexOfNonSpace(line, position.getCharacter() + name.length());
        int endIndex = startIndex;
        int closeIndex = 0;
        int brackets = 0;
        Args args = new Args();

        while (endIndex < line.length() && args.size() < params.size()) {
            switch (line.charAt(endIndex)) {
                case '{':
                    brackets++;
                    break;
                case '}':
                    brackets--;
                    closeIndex = endIndex;
                    break;
                case ',':
                    if (brackets == 0) {
                        args.add(line, startIndex, endIndex, closeIndex);
                        startIndex = endIndex = indexOfNonSpace(line, endIndex + 1);
                    }
                    continue;
            }

            endIndex++;
        }

        if (startIndex < endIndex && endIndex == line.length() && brackets == 0) {
            args.add(line, startIndex, endIndex, closeIndex);
        }

        args.end = endIndex;
        validate(args);

        return args;
    }

    public static class Arg {

        final String text;
        final int ini;
        final int end;

        public Arg(String name, int ini, int end) {
            this.text = name;
            this.ini = ini;
            this.end = end;
        }

        public String getText() {
            return text;
        }

        public int getIni() {
            return ini;
        }

        public int getEnd() {
            return end;
        }
    }

    public static class Args extends ArrayList<Arg> {

        int end;
        boolean invalid;

        public Args() {
            super();
        }

        public Args(Arg arg) {
            add(arg);
        }

        public int getEnd() {
            return end;
        }

        public boolean isInvalid() {
            return invalid;
        }

        void setInvalid(boolean invalid) {
            this.invalid = invalid;
        }

        void add(String line, int startIndex, int endIndex, int closeIndex) {
            if (line.charAt(startIndex) == '{') {
                add(new Arg(line.substring(startIndex + 1, closeIndex), startIndex, endIndex));
            } else {
                add(new Arg(line.substring(startIndex, endIndex), startIndex, endIndex));
            }
        }
    }
}
