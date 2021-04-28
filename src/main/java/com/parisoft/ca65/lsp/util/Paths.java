package com.parisoft.ca65.lsp.util;

import java.net.URI;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Paths {

    private static final Set<String> extensions = new HashSet<>(Arrays.asList("asm", "s", "a65", "inc", "i"));

    public static Path get(String s) {
        return java.nio.file.Paths.get(s);
    }

    public static Path fromURI(String uri) {
        return java.nio.file.Paths.get(URI.create(uri)).toAbsolutePath().normalize();
    }

    public static String getExtension(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf(".");

        if (dotIndex >= 0) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }

        return null;
    }

    public static boolean isASM(Path path) {
        return extensions.contains(getExtension(path));
    }
}
