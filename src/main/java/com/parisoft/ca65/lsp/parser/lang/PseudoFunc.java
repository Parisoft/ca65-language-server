package com.parisoft.ca65.lsp.parser.lang;

public class PseudoFunc {

    public static int LOBYTE(int arg) {
        return arg & 0xff;
    }

    public static int HIBYTE(int arg) {
        return (arg & 0xffff) >> 8;
    }

    public static int LOWORD(int arg) {
        return arg & 0xffff;
    }

    public static int HIWORD(int arg) {
        return arg >> 16;
    }

    public static int BANKBYTE(int arg) {
        return (arg & 0xffffff) >> 16;
    }
}
