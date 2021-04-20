package com.parisoft.ca65.lsp.parser.lang;

public class PseudoVar {

    // https://github.com/cc65/cc65/blob/master/asminc/cpu.mac

    // CPU bitmask constants
    public static final int CPU_ISET_NONE      = 0x0001;
    public static final int CPU_ISET_6502      = 0x0002;
    public static final int CPU_ISET_6502X     = 0x0004;
    public static final int CPU_ISET_6502DTV   = 0x0008;
    public static final int CPU_ISET_65SC02    = 0x0010;
    public static final int CPU_ISET_65C02     = 0x0020;
    public static final int CPU_ISET_65816     = 0x0040;
    public static final int CPU_ISET_SWEET16   = 0x0080;
    public static final int CPU_ISET_HUC6280   = 0x0100;
    public static final int CPU_ISET_4510      = 0x0400 ;

    // CPU capabilities
    public static final int CPU_NONE           = CPU_ISET_NONE;
    public static final int CPU_6502           = CPU_ISET_6502;
    public static final int CPU_6502X          = CPU_ISET_6502|CPU_ISET_6502X;
    public static final int CPU_6502DTV        = CPU_ISET_6502|CPU_ISET_6502X|CPU_ISET_6502DTV;
    public static final int CPU_65SC02         = CPU_ISET_6502|CPU_ISET_65SC02;
    public static final int CPU_65C02          = CPU_ISET_6502|CPU_ISET_65SC02|CPU_ISET_65C02;
    public static final int CPU_65816          = CPU_ISET_6502|CPU_ISET_65SC02|CPU_ISET_65816;
    public static final int CPU_SWEET16        = CPU_ISET_SWEET16;
    public static final int CPU_HUC6280        = CPU_ISET_6502|CPU_ISET_65SC02|CPU_ISET_65C02|CPU_ISET_HUC6280;
    public static final int CPU_4510           = CPU_ISET_6502|CPU_ISET_65SC02|CPU_ISET_65C02|CPU_ISET_4510;

}
