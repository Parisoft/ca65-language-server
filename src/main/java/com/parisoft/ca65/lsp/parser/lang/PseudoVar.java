package com.parisoft.ca65.lsp.parser.lang;

public class PseudoVar {

    // https://github.com/cc65/cc65/blob/master/asminc/cpu.mac
    public enum CPU {
        // CPU bitmask constants
        CPU_ISET_NONE(0x0001),
        CPU_ISET_6502(0x0002),
        CPU_ISET_6502X(0x0004),
        CPU_ISET_6502DTV(0x0008),
        CPU_ISET_65SC02(0x0010),
        CPU_ISET_65C02(0x0020),
        CPU_ISET_65816(0x0040),
        CPU_ISET_SWEET16(0x0080),
        CPU_ISET_HUC6280(0x0100),
        CPU_ISET_4510(0x0400),
        // CPU capabilities
        CPU_NONE(CPU_ISET_NONE.value),
        CPU_6502(CPU_ISET_6502.value),
        CPU_6502X(CPU_ISET_6502.value | CPU_ISET_6502X.value),
        CPU_6502DTV(CPU_ISET_6502.value | CPU_ISET_6502X.value | CPU_ISET_6502DTV.value),
        CPU_65SC02(CPU_ISET_6502.value | CPU_ISET_65SC02.value),
        CPU_65C02(CPU_ISET_6502.value | CPU_ISET_65SC02.value | CPU_ISET_65C02.value),
        CPU_65816(CPU_ISET_6502.value | CPU_ISET_65SC02.value | CPU_ISET_65816.value),
        CPU_SWEET16(CPU_ISET_SWEET16.value),
        CPU_HUC6280(CPU_ISET_6502.value | CPU_ISET_65SC02.value | CPU_ISET_65C02.value | CPU_ISET_HUC6280.value),
        CPU_4510(CPU_ISET_6502.value | CPU_ISET_65SC02.value | CPU_ISET_65C02.value | CPU_ISET_4510.value);

        int value;

        CPU(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }
}
