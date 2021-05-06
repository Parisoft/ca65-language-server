package com.parisoft.ca65.lsp.util;

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

    public static String[] splitLines(String s) {
        return lineBreakRegex.split(s);
    }

    public static int countLines(String s) {
        int count = 1;
        int index = -1;

        while ((index = s.indexOf('\n', index + 1)) >= 0) {
            count++;
        }

        return count;
    }

    public static int indexOfNonSpace(String s, int fromIndex) {
        int index = fromIndex;

        while (index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }

        return index;
    }
}
