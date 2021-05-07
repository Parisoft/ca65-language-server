package com.parisoft.ca65.lsp.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Strings {

    private static final Pattern lineBreakRegex = Pattern.compile("\\r?\\n");

    public static String unquote(String s) {
        if (s == null) {
            return null;
        }

        if ((s.charAt(0) == '"' && s.charAt(s.length() - 1) == '"') || (s.charAt(0) == '\'' && s.charAt(s.length() - 1) == '\'')) {
            return s.substring(1, s.length() - 1);
        }

        return s;
    }

    public static String[] splitLines(String s) {
        return lineBreakRegex.split(s);
    }

    public static int indexOfNonSpace(String s, int fromIndex) {
        int index = fromIndex;

        while (index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }

        return index;
    }

    public static String repeat(char c, int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, c);
        return new String(chars);
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen = cs == null ? 0 : cs.length();

        if (strLen == 0) {
            return true;
        }

        for(int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
