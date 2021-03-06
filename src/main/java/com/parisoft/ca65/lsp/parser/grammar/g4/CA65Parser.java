// Generated from com/parisoft/ca65/lsp/parser/grammar/g4/CA65.g4 by ANTLR 4.9.2
package com.parisoft.ca65.lsp.parser.grammar.g4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CA65Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, Opcode=4, PseudoVar=5, PseudoFunc=6, Allocator=7, 
		Control=8, SCOPE=9, ENDSCOPE=10, PROC=11, ENDPROC=12, ENUM=13, ENDENUM=14, 
		STRUCT=15, ENDSTRUCT=16, UNION=17, ENDUNION=18, IF=19, ENDIF=20, ELSE=21, 
		ELSEIF=22, REPEAT=23, ENDREPEAT=24, SET=25, MACRO=26, ENDMACRO=27, DELMACRO=28, 
		EXITMACRO=29, DEFINE=30, UNDEFINE=31, LOCAL=32, ASIZE=33, CPU=34, ISIZE=35, 
		PARAMCOUNT=36, TIME=37, VERSION=38, CPU_ISET_NONE=39, CPU_ISET_6502=40, 
		CPU_ISET_6502X=41, CPU_ISET_6502DTV=42, CPU_ISET_65SC02=43, CPU_ISET_65C02=44, 
		CPU_ISET_65816=45, CPU_ISET_SWEET16=46, CPU_ISET_HUC6280=47, CPU_ISET_4510=48, 
		CPU_NONE=49, CPU_6502=50, CPU_6502X=51, CPU_6502DTV=52, CPU_65SC02=53, 
		CPU_65C02=54, CPU_65816=55, CPU_SWEET16=56, CPU_HUC6280=57, CPU_4510=58, 
		ADDRSIZE=59, BANK=60, BLANK=61, CONCAT=62, CONST=63, IDENT=64, LEFT=65, 
		MATCH=66, MAX=67, MID=68, MIN=69, REF=70, REFERENCED=71, RIGHT=72, SIZEOF=73, 
		STRAT=74, SPRINTF=75, STRING_=76, STRLEN=77, TCOUNT=78, XMATCH=79, DEFINED=80, 
		DEFINEDMACRO=81, ISMNEMONIC=82, BYTE=83, RES=84, DBYT=85, WORD=86, ADDR=87, 
		FARADDR=88, DWORD=89, ASCIIZ=90, LOBYTES=91, HIBYTES=92, BANKBYTES=93, 
		TAG=94, A16=95, A8=96, ALIGN=97, ASSERT=98, AUTOIMPORT=99, BSS=100, CASE=101, 
		CHARMAP=102, CODE=103, CONDES=104, CONSTRUCTOR=105, DATA=106, DEBUGINFO=107, 
		DESTRUCTOR=108, END=109, ERROR=110, EXPORT=111, EXPORTZP=112, FATAL=113, 
		FEATURE=114, FILEOPT=115, FOPT=116, FORCEIMPORT=117, GLOBAL=118, GLOBALZP=119, 
		I16=120, I8=121, IMPORT=122, IMPORTZP=123, INCBIN=124, INCLUDE=125, INTERRUPTOR=126, 
		LINECONT=127, LIST=128, LISTBYTES=129, LOCALCHAR=130, MACPACK=131, ORG=132, 
		OUT=133, PAGELEN=134, PAGELENGTH=135, POPCPU=136, POPSEG=137, PUSHCPU=138, 
		PUSHSEG=139, RELOC=140, RODATA=141, SEGMENT=142, SETCPU=143, SMART=144, 
		WARNING=145, ZEROPAGE=146, PLUS=147, MINUS=148, BITNOT=149, LOBYTE=150, 
		HIBYTE=151, LOWORD=152, HIWORD=153, BANKBYTE=154, MUL=155, DIV=156, MOD=157, 
		BITAND=158, BITXOR=159, SHL=160, SHR=161, BITOR=162, EQ=163, NE=164, LT=165, 
		LE=166, GT=167, GE=168, AND_=169, XOR=170, OR=171, NOT=172, LPAREN=173, 
		RPAREN=174, LBRACE=175, RBRACE=176, LBRACK=177, RBRACK=178, COMMA=179, 
		DOT=180, COLON=181, COLONCOLON=182, PC=183, IMMEDIATE=184, INDEX=185, 
		ACC=186, NUMBER=187, DIGIT=188, HEX=189, BIN=190, Identifier=191, Addressing=192, 
		Diretive=193, CheapLabel=194, UnnamedLabel=195, Label=196, ADC=197, AND=198, 
		ASL=199, BCC=200, BCS=201, BEQ=202, BIT=203, BMI=204, BNE=205, BPL=206, 
		BRK=207, BVC=208, BVS=209, CLC=210, CLD=211, CLI=212, CLV=213, CMP=214, 
		CPX=215, CPY=216, DEC=217, DEX=218, DEY=219, EOR=220, INC=221, INX=222, 
		INY=223, JMP=224, JSR=225, LDA=226, LDX=227, LDY=228, LSR=229, NOP=230, 
		ORA=231, PHA=232, PHP=233, PLA=234, PLP=235, ROL=236, ROR=237, RTI=238, 
		RTS=239, SBC=240, SEC=241, SED=242, SEI=243, STA=244, STX=245, STY=246, 
		TAX=247, TAY=248, TSX=249, TXA=250, TXS=251, TYA=252, BRA=253, PHX=254, 
		PHY=255, PLX=256, PLY=257, STZ=258, TRB=259, TSB=260, BBR0=261, BBR1=262, 
		BBR2=263, BBR3=264, BBR4=265, BBR5=266, BBR6=267, BBR7=268, BBS0=269, 
		BBS1=270, BBS2=271, BBS3=272, BBS4=273, BBS5=274, BBS6=275, BBS7=276, 
		RMB0=277, RMB1=278, RMB2=279, RMB3=280, RMB4=281, RMB5=282, RMB6=283, 
		RMB7=284, SMB0=285, SMB1=286, SMB2=287, SMB3=288, SMB4=289, SMB5=290, 
		SMB6=291, SMB7=292, ALR=293, ANC=294, ARR=295, AXS=296, DCP=297, ISC=298, 
		LAS=299, LAX=300, RLA=301, RRA=302, SAX=303, SLO=304, SRE=305, BRL=306, 
		COP=307, JML=308, JSL=309, MVN=310, MVP=311, PEA=312, PEI=313, PER=314, 
		PHB=315, PHD=316, PHK=317, PLB=318, PLD=319, REP=320, RTL=321, SEP=322, 
		STP=323, TCD=324, TCS=325, TDC=326, TSC=327, TXY=328, TYX=329, WAI=330, 
		WDM=331, XBA=332, XCE=333, CPA=334, DEA=335, INA=336, SWA=337, TAD=338, 
		TAS=339, TDA=340, TSA=341, LBCC=342, LBCS=343, LBEQ=344, LBMI=345, LBNE=346, 
		LBPL=347, LBVC=348, LBVS=349, ADD=350, SUB=351, BGE=352, BLT=353, BGT=354, 
		BLE=355, BNZ=356, BZE=357, JEQ=358, JNE=359, JMI=360, JPL=361, JCS=362, 
		JCC=363, JVS=364, JVC=365, COMMENT=366, C_COMMENT=367, STRING=368, CHAR=369, 
		EOL=370, WS=371;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_instruction = 2, RULE_indirectInstruction = 3, 
		RULE_absoluteInstruction = 4, RULE_immediateInstruction = 5, RULE_implicitInstruction = 6, 
		RULE_labelEqu = 7, RULE_labelDef = 8, RULE_varDef = 9, RULE_inlineLabel = 10, 
		RULE_expression = 11, RULE_expr = 12, RULE_primaryExpression = 13, RULE_labelRef = 14, 
		RULE_varRef = 15, RULE_functionRef = 16, RULE_identifier = 17, RULE_literal = 18, 
		RULE_statement = 19, RULE_proc = 20, RULE_scope = 21, RULE_enumerator = 22, 
		RULE_enumMember = 23, RULE_struct = 24, RULE_union = 25, RULE_structMember = 26, 
		RULE_field = 27, RULE_ifStmt = 28, RULE_repeat = 29, RULE_define = 30, 
		RULE_macro = 31, RULE_endStmt = 32, RULE_storage = 33, RULE_control = 34, 
		RULE_expansion = 35, RULE_expansionPush = 36, RULE_expansionPop = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "instruction", "indirectInstruction", "absoluteInstruction", 
			"immediateInstruction", "implicitInstruction", "labelEqu", "labelDef", 
			"varDef", "inlineLabel", "expression", "expr", "primaryExpression", "labelRef", 
			"varRef", "functionRef", "identifier", "literal", "statement", "proc", 
			"scope", "enumerator", "enumMember", "struct", "union", "structMember", 
			"field", "ifStmt", "repeat", "define", "macro", "endStmt", "storage", 
			"control", "expansion", "expansionPush", "expansionPop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'^'", "'expansion-push'", "'expansion-pop'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'+'", "'-'", null, null, 
			null, null, null, null, "'*'", "'/'", null, null, null, null, null, null, 
			"'='", "'<>'", "'<'", "'<='", "'>'", "'>='", null, null, null, null, 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "'::'", 
			null, "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "Opcode", "PseudoVar", "PseudoFunc", "Allocator", 
			"Control", "SCOPE", "ENDSCOPE", "PROC", "ENDPROC", "ENUM", "ENDENUM", 
			"STRUCT", "ENDSTRUCT", "UNION", "ENDUNION", "IF", "ENDIF", "ELSE", "ELSEIF", 
			"REPEAT", "ENDREPEAT", "SET", "MACRO", "ENDMACRO", "DELMACRO", "EXITMACRO", 
			"DEFINE", "UNDEFINE", "LOCAL", "ASIZE", "CPU", "ISIZE", "PARAMCOUNT", 
			"TIME", "VERSION", "CPU_ISET_NONE", "CPU_ISET_6502", "CPU_ISET_6502X", 
			"CPU_ISET_6502DTV", "CPU_ISET_65SC02", "CPU_ISET_65C02", "CPU_ISET_65816", 
			"CPU_ISET_SWEET16", "CPU_ISET_HUC6280", "CPU_ISET_4510", "CPU_NONE", 
			"CPU_6502", "CPU_6502X", "CPU_6502DTV", "CPU_65SC02", "CPU_65C02", "CPU_65816", 
			"CPU_SWEET16", "CPU_HUC6280", "CPU_4510", "ADDRSIZE", "BANK", "BLANK", 
			"CONCAT", "CONST", "IDENT", "LEFT", "MATCH", "MAX", "MID", "MIN", "REF", 
			"REFERENCED", "RIGHT", "SIZEOF", "STRAT", "SPRINTF", "STRING_", "STRLEN", 
			"TCOUNT", "XMATCH", "DEFINED", "DEFINEDMACRO", "ISMNEMONIC", "BYTE", 
			"RES", "DBYT", "WORD", "ADDR", "FARADDR", "DWORD", "ASCIIZ", "LOBYTES", 
			"HIBYTES", "BANKBYTES", "TAG", "A16", "A8", "ALIGN", "ASSERT", "AUTOIMPORT", 
			"BSS", "CASE", "CHARMAP", "CODE", "CONDES", "CONSTRUCTOR", "DATA", "DEBUGINFO", 
			"DESTRUCTOR", "END", "ERROR", "EXPORT", "EXPORTZP", "FATAL", "FEATURE", 
			"FILEOPT", "FOPT", "FORCEIMPORT", "GLOBAL", "GLOBALZP", "I16", "I8", 
			"IMPORT", "IMPORTZP", "INCBIN", "INCLUDE", "INTERRUPTOR", "LINECONT", 
			"LIST", "LISTBYTES", "LOCALCHAR", "MACPACK", "ORG", "OUT", "PAGELEN", 
			"PAGELENGTH", "POPCPU", "POPSEG", "PUSHCPU", "PUSHSEG", "RELOC", "RODATA", 
			"SEGMENT", "SETCPU", "SMART", "WARNING", "ZEROPAGE", "PLUS", "MINUS", 
			"BITNOT", "LOBYTE", "HIBYTE", "LOWORD", "HIWORD", "BANKBYTE", "MUL", 
			"DIV", "MOD", "BITAND", "BITXOR", "SHL", "SHR", "BITOR", "EQ", "NE", 
			"LT", "LE", "GT", "GE", "AND_", "XOR", "OR", "NOT", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "COMMA", "DOT", "COLON", "COLONCOLON", 
			"PC", "IMMEDIATE", "INDEX", "ACC", "NUMBER", "DIGIT", "HEX", "BIN", "Identifier", 
			"Addressing", "Diretive", "CheapLabel", "UnnamedLabel", "Label", "ADC", 
			"AND", "ASL", "BCC", "BCS", "BEQ", "BIT", "BMI", "BNE", "BPL", "BRK", 
			"BVC", "BVS", "CLC", "CLD", "CLI", "CLV", "CMP", "CPX", "CPY", "DEC", 
			"DEX", "DEY", "EOR", "INC", "INX", "INY", "JMP", "JSR", "LDA", "LDX", 
			"LDY", "LSR", "NOP", "ORA", "PHA", "PHP", "PLA", "PLP", "ROL", "ROR", 
			"RTI", "RTS", "SBC", "SEC", "SED", "SEI", "STA", "STX", "STY", "TAX", 
			"TAY", "TSX", "TXA", "TXS", "TYA", "BRA", "PHX", "PHY", "PLX", "PLY", 
			"STZ", "TRB", "TSB", "BBR0", "BBR1", "BBR2", "BBR3", "BBR4", "BBR5", 
			"BBR6", "BBR7", "BBS0", "BBS1", "BBS2", "BBS3", "BBS4", "BBS5", "BBS6", 
			"BBS7", "RMB0", "RMB1", "RMB2", "RMB3", "RMB4", "RMB5", "RMB6", "RMB7", 
			"SMB0", "SMB1", "SMB2", "SMB3", "SMB4", "SMB5", "SMB6", "SMB7", "ALR", 
			"ANC", "ARR", "AXS", "DCP", "ISC", "LAS", "LAX", "RLA", "RRA", "SAX", 
			"SLO", "SRE", "BRL", "COP", "JML", "JSL", "MVN", "MVP", "PEA", "PEI", 
			"PER", "PHB", "PHD", "PHK", "PLB", "PLD", "REP", "RTL", "SEP", "STP", 
			"TCD", "TCS", "TDC", "TSC", "TXY", "TYX", "WAI", "WDM", "XBA", "XCE", 
			"CPA", "DEA", "INA", "SWA", "TAD", "TAS", "TDA", "TSA", "LBCC", "LBCS", 
			"LBEQ", "LBMI", "LBNE", "LBPL", "LBVC", "LBVS", "ADD", "SUB", "BGE", 
			"BLT", "BGT", "BLE", "BNZ", "BZE", "JEQ", "JNE", "JMI", "JPL", "JCS", 
			"JCC", "JVS", "JVC", "COMMENT", "C_COMMENT", "STRING", "CHAR", "EOL", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CA65.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CA65Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TerminalNode EOF() { return getToken(CA65Parser.EOF, 0); }
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(76);
				match(EOL);
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			line();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(83);
				match(EOL);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (Opcode - 4)) | (1L << (Allocator - 4)) | (1L << (Control - 4)) | (1L << (SCOPE - 4)) | (1L << (ENDSCOPE - 4)) | (1L << (PROC - 4)) | (1L << (ENDPROC - 4)) | (1L << (ENUM - 4)) | (1L << (ENDENUM - 4)) | (1L << (STRUCT - 4)) | (1L << (ENDSTRUCT - 4)) | (1L << (UNION - 4)) | (1L << (ENDUNION - 4)) | (1L << (IF - 4)) | (1L << (ENDIF - 4)) | (1L << (ELSE - 4)) | (1L << (ELSEIF - 4)) | (1L << (REPEAT - 4)) | (1L << (ENDREPEAT - 4)) | (1L << (MACRO - 4)) | (1L << (ENDMACRO - 4)) | (1L << (DEFINE - 4)) | (1L << (IDENT - 4)))) != 0) || ((((_la - 181)) & ~0x3f) == 0 && ((1L << (_la - 181)) & ((1L << (COLON - 181)) | (1L << (IMMEDIATE - 181)) | (1L << (Identifier - 181)))) != 0)) {
					{
					setState(84);
					line();
					}
				}

				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public LabelEquContext labelEqu() {
			return getRuleContext(LabelEquContext.class,0);
		}
		public LabelDefContext labelDef() {
			return getRuleContext(LabelDefContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StorageContext storage() {
			return getRuleContext(StorageContext.class,0);
		}
		public ControlContext control() {
			return getRuleContext(ControlContext.class,0);
		}
		public ExpansionContext expansion() {
			return getRuleContext(ExpansionContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				labelEqu();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				labelDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				varDef();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				storage();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(100);
				control();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(101);
				expansion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public IndirectInstructionContext indirectInstruction() {
			return getRuleContext(IndirectInstructionContext.class,0);
		}
		public AbsoluteInstructionContext absoluteInstruction() {
			return getRuleContext(AbsoluteInstructionContext.class,0);
		}
		public ImmediateInstructionContext immediateInstruction() {
			return getRuleContext(ImmediateInstructionContext.class,0);
		}
		public ImplicitInstructionContext implicitInstruction() {
			return getRuleContext(ImplicitInstructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				indirectInstruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				absoluteInstruction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				immediateInstruction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				implicitInstruction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndirectInstructionContext extends ParserRuleContext {
		public TerminalNode Opcode() { return getToken(CA65Parser.Opcode, 0); }
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public InlineLabelContext inlineLabel() {
			return getRuleContext(InlineLabelContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public List<TerminalNode> INDEX() { return getTokens(CA65Parser.INDEX); }
		public TerminalNode INDEX(int i) {
			return getToken(CA65Parser.INDEX, i);
		}
		public TerminalNode LBRACK() { return getToken(CA65Parser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(CA65Parser.RBRACK, 0); }
		public IndirectInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indirectInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterIndirectInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitIndirectInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitIndirectInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndirectInstructionContext indirectInstruction() throws RecognitionException {
		IndirectInstructionContext _localctx = new IndirectInstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_indirectInstruction);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==COLON || _la==Identifier) {
					{
					setState(110);
					inlineLabel();
					}
				}

				setState(113);
				match(Opcode);
				setState(114);
				match(LPAREN);
				setState(115);
				expression();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(116);
					match(COMMA);
					setState(117);
					match(INDEX);
					}
				}

				setState(120);
				match(RPAREN);
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(121);
					match(COMMA);
					setState(122);
					match(INDEX);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==COLON || _la==Identifier) {
					{
					setState(125);
					inlineLabel();
					}
				}

				setState(128);
				match(Opcode);
				setState(129);
				match(LBRACK);
				setState(130);
				expression();
				setState(131);
				match(RBRACK);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(132);
					match(COMMA);
					setState(133);
					match(INDEX);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbsoluteInstructionContext extends ParserRuleContext {
		public TerminalNode Opcode() { return getToken(CA65Parser.Opcode, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InlineLabelContext inlineLabel() {
			return getRuleContext(InlineLabelContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CA65Parser.COMMA, 0); }
		public TerminalNode INDEX() { return getToken(CA65Parser.INDEX, 0); }
		public AbsoluteInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absoluteInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterAbsoluteInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitAbsoluteInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitAbsoluteInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsoluteInstructionContext absoluteInstruction() throws RecognitionException {
		AbsoluteInstructionContext _localctx = new AbsoluteInstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_absoluteInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(138);
				inlineLabel();
				}
			}

			setState(141);
			match(Opcode);
			setState(142);
			expression();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(143);
				match(COMMA);
				setState(144);
				match(INDEX);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImmediateInstructionContext extends ParserRuleContext {
		public TerminalNode Opcode() { return getToken(CA65Parser.Opcode, 0); }
		public TerminalNode IMMEDIATE() { return getToken(CA65Parser.IMMEDIATE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InlineLabelContext inlineLabel() {
			return getRuleContext(InlineLabelContext.class,0);
		}
		public ImmediateInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_immediateInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterImmediateInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitImmediateInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitImmediateInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImmediateInstructionContext immediateInstruction() throws RecognitionException {
		ImmediateInstructionContext _localctx = new ImmediateInstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_immediateInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(147);
				inlineLabel();
				}
			}

			setState(150);
			match(Opcode);
			setState(151);
			match(IMMEDIATE);
			setState(152);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImplicitInstructionContext extends ParserRuleContext {
		public TerminalNode Opcode() { return getToken(CA65Parser.Opcode, 0); }
		public InlineLabelContext inlineLabel() {
			return getRuleContext(InlineLabelContext.class,0);
		}
		public TerminalNode ACC() { return getToken(CA65Parser.ACC, 0); }
		public ImplicitInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicitInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterImplicitInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitImplicitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitImplicitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplicitInstructionContext implicitInstruction() throws RecognitionException {
		ImplicitInstructionContext _localctx = new ImplicitInstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_implicitInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(154);
				inlineLabel();
				}
			}

			setState(157);
			match(Opcode);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACC) {
				{
				setState(158);
				match(ACC);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelEquContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQ() { return getToken(CA65Parser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LabelEquContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelEqu; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterLabelEqu(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitLabelEqu(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitLabelEqu(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelEquContext labelEqu() throws RecognitionException {
		LabelEquContext _localctx = new LabelEquContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_labelEqu);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			identifier();
			setState(162);
			match(EQ);
			setState(163);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelDefContext extends ParserRuleContext {
		public InlineLabelContext inlineLabel() {
			return getRuleContext(InlineLabelContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterLabelDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitLabelDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitLabelDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelDefContext labelDef() throws RecognitionException {
		LabelDefContext _localctx = new LabelDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_labelDef);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				inlineLabel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(CA65Parser.SET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			identifier();
			setState(170);
			match(SET);
			setState(171);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineLabelContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(CA65Parser.COLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InlineLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterInlineLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitInlineLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitInlineLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineLabelContext inlineLabel() throws RecognitionException {
		InlineLabelContext _localctx = new InlineLabelContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inlineLabel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(173);
				identifier();
				}
			}

			setState(176);
			match(COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicativeContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(CA65Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CA65Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CA65Parser.MOD, 0); }
		public TerminalNode BITAND() { return getToken(CA65Parser.BITAND, 0); }
		public TerminalNode BITXOR() { return getToken(CA65Parser.BITXOR, 0); }
		public TerminalNode SHL() { return getToken(CA65Parser.SHL, 0); }
		public TerminalNode SHR() { return getToken(CA65Parser.SHR, 0); }
		public MultiplicativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitMultiplicative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitMultiplicative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CA65Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CA65Parser.MINUS, 0); }
		public TerminalNode BITOR() { return getToken(CA65Parser.BITOR, 0); }
		public AdditiveContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitAdditive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitAdditive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND_() { return getToken(CA65Parser.AND_, 0); }
		public TerminalNode XOR() { return getToken(CA65Parser.XOR, 0); }
		public TerminalNode OR() { return getToken(CA65Parser.OR, 0); }
		public BitwiseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterBitwise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitBitwise(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitBitwise(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationContext extends ExprContext {
		public Token prefix;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(CA65Parser.NOT, 0); }
		public NegationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryContext extends ExprContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PrimaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtractionContext extends ExprContext {
		public Token prefix;
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public TerminalNode LOBYTE() { return getToken(CA65Parser.LOBYTE, 0); }
		public TerminalNode HIBYTE() { return getToken(CA65Parser.HIBYTE, 0); }
		public TerminalNode LOWORD() { return getToken(CA65Parser.LOWORD, 0); }
		public TerminalNode HIWORD() { return getToken(CA65Parser.HIWORD, 0); }
		public TerminalNode BANKBYTE() { return getToken(CA65Parser.BANKBYTE, 0); }
		public ExtractionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterExtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitExtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitExtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryContext extends ExprContext {
		public Token prefix;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CA65Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CA65Parser.MINUS, 0); }
		public TerminalNode BITNOT() { return getToken(CA65Parser.BITNOT, 0); }
		public TerminalNode LT() { return getToken(CA65Parser.LT, 0); }
		public TerminalNode GT() { return getToken(CA65Parser.GT, 0); }
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparativeContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(CA65Parser.EQ, 0); }
		public TerminalNode NE() { return getToken(CA65Parser.NE, 0); }
		public TerminalNode LT() { return getToken(CA65Parser.LT, 0); }
		public TerminalNode GT() { return getToken(CA65Parser.GT, 0); }
		public TerminalNode LE() { return getToken(CA65Parser.LE, 0); }
		public TerminalNode GE() { return getToken(CA65Parser.GE, 0); }
		public ComparativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterComparative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitComparative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitComparative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PseudoVar:
			case PseudoFunc:
			case IDENT:
			case MUL:
			case LPAREN:
			case COLONCOLON:
			case PC:
			case NUMBER:
			case Identifier:
			case Addressing:
			case UnnamedLabel:
			case STRING:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(181);
				primaryExpression();
				}
				break;
			case T__0:
			case PLUS:
			case MINUS:
			case BITNOT:
			case LT:
			case GT:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				((UnaryContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__0 || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (PLUS - 147)) | (1L << (MINUS - 147)) | (1L << (BITNOT - 147)) | (1L << (LT - 147)) | (1L << (GT - 147)))) != 0)) ) {
					((UnaryContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				expr(7);
				}
				break;
			case LOBYTE:
			case HIBYTE:
			case LOWORD:
			case HIWORD:
			case BANKBYTE:
				{
				_localctx = new ExtractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				((ExtractionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (LOBYTE - 150)) | (1L << (HIBYTE - 150)) | (1L << (LOWORD - 150)) | (1L << (HIWORD - 150)) | (1L << (BANKBYTE - 150)))) != 0)) ) {
					((ExtractionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				match(LPAREN);
				setState(186);
				expr(0);
				setState(187);
				match(RPAREN);
				}
				break;
			case NOT:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				((NegationContext)_localctx).prefix = match(NOT);
				setState(190);
				expr(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(194);
						((MultiplicativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 155)) & ~0x3f) == 0 && ((1L << (_la - 155)) & ((1L << (MUL - 155)) | (1L << (DIV - 155)) | (1L << (MOD - 155)) | (1L << (BITAND - 155)) | (1L << (BITXOR - 155)) | (1L << (SHL - 155)) | (1L << (SHR - 155)))) != 0)) ) {
							((MultiplicativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(197);
						((AdditiveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (PLUS - 147)) | (1L << (MINUS - 147)) | (1L << (BITOR - 147)))) != 0)) ) {
							((AdditiveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ComparativeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(200);
						((ComparativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (EQ - 163)) | (1L << (NE - 163)) | (1L << (LT - 163)) | (1L << (LE - 163)) | (1L << (GT - 163)) | (1L << (GE - 163)))) != 0)) ) {
							((ComparativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(201);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(203);
						((BitwiseContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (AND_ - 169)) | (1L << (XOR - 169)) | (1L << (OR - 169)))) != 0)) ) {
							((BitwiseContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(204);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public FunctionRefContext functionRef() {
			return getRuleContext(FunctionRefContext.class,0);
		}
		public LabelRefContext labelRef() {
			return getRuleContext(LabelRefContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primaryExpression);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(LPAREN);
				setState(211);
				expression();
				setState(212);
				match(RPAREN);
				}
				break;
			case MUL:
			case PC:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				literal();
				}
				break;
			case PseudoVar:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				varRef();
				}
				break;
			case PseudoFunc:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				functionRef();
				}
				break;
			case IDENT:
			case COLONCOLON:
			case Identifier:
			case Addressing:
			case UnnamedLabel:
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				labelRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelRefContext extends ParserRuleContext {
		public Token global;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode Addressing() { return getToken(CA65Parser.Addressing, 0); }
		public List<TerminalNode> COLONCOLON() { return getTokens(CA65Parser.COLONCOLON); }
		public TerminalNode COLONCOLON(int i) {
			return getToken(CA65Parser.COLONCOLON, i);
		}
		public TerminalNode UnnamedLabel() { return getToken(CA65Parser.UnnamedLabel, 0); }
		public LabelRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterLabelRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitLabelRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitLabelRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelRefContext labelRef() throws RecognitionException {
		LabelRefContext _localctx = new LabelRefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_labelRef);
		int _la;
		try {
			int _alt;
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case COLONCOLON:
			case Identifier:
			case Addressing:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Addressing) {
					{
					setState(220);
					match(Addressing);
					}
				}

				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLONCOLON) {
					{
					setState(223);
					((LabelRefContext)_localctx).global = match(COLONCOLON);
					}
				}

				setState(226);
				identifier();
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(227);
						match(COLONCOLON);
						setState(228);
						identifier();
						}
						} 
					}
					setState(233);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				}
				break;
			case UnnamedLabel:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(UnnamedLabel);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarRefContext extends ParserRuleContext {
		public Token var;
		public TerminalNode PseudoVar() { return getToken(CA65Parser.PseudoVar, 0); }
		public VarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarRefContext varRef() throws RecognitionException {
		VarRefContext _localctx = new VarRefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			((VarRefContext)_localctx).var = match(PseudoVar);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionRefContext extends ParserRuleContext {
		public Token func;
		public ExpressionContext expression;
		public List<ExpressionContext> args = new ArrayList<ExpressionContext>();
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public TerminalNode PseudoFunc() { return getToken(CA65Parser.PseudoFunc, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public FunctionRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterFunctionRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitFunctionRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitFunctionRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionRefContext functionRef() throws RecognitionException {
		FunctionRefContext _localctx = new FunctionRefContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((FunctionRefContext)_localctx).func = match(PseudoFunc);
			setState(240);
			match(LPAREN);
			setState(241);
			((FunctionRefContext)_localctx).expression = expression();
			((FunctionRefContext)_localctx).args.add(((FunctionRefContext)_localctx).expression);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(242);
				match(COMMA);
				setState(243);
				((FunctionRefContext)_localctx).expression = expression();
				((FunctionRefContext)_localctx).args.add(((FunctionRefContext)_localctx).expression);
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CA65Parser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public TerminalNode Identifier() { return getToken(CA65Parser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_identifier);
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(IDENT);
				setState(252);
				match(LPAREN);
				setState(253);
				expression();
				setState(254);
				match(RPAREN);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CA65Parser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(CA65Parser.STRING, 0); }
		public TerminalNode PC() { return getToken(CA65Parser.PC, 0); }
		public TerminalNode MUL() { return getToken(CA65Parser.MUL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !(((((_la - 155)) & ~0x3f) == 0 && ((1L << (_la - 155)) & ((1L << (MUL - 155)) | (1L << (PC - 155)) | (1L << (NUMBER - 155)))) != 0) || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ProcContext proc() {
			return getRuleContext(ProcContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public RepeatContext repeat() {
			return getRuleContext(RepeatContext.class,0);
		}
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
		public MacroContext macro() {
			return getRuleContext(MacroContext.class,0);
		}
		public EndStmtContext endStmt() {
			return getRuleContext(EndStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROC:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				proc();
				}
				break;
			case SCOPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				scope();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				enumerator();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				struct();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				union();
				}
				break;
			case IF:
			case ELSE:
			case ELSEIF:
				enterOuterAlt(_localctx, 6);
				{
				setState(266);
				ifStmt();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(267);
				repeat();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 8);
				{
				setState(268);
				define();
				}
				break;
			case MACRO:
				enterOuterAlt(_localctx, 9);
				{
				setState(269);
				macro();
				}
				break;
			case ENDSCOPE:
			case ENDPROC:
			case ENDENUM:
			case ENDSTRUCT:
			case ENDUNION:
			case ENDIF:
			case ENDREPEAT:
			case ENDMACRO:
				enterOuterAlt(_localctx, 10);
				{
				setState(270);
				endStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcContext extends ParserRuleContext {
		public TerminalNode PROC() { return getToken(CA65Parser.PROC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ProcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterProc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitProc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitProc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcContext proc() throws RecognitionException {
		ProcContext _localctx = new ProcContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_proc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(PROC);
			setState(274);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public TerminalNode SCOPE() { return getToken(CA65Parser.SCOPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(SCOPE);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(277);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumMemberContext enumMember;
		public List<EnumMemberContext> member = new ArrayList<EnumMemberContext>();
		public TerminalNode ENUM() { return getToken(CA65Parser.ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<EnumMemberContext> enumMember() {
			return getRuleContexts(EnumMemberContext.class);
		}
		public EnumMemberContext enumMember(int i) {
			return getRuleContext(EnumMemberContext.class,i);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterEnumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitEnumerator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitEnumerator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_enumerator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(ENUM);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(281);
				identifier();
				}
			}

			setState(288); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(284);
					match(EOL);
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENT || _la==Identifier) {
						{
						setState(285);
						((EnumeratorContext)_localctx).enumMember = enumMember();
						((EnumeratorContext)_localctx).member.add(((EnumeratorContext)_localctx).enumMember);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(290); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumMemberContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelEquContext labelEqu() {
			return getRuleContext(LabelEquContext.class,0);
		}
		public EnumMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterEnumMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitEnumMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitEnumMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumMemberContext enumMember() throws RecognitionException {
		EnumMemberContext _localctx = new EnumMemberContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_enumMember);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				labelEqu();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructContext extends ParserRuleContext {
		public StructMemberContext structMember;
		public List<StructMemberContext> member = new ArrayList<StructMemberContext>();
		public TerminalNode STRUCT() { return getToken(CA65Parser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_struct);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(STRUCT);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(297);
				identifier();
				}
			}

			setState(304); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(300);
					match(EOL);
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==STRUCT || _la==UNION || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IDENT - 64)) | (1L << (BYTE - 64)) | (1L << (RES - 64)) | (1L << (DBYT - 64)) | (1L << (WORD - 64)) | (1L << (ADDR - 64)) | (1L << (FARADDR - 64)) | (1L << (DWORD - 64)) | (1L << (TAG - 64)))) != 0) || _la==Identifier) {
						{
						setState(301);
						((StructContext)_localctx).structMember = structMember();
						((StructContext)_localctx).member.add(((StructContext)_localctx).structMember);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(306); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionContext extends ParserRuleContext {
		public StructMemberContext structMember;
		public List<StructMemberContext> member = new ArrayList<StructMemberContext>();
		public TerminalNode UNION() { return getToken(CA65Parser.UNION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_union);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(UNION);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(309);
				identifier();
				}
			}

			setState(316); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(312);
					match(EOL);
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==STRUCT || _la==UNION || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IDENT - 64)) | (1L << (BYTE - 64)) | (1L << (RES - 64)) | (1L << (DBYT - 64)) | (1L << (WORD - 64)) | (1L << (ADDR - 64)) | (1L << (FARADDR - 64)) | (1L << (DWORD - 64)) | (1L << (TAG - 64)))) != 0) || _la==Identifier) {
						{
						setState(313);
						((UnionContext)_localctx).structMember = structMember();
						((UnionContext)_localctx).member.add(((UnionContext)_localctx).structMember);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructMemberContext extends ParserRuleContext {
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterStructMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitStructMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitStructMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_structMember);
		try {
			setState(323);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				struct();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				union();
				}
				break;
			case IDENT:
			case BYTE:
			case RES:
			case DBYT:
			case WORD:
			case ADDR:
			case FARADDR:
			case DWORD:
			case TAG:
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				field();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public Token allocator;
		public TerminalNode BYTE() { return getToken(CA65Parser.BYTE, 0); }
		public TerminalNode RES() { return getToken(CA65Parser.RES, 0); }
		public TerminalNode DBYT() { return getToken(CA65Parser.DBYT, 0); }
		public TerminalNode WORD() { return getToken(CA65Parser.WORD, 0); }
		public TerminalNode ADDR() { return getToken(CA65Parser.ADDR, 0); }
		public TerminalNode FARADDR() { return getToken(CA65Parser.FARADDR, 0); }
		public TerminalNode DWORD() { return getToken(CA65Parser.DWORD, 0); }
		public TerminalNode TAG() { return getToken(CA65Parser.TAG, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(325);
				identifier();
				}
			}

			setState(328);
			((FieldContext)_localctx).allocator = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (BYTE - 83)) | (1L << (RES - 83)) | (1L << (DBYT - 83)) | (1L << (WORD - 83)) | (1L << (ADDR - 83)) | (1L << (FARADDR - 83)) | (1L << (DWORD - 83)) | (1L << (TAG - 83)))) != 0)) ) {
				((FieldContext)_localctx).allocator = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (PseudoVar - 1)) | (1L << (PseudoFunc - 1)) | (1L << (IDENT - 1)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (PLUS - 147)) | (1L << (MINUS - 147)) | (1L << (BITNOT - 147)) | (1L << (LOBYTE - 147)) | (1L << (HIBYTE - 147)) | (1L << (LOWORD - 147)) | (1L << (HIWORD - 147)) | (1L << (BANKBYTE - 147)) | (1L << (MUL - 147)) | (1L << (LT - 147)) | (1L << (GT - 147)) | (1L << (NOT - 147)) | (1L << (LPAREN - 147)) | (1L << (COLONCOLON - 147)) | (1L << (PC - 147)) | (1L << (NUMBER - 147)) | (1L << (Identifier - 147)) | (1L << (Addressing - 147)) | (1L << (UnnamedLabel - 147)))) != 0) || _la==STRING) {
				{
				setState(329);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	 
		public IfStmtContext() { }
		public void copyFrom(IfStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ElseIfContext extends IfStmtContext {
		public TerminalNode ELSEIF() { return getToken(CA65Parser.ELSEIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseIfContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterElseIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitElseIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitElseIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ElseContext extends IfStmtContext {
		public TerminalNode ELSE() { return getToken(CA65Parser.ELSE, 0); }
		public ElseContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends IfStmtContext {
		public Token type;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IF() { return getToken(CA65Parser.IF, 0); }
		public IfContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifStmt);
		try {
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				((IfContext)_localctx).type = match(IF);
				setState(333);
				expression();
				}
				break;
			case ELSEIF:
				_localctx = new ElseIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				match(ELSEIF);
				setState(335);
				expression();
				}
				break;
			case ELSE:
				_localctx = new ElseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				match(ELSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(CA65Parser.REPEAT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CA65Parser.COMMA, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public RepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitRepeat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitRepeat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatContext repeat() throws RecognitionException {
		RepeatContext _localctx = new RepeatContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_repeat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(REPEAT);
			setState(340);
			expression();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(341);
				match(COMMA);
				setState(342);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> param = new ArrayList<IdentifierContext>();
		public TerminalNode DEFINE() { return getToken(CA65Parser.DEFINE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(DEFINE);
			setState(346);
			((DefineContext)_localctx).name = identifier();
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(347);
				match(LPAREN);
				setState(348);
				((DefineContext)_localctx).identifier = identifier();
				((DefineContext)_localctx).param.add(((DefineContext)_localctx).identifier);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(349);
					match(COMMA);
					setState(350);
					((DefineContext)_localctx).identifier = identifier();
					((DefineContext)_localctx).param.add(((DefineContext)_localctx).identifier);
					}
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(356);
				match(RPAREN);
				}
				break;
			}
			setState(360);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> param = new ArrayList<IdentifierContext>();
		public TerminalNode MACRO() { return getToken(CA65Parser.MACRO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitMacro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitMacro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_macro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(MACRO);
			setState(363);
			((MacroContext)_localctx).name = identifier();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(364);
				((MacroContext)_localctx).identifier = identifier();
				((MacroContext)_localctx).param.add(((MacroContext)_localctx).identifier);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(365);
					match(COMMA);
					setState(366);
					((MacroContext)_localctx).identifier = identifier();
					((MacroContext)_localctx).param.add(((MacroContext)_localctx).identifier);
					}
					}
					setState(371);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndStmtContext extends ParserRuleContext {
		public Token end;
		public TerminalNode ENDPROC() { return getToken(CA65Parser.ENDPROC, 0); }
		public TerminalNode ENDSCOPE() { return getToken(CA65Parser.ENDSCOPE, 0); }
		public TerminalNode ENDENUM() { return getToken(CA65Parser.ENDENUM, 0); }
		public TerminalNode ENDSTRUCT() { return getToken(CA65Parser.ENDSTRUCT, 0); }
		public TerminalNode ENDUNION() { return getToken(CA65Parser.ENDUNION, 0); }
		public TerminalNode ENDMACRO() { return getToken(CA65Parser.ENDMACRO, 0); }
		public TerminalNode ENDIF() { return getToken(CA65Parser.ENDIF, 0); }
		public TerminalNode ENDREPEAT() { return getToken(CA65Parser.ENDREPEAT, 0); }
		public EndStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterEndStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitEndStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitEndStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndStmtContext endStmt() throws RecognitionException {
		EndStmtContext _localctx = new EndStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_endStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			((EndStmtContext)_localctx).end = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENDSCOPE) | (1L << ENDPROC) | (1L << ENDENUM) | (1L << ENDSTRUCT) | (1L << ENDUNION) | (1L << ENDIF) | (1L << ENDREPEAT) | (1L << ENDMACRO))) != 0)) ) {
				((EndStmtContext)_localctx).end = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageContext extends ParserRuleContext {
		public Token allocator;
		public TerminalNode Allocator() { return getToken(CA65Parser.Allocator, 0); }
		public InlineLabelContext inlineLabel() {
			return getRuleContext(InlineLabelContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public StorageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterStorage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitStorage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitStorage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StorageContext storage() throws RecognitionException {
		StorageContext _localctx = new StorageContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_storage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(376);
				inlineLabel();
				}
			}

			setState(379);
			((StorageContext)_localctx).allocator = match(Allocator);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (PseudoVar - 1)) | (1L << (PseudoFunc - 1)) | (1L << (IDENT - 1)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (PLUS - 147)) | (1L << (MINUS - 147)) | (1L << (BITNOT - 147)) | (1L << (LOBYTE - 147)) | (1L << (HIBYTE - 147)) | (1L << (LOWORD - 147)) | (1L << (HIWORD - 147)) | (1L << (BANKBYTE - 147)) | (1L << (MUL - 147)) | (1L << (LT - 147)) | (1L << (GT - 147)) | (1L << (NOT - 147)) | (1L << (LPAREN - 147)) | (1L << (COLONCOLON - 147)) | (1L << (PC - 147)) | (1L << (NUMBER - 147)) | (1L << (Identifier - 147)) | (1L << (Addressing - 147)) | (1L << (UnnamedLabel - 147)))) != 0) || _la==STRING) {
				{
				setState(380);
				expression();
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(381);
					match(COMMA);
					setState(382);
					expression();
					}
					}
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlContext extends ParserRuleContext {
		public Token command;
		public TerminalNode Control() { return getToken(CA65Parser.Control, 0); }
		public TerminalNode PLUS() { return getToken(CA65Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CA65Parser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public ControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlContext control() throws RecognitionException {
		ControlContext _localctx = new ControlContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_control);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			((ControlContext)_localctx).command = match(Control);
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				{
				setState(391);
				expression();
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(392);
					match(COMMA);
					setState(393);
					expression();
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				setState(399);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpansionContext extends ParserRuleContext {
		public ExpansionPushContext expansionPush() {
			return getRuleContext(ExpansionPushContext.class,0);
		}
		public ExpansionPopContext expansionPop() {
			return getRuleContext(ExpansionPopContext.class,0);
		}
		public ExpansionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expansion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterExpansion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitExpansion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitExpansion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpansionContext expansion() throws RecognitionException {
		ExpansionContext _localctx = new ExpansionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_expansion);
		try {
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				expansionPush();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				expansionPop();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpansionPushContext extends ParserRuleContext {
		public Token name;
		public Token col;
		public Token source;
		public TerminalNode IMMEDIATE() { return getToken(CA65Parser.IMMEDIATE, 0); }
		public TerminalNode Identifier() { return getToken(CA65Parser.Identifier, 0); }
		public TerminalNode NUMBER() { return getToken(CA65Parser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(CA65Parser.STRING, 0); }
		public ExpansionPushContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expansionPush; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterExpansionPush(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitExpansionPush(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitExpansionPush(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpansionPushContext expansionPush() throws RecognitionException {
		ExpansionPushContext _localctx = new ExpansionPushContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_expansionPush);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(IMMEDIATE);
			setState(407);
			match(T__1);
			setState(408);
			((ExpansionPushContext)_localctx).name = match(Identifier);
			setState(409);
			((ExpansionPushContext)_localctx).col = match(NUMBER);
			setState(410);
			((ExpansionPushContext)_localctx).source = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpansionPopContext extends ParserRuleContext {
		public Token offset;
		public TerminalNode IMMEDIATE() { return getToken(CA65Parser.IMMEDIATE, 0); }
		public TerminalNode NUMBER() { return getToken(CA65Parser.NUMBER, 0); }
		public ExpansionPopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expansionPop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterExpansionPop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitExpansionPop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitExpansionPop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpansionPopContext expansionPop() throws RecognitionException {
		ExpansionPopContext _localctx = new ExpansionPopContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_expansionPop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(IMMEDIATE);
			setState(413);
			match(T__2);
			setState(414);
			((ExpansionPopContext)_localctx).offset = match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0175\u01a3\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\7\2P\n\2\f\2\16\2S\13"+
		"\2\3\2\3\2\3\2\5\2X\n\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3i\n\3\3\4\3\4\3\4\3\4\5\4o\n\4\3\5\5\5r\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5y\n\5\3\5\3\5\3\5\5\5~\n\5\3\5\5\5\u0081\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u0089\n\5\5\5\u008b\n\5\3\6\5\6\u008e\n\6\3\6\3"+
		"\6\3\6\3\6\5\6\u0094\n\6\3\7\5\7\u0097\n\7\3\7\3\7\3\7\3\7\3\b\5\b\u009e"+
		"\n\b\3\b\3\b\5\b\u00a2\n\b\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u00aa\n\n\3\13"+
		"\3\13\3\13\3\13\3\f\5\f\u00b1\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c2\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00d0\n\16\f\16\16\16\u00d3"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00dd\n\17\3\20\5"+
		"\20\u00e0\n\20\3\20\5\20\u00e3\n\20\3\20\3\20\3\20\7\20\u00e8\n\20\f\20"+
		"\16\20\u00eb\13\20\3\20\5\20\u00ee\n\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\7\22\u00f7\n\22\f\22\16\22\u00fa\13\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0104\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0112\n\25\3\26\3\26\3\26\3\27\3\27\5\27\u0119"+
		"\n\27\3\30\3\30\5\30\u011d\n\30\3\30\3\30\5\30\u0121\n\30\6\30\u0123\n"+
		"\30\r\30\16\30\u0124\3\31\3\31\5\31\u0129\n\31\3\32\3\32\5\32\u012d\n"+
		"\32\3\32\3\32\5\32\u0131\n\32\6\32\u0133\n\32\r\32\16\32\u0134\3\33\3"+
		"\33\5\33\u0139\n\33\3\33\3\33\5\33\u013d\n\33\6\33\u013f\n\33\r\33\16"+
		"\33\u0140\3\34\3\34\3\34\5\34\u0146\n\34\3\35\5\35\u0149\n\35\3\35\3\35"+
		"\5\35\u014d\n\35\3\36\3\36\3\36\3\36\3\36\5\36\u0154\n\36\3\37\3\37\3"+
		"\37\3\37\5\37\u015a\n\37\3 \3 \3 \3 \3 \3 \7 \u0162\n \f \16 \u0165\13"+
		" \3 \3 \5 \u0169\n \3 \3 \3!\3!\3!\3!\3!\7!\u0172\n!\f!\16!\u0175\13!"+
		"\5!\u0177\n!\3\"\3\"\3#\5#\u017c\n#\3#\3#\3#\3#\7#\u0182\n#\f#\16#\u0185"+
		"\13#\5#\u0187\n#\3$\3$\3$\3$\7$\u018d\n$\f$\16$\u0190\13$\3$\5$\u0193"+
		"\n$\3%\3%\5%\u0197\n%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\2\3\32(\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"\2\f\6\2\3\3\u0095\u0097\u00a7\u00a7\u00a9\u00a9\3\2\u0098\u009c\3\2\u009d"+
		"\u00a3\4\2\u0095\u0096\u00a4\u00a4\3\2\u00a5\u00aa\3\2\u00ab\u00ad\6\2"+
		"\u009d\u009d\u00b9\u00b9\u00bd\u00bd\u0172\u0172\4\2U[``\n\2\f\f\16\16"+
		"\20\20\22\22\24\24\26\26\32\32\35\35\3\2\u0095\u0096\2\u01cd\2Q\3\2\2"+
		"\2\4h\3\2\2\2\6n\3\2\2\2\b\u008a\3\2\2\2\n\u008d\3\2\2\2\f\u0096\3\2\2"+
		"\2\16\u009d\3\2\2\2\20\u00a3\3\2\2\2\22\u00a9\3\2\2\2\24\u00ab\3\2\2\2"+
		"\26\u00b0\3\2\2\2\30\u00b4\3\2\2\2\32\u00c1\3\2\2\2\34\u00dc\3\2\2\2\36"+
		"\u00ed\3\2\2\2 \u00ef\3\2\2\2\"\u00f1\3\2\2\2$\u0103\3\2\2\2&\u0105\3"+
		"\2\2\2(\u0111\3\2\2\2*\u0113\3\2\2\2,\u0116\3\2\2\2.\u011a\3\2\2\2\60"+
		"\u0128\3\2\2\2\62\u012a\3\2\2\2\64\u0136\3\2\2\2\66\u0145\3\2\2\28\u0148"+
		"\3\2\2\2:\u0153\3\2\2\2<\u0155\3\2\2\2>\u015b\3\2\2\2@\u016c\3\2\2\2B"+
		"\u0178\3\2\2\2D\u017b\3\2\2\2F\u0188\3\2\2\2H\u0196\3\2\2\2J\u0198\3\2"+
		"\2\2L\u019e\3\2\2\2NP\7\u0174\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2"+
		"\2\2RT\3\2\2\2SQ\3\2\2\2T[\5\4\3\2UW\7\u0174\2\2VX\5\4\3\2WV\3\2\2\2W"+
		"X\3\2\2\2XZ\3\2\2\2YU\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2"+
		"\2][\3\2\2\2^_\7\2\2\3_\3\3\2\2\2`i\5\6\4\2ai\5\20\t\2bi\5\22\n\2ci\5"+
		"\24\13\2di\5(\25\2ei\5D#\2fi\5F$\2gi\5H%\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2"+
		"\2hc\3\2\2\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\5\3\2\2\2jo\5\b"+
		"\5\2ko\5\n\6\2lo\5\f\7\2mo\5\16\b\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2nm\3"+
		"\2\2\2o\7\3\2\2\2pr\5\26\f\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\6\2\2t"+
		"u\7\u00af\2\2ux\5\30\r\2vw\7\u00b5\2\2wy\7\u00bb\2\2xv\3\2\2\2xy\3\2\2"+
		"\2yz\3\2\2\2z}\7\u00b0\2\2{|\7\u00b5\2\2|~\7\u00bb\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\u008b\3\2\2\2\177\u0081\5\26\f\2\u0080\177\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\6\2\2\u0083\u0084\7\u00b3\2\2"+
		"\u0084\u0085\5\30\r\2\u0085\u0088\7\u00b4\2\2\u0086\u0087\7\u00b5\2\2"+
		"\u0087\u0089\7\u00bb\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008aq\3\2\2\2\u008a\u0080\3\2\2\2\u008b\t\3\2\2\2\u008c"+
		"\u008e\5\26\f\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u0090\7\6\2\2\u0090\u0093\5\30\r\2\u0091\u0092\7\u00b5\2"+
		"\2\u0092\u0094\7\u00bb\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\13\3\2\2\2\u0095\u0097\5\26\f\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2"+
		"\2\u0097\u0098\3\2\2\2\u0098\u0099\7\6\2\2\u0099\u009a\7\u00ba\2\2\u009a"+
		"\u009b\5\30\r\2\u009b\r\3\2\2\2\u009c\u009e\5\26\f\2\u009d\u009c\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\7\6\2\2\u00a0\u00a2"+
		"\7\u00bc\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\17\3\2\2\2"+
		"\u00a3\u00a4\5$\23\2\u00a4\u00a5\7\u00a5\2\2\u00a5\u00a6\5\30\r\2\u00a6"+
		"\21\3\2\2\2\u00a7\u00aa\5\26\f\2\u00a8\u00aa\5$\23\2\u00a9\u00a7\3\2\2"+
		"\2\u00a9\u00a8\3\2\2\2\u00aa\23\3\2\2\2\u00ab\u00ac\5$\23\2\u00ac\u00ad"+
		"\7\33\2\2\u00ad\u00ae\5\30\r\2\u00ae\25\3\2\2\2\u00af\u00b1\5$\23\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\u00b7"+
		"\2\2\u00b3\27\3\2\2\2\u00b4\u00b5\5\32\16\2\u00b5\31\3\2\2\2\u00b6\u00b7"+
		"\b\16\1\2\u00b7\u00c2\5\34\17\2\u00b8\u00b9\t\2\2\2\u00b9\u00c2\5\32\16"+
		"\t\u00ba\u00bb\t\3\2\2\u00bb\u00bc\7\u00af\2\2\u00bc\u00bd\5\32\16\2\u00bd"+
		"\u00be\7\u00b0\2\2\u00be\u00c2\3\2\2\2\u00bf\u00c0\7\u00ae\2\2\u00c0\u00c2"+
		"\5\32\16\3\u00c1\u00b6\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00ba\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c2\u00d1\3\2\2\2\u00c3\u00c4\f\7\2\2\u00c4\u00c5"+
		"\t\4\2\2\u00c5\u00d0\5\32\16\b\u00c6\u00c7\f\6\2\2\u00c7\u00c8\t\5\2\2"+
		"\u00c8\u00d0\5\32\16\7\u00c9\u00ca\f\5\2\2\u00ca\u00cb\t\6\2\2\u00cb\u00d0"+
		"\5\32\16\6\u00cc\u00cd\f\4\2\2\u00cd\u00ce\t\7\2\2\u00ce\u00d0\5\32\16"+
		"\5\u00cf\u00c3\3\2\2\2\u00cf\u00c6\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00cc"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\33\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\u00af\2\2\u00d5\u00d6\5"+
		"\30\r\2\u00d6\u00d7\7\u00b0\2\2\u00d7\u00dd\3\2\2\2\u00d8\u00dd\5&\24"+
		"\2\u00d9\u00dd\5 \21\2\u00da\u00dd\5\"\22\2\u00db\u00dd\5\36\20\2\u00dc"+
		"\u00d4\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00db\3\2\2\2\u00dd\35\3\2\2\2\u00de\u00e0\7\u00c2\2\2\u00df"+
		"\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00e3\7\u00b8"+
		"\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e9\5$\23\2\u00e5\u00e6\7\u00b8\2\2\u00e6\u00e8\5$\23\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ee\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\7\u00c5\2\2\u00ed\u00df"+
		"\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\37\3\2\2\2\u00ef\u00f0\7\7\2\2\u00f0"+
		"!\3\2\2\2\u00f1\u00f2\7\b\2\2\u00f2\u00f3\7\u00af\2\2\u00f3\u00f8\5\30"+
		"\r\2\u00f4\u00f5\7\u00b5\2\2\u00f5\u00f7\5\30\r\2\u00f6\u00f4\3\2\2\2"+
		"\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\u00b0\2\2\u00fc#\3\2\2\2\u00fd"+
		"\u00fe\7B\2\2\u00fe\u00ff\7\u00af\2\2\u00ff\u0100\5\30\r\2\u0100\u0101"+
		"\7\u00b0\2\2\u0101\u0104\3\2\2\2\u0102\u0104\7\u00c1\2\2\u0103\u00fd\3"+
		"\2\2\2\u0103\u0102\3\2\2\2\u0104%\3\2\2\2\u0105\u0106\t\b\2\2\u0106\'"+
		"\3\2\2\2\u0107\u0112\5*\26\2\u0108\u0112\5,\27\2\u0109\u0112\5.\30\2\u010a"+
		"\u0112\5\62\32\2\u010b\u0112\5\64\33\2\u010c\u0112\5:\36\2\u010d\u0112"+
		"\5<\37\2\u010e\u0112\5> \2\u010f\u0112\5@!\2\u0110\u0112\5B\"\2\u0111"+
		"\u0107\3\2\2\2\u0111\u0108\3\2\2\2\u0111\u0109\3\2\2\2\u0111\u010a\3\2"+
		"\2\2\u0111\u010b\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2\2\2\u0111"+
		"\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112)\3\2\2\2"+
		"\u0113\u0114\7\r\2\2\u0114\u0115\5$\23\2\u0115+\3\2\2\2\u0116\u0118\7"+
		"\13\2\2\u0117\u0119\5$\23\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"-\3\2\2\2\u011a\u011c\7\17\2\2\u011b\u011d\5$\23\2\u011c\u011b\3\2\2\2"+
		"\u011c\u011d\3\2\2\2\u011d\u0122\3\2\2\2\u011e\u0120\7\u0174\2\2\u011f"+
		"\u0121\5\60\31\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3"+
		"\2\2\2\u0122\u011e\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125/\3\2\2\2\u0126\u0129\5$\23\2\u0127\u0129\5\20\t\2"+
		"\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\61\3\2\2\2\u012a\u012c"+
		"\7\21\2\2\u012b\u012d\5$\23\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2\2\2"+
		"\u012d\u0132\3\2\2\2\u012e\u0130\7\u0174\2\2\u012f\u0131\5\66\34\2\u0130"+
		"\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u012e\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\63\3\2\2\2\u0136\u0138\7\23\2\2\u0137\u0139\5$\23\2\u0138\u0137\3\2\2"+
		"\2\u0138\u0139\3\2\2\2\u0139\u013e\3\2\2\2\u013a\u013c\7\u0174\2\2\u013b"+
		"\u013d\5\66\34\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3"+
		"\2\2\2\u013e\u013a\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\65\3\2\2\2\u0142\u0146\5\62\32\2\u0143\u0146\5\64"+
		"\33\2\u0144\u0146\58\35\2\u0145\u0142\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0144\3\2\2\2\u0146\67\3\2\2\2\u0147\u0149\5$\23\2\u0148\u0147\3\2\2"+
		"\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\t\t\2\2\u014b\u014d"+
		"\5\30\r\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d9\3\2\2\2\u014e"+
		"\u014f\7\25\2\2\u014f\u0154\5\30\r\2\u0150\u0151\7\30\2\2\u0151\u0154"+
		"\5\30\r\2\u0152\u0154\7\27\2\2\u0153\u014e\3\2\2\2\u0153\u0150\3\2\2\2"+
		"\u0153\u0152\3\2\2\2\u0154;\3\2\2\2\u0155\u0156\7\31\2\2\u0156\u0159\5"+
		"\30\r\2\u0157\u0158\7\u00b5\2\2\u0158\u015a\5$\23\2\u0159\u0157\3\2\2"+
		"\2\u0159\u015a\3\2\2\2\u015a=\3\2\2\2\u015b\u015c\7 \2\2\u015c\u0168\5"+
		"$\23\2\u015d\u015e\7\u00af\2\2\u015e\u0163\5$\23\2\u015f\u0160\7\u00b5"+
		"\2\2\u0160\u0162\5$\23\2\u0161\u015f\3\2\2\2\u0162\u0165\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0163\3\2"+
		"\2\2\u0166\u0167\7\u00b0\2\2\u0167\u0169\3\2\2\2\u0168\u015d\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\5\30\r\2\u016b?\3\2\2\2"+
		"\u016c\u016d\7\34\2\2\u016d\u0176\5$\23\2\u016e\u0173\5$\23\2\u016f\u0170"+
		"\7\u00b5\2\2\u0170\u0172\5$\23\2\u0171\u016f\3\2\2\2\u0172\u0175\3\2\2"+
		"\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173"+
		"\3\2\2\2\u0176\u016e\3\2\2\2\u0176\u0177\3\2\2\2\u0177A\3\2\2\2\u0178"+
		"\u0179\t\n\2\2\u0179C\3\2\2\2\u017a\u017c\5\26\f\2\u017b\u017a\3\2\2\2"+
		"\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0186\7\t\2\2\u017e\u0183"+
		"\5\30\r\2\u017f\u0180\7\u00b5\2\2\u0180\u0182\5\30\r\2\u0181\u017f\3\2"+
		"\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u017e\3\2\2\2\u0186\u0187\3\2"+
		"\2\2\u0187E\3\2\2\2\u0188\u0192\7\n\2\2\u0189\u018e\5\30\r\2\u018a\u018b"+
		"\7\u00b5\2\2\u018b\u018d\5\30\r\2\u018c\u018a\3\2\2\2\u018d\u0190\3\2"+
		"\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0193\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0191\u0193\t\13\2\2\u0192\u0189\3\2\2\2\u0192\u0191\3"+
		"\2\2\2\u0192\u0193\3\2\2\2\u0193G\3\2\2\2\u0194\u0197\5J&\2\u0195\u0197"+
		"\5L\'\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197I\3\2\2\2\u0198\u0199"+
		"\7\u00ba\2\2\u0199\u019a\7\4\2\2\u019a\u019b\7\u00c1\2\2\u019b\u019c\7"+
		"\u00bd\2\2\u019c\u019d\7\u0172\2\2\u019dK\3\2\2\2\u019e\u019f\7\u00ba"+
		"\2\2\u019f\u01a0\7\5\2\2\u01a0\u01a1\7\u00bd\2\2\u01a1M\3\2\2\29QW[hn"+
		"qx}\u0080\u0088\u008a\u008d\u0093\u0096\u009d\u00a1\u00a9\u00b0\u00c1"+
		"\u00cf\u00d1\u00dc\u00df\u00e2\u00e9\u00ed\u00f8\u0103\u0111\u0118\u011c"+
		"\u0120\u0124\u0128\u012c\u0130\u0134\u0138\u013c\u0140\u0145\u0148\u014c"+
		"\u0153\u0159\u0163\u0168\u0173\u0176\u017b\u0183\u0186\u018e\u0192\u0196";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}