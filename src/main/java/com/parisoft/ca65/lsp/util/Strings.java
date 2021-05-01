package com.parisoft.ca65.lsp.util;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Strings {

    private static final Pattern lineBreakRegex = Pattern.compile("\\r?\\n");

    public static String unquote(String s) {
        if (s == null) {
            return null;
        }

        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }

        return s;
    }

    public static String[] splitLineBreak(String s) {
        return lineBreakRegex.split(s);
    }

    public static Map.Entry<Integer, List<String>> splitArgs(String line, int paramCount, int startIndex) {
        int endIndex = startIndex;
        List<String> args = new ArrayList<>(paramCount);
        int brackets = 0;

        while (endIndex < line.length() && args.size() < paramCount) {
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
                            args.add(line.substring(startIndex + 1, endIndex - 1));
                        } else {
                            args.add(line.substring(startIndex, endIndex));
                        }

                        startIndex = endIndex;
                    }
            }
        }

        if (endIndex == line.length() && brackets == 0) {
            args.add(line.substring(startIndex, endIndex));
        }

        return new SimpleEntry<>(endIndex, args);
    }
}
