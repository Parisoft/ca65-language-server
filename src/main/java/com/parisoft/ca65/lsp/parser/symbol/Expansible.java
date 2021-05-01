package com.parisoft.ca65.lsp.parser.symbol;

import org.eclipse.lsp4j.Position;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Expansible extends Definition {

    final List<String> params = new ArrayList<>();
    String body;

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

    public void setBody(String body) {
        for (String param : params) {
            Pattern pattern = Pattern.compile("([^a-zA-Z0-9_@\\\\?$])(" + param + ")([^a-zA-Z0-9_@\\\\?$])");
            body = pattern.matcher(body).replaceAll("$1\\${" + param + "}$2");
        }

        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public Args getArgs(String line, Position position) {
        int startIndex = position.getCharacter() + name.length();
        int endIndex = startIndex;
        int brackets = 0;
        Args args = new Args();

        while (endIndex < line.length() && args.size() < params.size()) {
            switch (line.charAt(endIndex++)) {
                case '{':
                    brackets++;
                    break;
                case '}':
                    brackets--;
                    break;
                case ',':
                    if (brackets == 0) {
                        if (line.charAt(startIndex) == '{' && line.charAt(endIndex) == '}') {
                            args.add(new Arg(line.substring(startIndex + 1, endIndex - 1), startIndex, endIndex));
                        } else {
                            args.add(new Arg(line.substring(startIndex, endIndex), startIndex, endIndex));
                        }

                        startIndex = endIndex;
                    }
            }
        }

        if (endIndex == line.length() && brackets == 0) {
            args.add(new Arg(line.substring(startIndex, endIndex), startIndex, endIndex));
        }

        args.end = endIndex;
        validate(args);

        return args;
    }

    public static class Arg {

        final String text;
        final int ini;
        final int end;

        Arg(String name, int ini, int end) {
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

        public int getEnd() {
            return end;
        }

        public boolean isInvalid() {
            return invalid;
        }

        void setInvalid(boolean invalid) {
            this.invalid = invalid;
        }
    }
}
