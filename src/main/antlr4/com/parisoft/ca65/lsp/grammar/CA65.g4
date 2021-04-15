grammar CA65;

program
    : EOL* line (EOL line?)* EOF
    ;

line
    : instruction
    | labelEqu
    | labelDef
    | proc
    ;

instruction
    : indirectInstruction
    | absoluteInstruction
    | immediateInstruction
    | implicitInstruction
    ;

indirectInstruction
    : inlineLabel? Opcode LPAREN expression (COMMA INDEX)? RPAREN (COMMA INDEX)?
    | inlineLabel? Opcode LBRACK expression RBRACK (COMMA INDEX)?
    ;

absoluteInstruction
    : inlineLabel? Opcode expression (COMMA INDEX)?
    ;

immediateInstruction
    : inlineLabel? Opcode IMMEDIATE expression
    ;

implicitInstruction
    : inlineLabel? Opcode ACC?
    ;

labelEqu
    : identifier EQ expression
    ;

labelDef
    : inlineLabel
    | identifier
    ;

inlineLabel
    : identifier? COLON
    ;

//https://cc65.github.io/doc/ca65.html#ss5.5
expression
    : primaryExpression                                             #Primary
    | prefix=(PLUS|MINUS|BITNOT|'<'|'>'|'^') expression             #Unary
    | prefix=(LOBYTE|HIBYTE|BANKBYTE) LPAREN expression RPAREN      #Extraction
    | expression op=(MUL|DIV|MOD|BITAND|BITXOR|SHL|SHR) expression  #Multiplicative
    | expression op=(PLUS|MINUS|BITOR) expression                   #Additive
    | expression op=(EQ|NE|LT|GT|LE|GE) expression                  #Comparative
    | expression op=(BAND|XOR|OR) expression                        #Bitwise
    | prefix=NOT expression                                         #Negation
    ;

primaryExpression
    : LPAREN expression RPAREN
    | literal
    | functionRef
    | labelRef
    ;

labelRef
    : Addressing? COLONCOLON? identifier (COLONCOLON identifier)*
    | UnnamedLabel
    ;

functionRef
    : identifier LPAREN args+=expression (COMMA args+=expression)* RPAREN
    ;

identifier
    : IDENT LPAREN expression RPAREN
    | Identifier
    ;

literal
    : NUMBER
    | STRING
    | PC|'*'
    ;

proc
    : PROC identifier (EOL line?)+ ENDPROC
    ;

fragment A
   : ('a' | 'A')
   ;

fragment B
   : ('b' | 'B')
   ;

fragment C
   : ('c' | 'C')
   ;

fragment D
   : ('d' | 'D')
   ;

fragment E
   : ('e' | 'E')
   ;

fragment F
   : ('f' | 'F')
   ;

fragment G
   : ('g' | 'G')
   ;

fragment H
   : ('h' | 'H')
   ;

fragment I
   : ('i' | 'I')
   ;

fragment J
   : ('j' | 'J')
   ;

fragment K
   : ('k' | 'K')
   ;

fragment L
   : ('l' | 'L')
   ;

fragment M
   : ('m' | 'M')
   ;

fragment N
   : ('n' | 'N')
   ;

fragment O
   : ('o' | 'O')
   ;

fragment P
   : ('p' | 'P')
   ;

fragment Q
   : ('q' | 'Q')
   ;

fragment R
   : ('r' | 'R')
   ;

fragment S
   : ('s' | 'S')
   ;

fragment T
   : ('t' | 'T')
   ;

fragment U
   : ('u' | 'U')
   ;

fragment V
   : ('v' | 'V')
   ;

fragment W
   : ('w' | 'W')
   ;

fragment X
   : ('x' | 'X')
   ;

fragment Y
   : ('y' | 'Y')
   ;

fragment Z
   : ('z' | 'Z')
   ;

Opcode
	: ADC
	| AND
	| ASL
	| BCC
	| BCS
	| BEQ
	| BIT
	| BMI
	| BNE
	| BPL
	| BRK
	| BVC
	| BVS
	| CLC
	| CLD
	| CLI
	| CLV
	| CMP
	| CPX
	| CPY
	| DEC
	| DEX
	| DEY
	| EOR
	| INC
	| INX
	| INY
	| JMP
	| JSR
	| LDA
	| LDX
	| LDY
	| LSR
	| NOP
	| ORA
	| PHA
	| PHP
	| PLA
	| PLP
	| ROL
	| ROR
	| RTI
	| RTS
	| SBC
	| SEC
	| SED
	| SEI
	| STA
	| STX
	| STY
	| TAX
	| TAY
	| TSX
	| TXA
	| TXS
	| TYA
	| BRA
	| PHX
	| PHY
	| PLX
	| PLY
	| STZ
	| TRB
	| TSB
	| BBR0
	| BBR1
	| BBR2
	| BBR3
	| BBR4
	| BBR5
	| BBR6
	| BBR7
	| BBS0
	| BBS1
	| BBS2
	| BBS3
	| BBS4
	| BBS5
	| BBS6
	| BBS7
	| RMB0
	| RMB1
	| RMB2
	| RMB3
	| RMB4
	| RMB5
	| RMB6
	| RMB7
	| SMB0
	| SMB1
	| SMB2
	| SMB3
	| SMB4
	| SMB5
	| SMB6
	| SMB7
	| ALR
	| ANC
	| ARR
	| AXS
	| DCP
	| ISC
	| LAS
	| LAX
	| RLA
	| RRA
	| SAX
	| SLO
	| SRE
	| BRL
	| COP
	| JML
	| JSL
	| MVN
	| MVP
	| PEA
	| PEI
	| PER
	| PHB
	| PHD
	| PHK
	| PLB
	| PLD
	| REP
	| RTL
	| SEP
	| STP
	| TCD
	| TCS
	| TDC
	| TSC
	| TXY
	| TYX
	| WAI
	| WDM
	| XBA
	| XCE
	| CPA
	| DEA
	| INA
	| SWA
	| TAD
	| TAS
	| TDA
	| TSA
	| LBCC
	| LBCS
	| LBEQ
	| LBMI
	| LBNE
	| LBPL
	| LBVC
	| LBVS
	| ADD
	| SUB
	| BGE
	| BLT
	| BGT
	| BLE
	| BNZ
	| BZE
	| JEQ
	| JNE
	| JMI
	| JPL
	| JCS
	| JCC
	| JVS
	| JVC
    ;

/* Diretives */
IDENT
    : DOT I D E N T
    ;

PROC
    : DOT P R O C
    ;

ENDPROC
    : END P R O C
    ;

ENUM
    : DOT E N U M
    ;

ENDENUM
    : END E N U M
    ;

STRUCT
    : DOT S T R U C T
    ;

ENDSTRUCT
    : END S T R U C T
    ;

UNION
    : DOT U N I O N
    ;

ENDUNION
    : END U N I O N
    ;

END
    : DOT E N D
    ;

IF
    : DOT I F (B L A N K|C O N S T|D E F|N B L A N K|N D E F|N R E F|P '02'|P '4510'|P '816' |P C '02'|P D T V|P S C '02'|R E F)
    ;

ENDIF
    : END I F
    ;

REPEAT
    : DOT R E P E A T
    ;

ENDREPEAT
    : END R E P (E A T)?
    ;

BYTE
    : DOT B Y T E
    ;

RES
    : DOT R E S
    ;

DBYTE
    : DOT D B Y T E
    ;

WORD
    : DOT W O R D
    ;

ADDR
    : DOT A D D R
    ;

FARADDR
    : DOT F A R A D D R
    ;

DWORD
    : DOT D W O R D
    ;

ASCIIZ
    : DOT A S C I I Z
    ;

LOBYTES
    : LOBYTE S
    ;

HIBYTES
    : HIBYTE S
    ;

BANKBYTES
    : BANKBYTE S
    ;

TAG
    : DOT T A G
    ;

SET
    : DOT S E T
    ;

INCLUDE
    : DOT I N C L U D E
    ;

INCBIN
    : DOT I N C B I N
    ;

SEGMENT
    : DOT S E G M E N T
    ;
/* END Diretives */

/* Operators */
PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

BITNOT
    : (DOT B I T N O T)|'~'
    ;

LOBYTE
    : (DOT L O B Y T E)
    ;

HIBYTE
    : (DOT H I B Y T E)
    ;

BANKBYTE
    : (DOT B A N K B Y T E)
    ;

MUL
    : '*'
    ;

DIV
    : '/'
    ;

MOD
    : DOT M O D
    ;

BITAND
    : (DOT B I T A N D)|'&'
    ;

BITXOR
    : (DOT B I T X O R)|'^'
    ;

SHL
    : (DOT S H L)|'<<'
    ;

SHR
    : (DOT S H R)|'>>'
    ;

BITOR
    : (DOT B I T O R)|'|'
    ;

EQ
    : '='
    ;

NE
    : '<>'
    ;

LT
    : '<'
    ;

LE
    : '<='
    ;

GT
    : '>'
    ;

GE
    : '>='
    ;

BAND
    : (DOT A N D)|'&&'
    ;

XOR
    : (DOT X O R)
    ;

OR
    : (DOT O R)|'||'
    ;

NOT
    : (DOT N O T)|'!'
    ;
/* END Operators */

/* Separators */
LPAREN:     '(';
RPAREN:     ')';
LBRACE:     '{';
RBRACE:     '}';
LBRACK:     '[';
RBRACK:     ']';
COMMA:      ',';
DOT:        '.';
COLON:      ':';
COLONCOLON: '::';
/* END Separators */

/* Assembler chars */
PC: '*' | '$';

IMMEDIATE: '#';

LOCALCHAR: '@';

INDEX: X | Y | S;

ACC: A;
/* END Assembler chars */

/* Digits */
NUMBER
    : DIGIT
    | HEX
    | BIN
    | CHAR
    ;

DIGIT
    : ([0-9] ('_' [0-9])?)+
    ;

HEX
    : '$' ([0-9a-fA-F] ('_' [0-9a-fA-F])?)+
    | ([0-9a-fA-F] ('_' [0-9a-fA-F])?)+ H
    ;

BIN
    : '%' ([01] ('_' [01])?)+
    ;
/* END Digits */

Identifier
    : (Diretive|CheapLabel|Label)
    ;

Addressing
    : (Z|A|F) COLON
    ;

Diretive
    : DOT Label
    ;

CheapLabel
    : [@\\?][a-zA-Z0-9_@\\?$]+
    ;

UnnamedLabel
    : ':' (PLUS+|MINUS+)
    ;

Label
    : [a-zA-Z_] [a-zA-Z0-9_@\\?$]*
    ;

/* Opcodes */
ADC: A D C;
AND: A N D;
ASL: A S L;
BCC: B C C;
BCS: B C S;
BEQ: B E Q;
BIT: B I T;
BMI: B M I;
BNE: B N E;
BPL: B P L;
BRK: B R K;
BVC: B V C;
BVS: B V S;
CLC: C L C;
CLD: C L D;
CLI: C L I;
CLV: C L V;
CMP: C M P;
CPX: C P X;
CPY: C P Y;
DEC: D E C;
DEX: D E X;
DEY: D E Y;
EOR: E O R;
INC: I N C;
INX: I N X;
INY: I N Y;
JMP: J M P;
JSR: J S R;
LDA: L D A;
LDX: L D X;
LDY: L D Y;
LSR: L S R;
NOP: N O P;
ORA: O R A;
PHA: P H A;
PHP: P H P;
PLA: P L A;
PLP: P L P;
ROL: R O L;
ROR: R O R;
RTI: R T I;
RTS: R T S;
SBC: S B C;
SEC: S E C;
SED: S E D;
SEI: S E I;
STA: S T A;
STX: S T X;
STY: S T Y;
TAX: T A X;
TAY: T A Y;
TSX: T S X;
TXA: T X A;
TXS: T X S;
TYA: T Y A;
BRA: B R A;
PHX: P H X;
PHY: P H Y;
PLX: P L X;
PLY: P L Y;
STZ: S T Z;
TRB: T R B;
TSB: T S B;
BBR0: B B R '0';
BBR1: B B R '1';
BBR2: B B R '2';
BBR3: B B R '3';
BBR4: B B R '4';
BBR5: B B R '5';
BBR6: B B R '6';
BBR7: B B R '7';
BBS0: B B S '0';
BBS1: B B S '1';
BBS2: B B S '2';
BBS3: B B S '3';
BBS4: B B S '4';
BBS5: B B S '5';
BBS6: B B S '6';
BBS7: B B S '7';
RMB0: R M B '0';
RMB1: R M B '1';
RMB2: R M B '2';
RMB3: R M B '3';
RMB4: R M B '4';
RMB5: R M B '5';
RMB6: R M B '6';
RMB7: R M B '7';
SMB0: S M B '0';
SMB1: S M B '1';
SMB2: S M B '2';
SMB3: S M B '3';
SMB4: S M B '4';
SMB5: S M B '5';
SMB6: S M B '6';
SMB7: S M B '7';
ALR: A L R;
ANC: A N C;
ARR: A R R;
AXS: A X S;
DCP: D C P;
ISC: I S C;
LAS: L A S;
LAX: L A X;
RLA: R L A;
RRA: R R A;
SAX: S A X;
SLO: S L O;
SRE: S R E;
BRL: B R L;
COP: C O P;
JML: J M L;
JSL: J S L;
MVN: M V N;
MVP: M V P;
PEA: P E A;
PEI: P E I;
PER: P E R;
PHB: P H B;
PHD: P H D;
PHK: P H K;
PLB: P L B;
PLD: P L D;
REP: R E P;
RTL: R T L;
SEP: S E P;
STP: S T P;
TCD: T C D;
TCS: T C S;
TDC: T D C;
TSC: T S C;
TXY: T X Y;
TYX: T Y X;
WAI: W A I;
WDM: W D M;
XBA: X B A;
XCE: X C E;
CPA: C P A;
DEA: D E A;
INA: I N A;
SWA: S W A;
TAD: T A D;
TAS: T A S;
TDA: T D A;
TSA: T S A;
LBCC: L B C C;
LBCS: L B C S;
LBEQ: L B E Q;
LBMI: L B M I;
LBNE: L B N E;
LBPL: L B P L;
LBVC: L B V C;
LBVS: L B V S;
ADD: A D D;
SUB: S U B;
BGE: B G E;
BLT: B L T;
BGT: B G T;
BLE: B L E;
BNZ: B N Z;
BZE: B Z E;
JEQ: J E Q;
JNE: J N E;
JMI: J M I;
JPL: J P L;
JCS: J C S;
JCC: J C C;
JVS: J V S;
JVC: J V C;
/* END Opcodes */

COMMENT
    : ';' ~ [\r\n]* -> channel(HIDDEN)
    ;

C_COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;

STRING
    : '"' ~ ["]* '"'
    ;

CHAR
    : '\'' . '\''
    ;

EOL
    : [\r\n]+
    ;

WS
   : [ \t]
//   ('\\' EOL)?
   -> skip
   ;