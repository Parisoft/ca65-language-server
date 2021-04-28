package com.parisoft.ca65.lsp.util;

public class Strings {

    public static String unquote(String s) {
        if (s == null) {
            return null;
        }

        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }

        return s;
    }
}
