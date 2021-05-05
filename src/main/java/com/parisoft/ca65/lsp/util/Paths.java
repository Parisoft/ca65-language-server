package com.parisoft.ca65.lsp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Paths {

    private static final Logger log = LoggerFactory.getLogger(Paths.class);
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

    public static String read(Path path) {
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            log.error("Could not read a file for parse: {}", path, e);
            return null;
        }
    }

    public static boolean isASM(Path path) {
        return extensions.contains(getExtension(path));
    }
}
