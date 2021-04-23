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
		T__0=1, Opcode=2, PseudoVar=3, PseudoFunc=4, Allocator=5, Control=6, SCOPE=7, 
		ENDSCOPE=8, PROC=9, ENDPROC=10, ENUM=11, ENDENUM=12, STRUCT=13, ENDSTRUCT=14, 
		UNION=15, ENDUNION=16, IF=17, ENDIF=18, ELSE=19, ELSEIF=20, REPEAT=21, 
		ENDREPEAT=22, SET=23, MACRO=24, ENDMACRO=25, DELMACRO=26, EXITMACRO=27, 
		DEFINE=28, UNDEFINE=29, LOCAL=30, ASIZE=31, CPU=32, ISIZE=33, PARAMCOUNT=34, 
		TIME=35, VERSION=36, CPU_ISET_NONE=37, CPU_ISET_6502=38, CPU_ISET_6502X=39, 
		CPU_ISET_6502DTV=40, CPU_ISET_65SC02=41, CPU_ISET_65C02=42, CPU_ISET_65816=43, 
		CPU_ISET_SWEET16=44, CPU_ISET_HUC6280=45, CPU_ISET_4510=46, CPU_NONE=47, 
		CPU_6502=48, CPU_6502X=49, CPU_6502DTV=50, CPU_65SC02=51, CPU_65C02=52, 
		CPU_65816=53, CPU_SWEET16=54, CPU_HUC6280=55, CPU_4510=56, ADDRSIZE=57, 
		BANK=58, BLANK=59, CONCAT=60, CONST=61, IDENT=62, LEFT=63, MATCH=64, MAX=65, 
		MID=66, MIN=67, REF=68, REFERENCED=69, RIGHT=70, SIZEOF=71, STRAT=72, 
		SPRINTF=73, STRING_=74, STRLEN=75, TCOUNT=76, XMATCH=77, DEFINED=78, DEFINEDMACRO=79, 
		ISMNEMONIC=80, BYTE=81, RES=82, DBYT=83, WORD=84, ADDR=85, FARADDR=86, 
		DWORD=87, ASCIIZ=88, LOBYTES=89, HIBYTES=90, BANKBYTES=91, TAG=92, A16=93, 
		A8=94, ALIGN=95, ASSERT=96, AUTOIMPORT=97, BSS=98, CASE=99, CHARMAP=100, 
		CODE=101, CONDES=102, CONSTRUCTOR=103, DATA=104, DEBUGINFO=105, DESTRUCTOR=106, 
		END=107, ERROR=108, EXPORT=109, EXPORTZP=110, FATAL=111, FEATURE=112, 
		FILEOPT=113, FOPT=114, FORCEIMPORT=115, GLOBAL=116, GLOBALZP=117, I16=118, 
		I8=119, IMPORT=120, IMPORTZP=121, INCBIN=122, INCLUDE=123, INTERRUPTOR=124, 
		LINECONT=125, LIST=126, LISTBYTES=127, LOCALCHAR=128, MACPACK=129, ORG=130, 
		OUT=131, PAGELEN=132, PAGELENGTH=133, POPCPU=134, POPSEG=135, PUSHCPU=136, 
		PUSHSEG=137, RELOC=138, RODATA=139, SEGMENT=140, SETCPU=141, SMART=142, 
		WARNING=143, ZEROPAGE=144, PLUS=145, MINUS=146, BITNOT=147, LOBYTE=148, 
		HIBYTE=149, LOWORD=150, HIWORD=151, BANKBYTE=152, MUL=153, DIV=154, MOD=155, 
		BITAND=156, BITXOR=157, SHL=158, SHR=159, BITOR=160, EQ=161, NE=162, LT=163, 
		LE=164, GT=165, GE=166, AND_=167, XOR=168, OR=169, NOT=170, LPAREN=171, 
		RPAREN=172, LBRACE=173, RBRACE=174, LBRACK=175, RBRACK=176, COMMA=177, 
		DOT=178, COLON=179, COLONCOLON=180, PC=181, IMMEDIATE=182, INDEX=183, 
		ACC=184, NUMBER=185, DIGIT=186, HEX=187, BIN=188, Identifier=189, Addressing=190, 
		Diretive=191, CheapLabel=192, UnnamedLabel=193, Label=194, ADC=195, AND=196, 
		ASL=197, BCC=198, BCS=199, BEQ=200, BIT=201, BMI=202, BNE=203, BPL=204, 
		BRK=205, BVC=206, BVS=207, CLC=208, CLD=209, CLI=210, CLV=211, CMP=212, 
		CPX=213, CPY=214, DEC=215, DEX=216, DEY=217, EOR=218, INC=219, INX=220, 
		INY=221, JMP=222, JSR=223, LDA=224, LDX=225, LDY=226, LSR=227, NOP=228, 
		ORA=229, PHA=230, PHP=231, PLA=232, PLP=233, ROL=234, ROR=235, RTI=236, 
		RTS=237, SBC=238, SEC=239, SED=240, SEI=241, STA=242, STX=243, STY=244, 
		TAX=245, TAY=246, TSX=247, TXA=248, TXS=249, TYA=250, BRA=251, PHX=252, 
		PHY=253, PLX=254, PLY=255, STZ=256, TRB=257, TSB=258, BBR0=259, BBR1=260, 
		BBR2=261, BBR3=262, BBR4=263, BBR5=264, BBR6=265, BBR7=266, BBS0=267, 
		BBS1=268, BBS2=269, BBS3=270, BBS4=271, BBS5=272, BBS6=273, BBS7=274, 
		RMB0=275, RMB1=276, RMB2=277, RMB3=278, RMB4=279, RMB5=280, RMB6=281, 
		RMB7=282, SMB0=283, SMB1=284, SMB2=285, SMB3=286, SMB4=287, SMB5=288, 
		SMB6=289, SMB7=290, ALR=291, ANC=292, ARR=293, AXS=294, DCP=295, ISC=296, 
		LAS=297, LAX=298, RLA=299, RRA=300, SAX=301, SLO=302, SRE=303, BRL=304, 
		COP=305, JML=306, JSL=307, MVN=308, MVP=309, PEA=310, PEI=311, PER=312, 
		PHB=313, PHD=314, PHK=315, PLB=316, PLD=317, REP=318, RTL=319, SEP=320, 
		STP=321, TCD=322, TCS=323, TDC=324, TSC=325, TXY=326, TYX=327, WAI=328, 
		WDM=329, XBA=330, XCE=331, CPA=332, DEA=333, INA=334, SWA=335, TAD=336, 
		TAS=337, TDA=338, TSA=339, LBCC=340, LBCS=341, LBEQ=342, LBMI=343, LBNE=344, 
		LBPL=345, LBVC=346, LBVS=347, ADD=348, SUB=349, BGE=350, BLT=351, BGT=352, 
		BLE=353, BNZ=354, BZE=355, JEQ=356, JNE=357, JMI=358, JPL=359, JCS=360, 
		JCC=361, JVS=362, JVC=363, COMMENT=364, C_COMMENT=365, STRING=366, CHAR=367, 
		EOL=368, WS=369;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_instruction = 2, RULE_indirectInstruction = 3, 
		RULE_absoluteInstruction = 4, RULE_immediateInstruction = 5, RULE_implicitInstruction = 6, 
		RULE_labelEqu = 7, RULE_labelDef = 8, RULE_varDef = 9, RULE_inlineLabel = 10, 
		RULE_expression = 11, RULE_primaryExpression = 12, RULE_labelRef = 13, 
		RULE_varRef = 14, RULE_functionRef = 15, RULE_identifier = 16, RULE_literal = 17, 
		RULE_statement = 18, RULE_proc = 19, RULE_scope = 20, RULE_enumerator = 21, 
		RULE_enumMember = 22, RULE_struct = 23, RULE_union = 24, RULE_structMember = 25, 
		RULE_field = 26, RULE_ifStmt = 27, RULE_elseif = 28, RULE_elseStmt = 29, 
		RULE_repeat = 30, RULE_define = 31, RULE_macro = 32, RULE_macline = 33, 
		RULE_storage = 34, RULE_control = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "instruction", "indirectInstruction", "absoluteInstruction", 
			"immediateInstruction", "implicitInstruction", "labelEqu", "labelDef", 
			"varDef", "inlineLabel", "expression", "primaryExpression", "labelRef", 
			"varRef", "functionRef", "identifier", "literal", "statement", "proc", 
			"scope", "enumerator", "enumMember", "struct", "union", "structMember", 
			"field", "ifStmt", "elseif", "elseStmt", "repeat", "define", "macro", 
			"macline", "storage", "control"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'^'", null, null, null, null, null, null, null, null, null, null, 
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
			null, "'+'", "'-'", null, null, null, null, null, null, "'*'", "'/'", 
			null, null, null, null, null, null, "'='", "'<>'", "'<'", "'<='", "'>'", 
			"'>='", null, null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"','", "'.'", "':'", "'::'", null, "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Opcode", "PseudoVar", "PseudoFunc", "Allocator", "Control", 
			"SCOPE", "ENDSCOPE", "PROC", "ENDPROC", "ENUM", "ENDENUM", "STRUCT", 
			"ENDSTRUCT", "UNION", "ENDUNION", "IF", "ENDIF", "ELSE", "ELSEIF", "REPEAT", 
			"ENDREPEAT", "SET", "MACRO", "ENDMACRO", "DELMACRO", "EXITMACRO", "DEFINE", 
			"UNDEFINE", "LOCAL", "ASIZE", "CPU", "ISIZE", "PARAMCOUNT", "TIME", "VERSION", 
			"CPU_ISET_NONE", "CPU_ISET_6502", "CPU_ISET_6502X", "CPU_ISET_6502DTV", 
			"CPU_ISET_65SC02", "CPU_ISET_65C02", "CPU_ISET_65816", "CPU_ISET_SWEET16", 
			"CPU_ISET_HUC6280", "CPU_ISET_4510", "CPU_NONE", "CPU_6502", "CPU_6502X", 
			"CPU_6502DTV", "CPU_65SC02", "CPU_65C02", "CPU_65816", "CPU_SWEET16", 
			"CPU_HUC6280", "CPU_4510", "ADDRSIZE", "BANK", "BLANK", "CONCAT", "CONST", 
			"IDENT", "LEFT", "MATCH", "MAX", "MID", "MIN", "REF", "REFERENCED", "RIGHT", 
			"SIZEOF", "STRAT", "SPRINTF", "STRING_", "STRLEN", "TCOUNT", "XMATCH", 
			"DEFINED", "DEFINEDMACRO", "ISMNEMONIC", "BYTE", "RES", "DBYT", "WORD", 
			"ADDR", "FARADDR", "DWORD", "ASCIIZ", "LOBYTES", "HIBYTES", "BANKBYTES", 
			"TAG", "A16", "A8", "ALIGN", "ASSERT", "AUTOIMPORT", "BSS", "CASE", "CHARMAP", 
			"CODE", "CONDES", "CONSTRUCTOR", "DATA", "DEBUGINFO", "DESTRUCTOR", "END", 
			"ERROR", "EXPORT", "EXPORTZP", "FATAL", "FEATURE", "FILEOPT", "FOPT", 
			"FORCEIMPORT", "GLOBAL", "GLOBALZP", "I16", "I8", "IMPORT", "IMPORTZP", 
			"INCBIN", "INCLUDE", "INTERRUPTOR", "LINECONT", "LIST", "LISTBYTES", 
			"LOCALCHAR", "MACPACK", "ORG", "OUT", "PAGELEN", "PAGELENGTH", "POPCPU", 
			"POPSEG", "PUSHCPU", "PUSHSEG", "RELOC", "RODATA", "SEGMENT", "SETCPU", 
			"SMART", "WARNING", "ZEROPAGE", "PLUS", "MINUS", "BITNOT", "LOBYTE", 
			"HIBYTE", "LOWORD", "HIWORD", "BANKBYTE", "MUL", "DIV", "MOD", "BITAND", 
			"BITXOR", "SHL", "SHR", "BITOR", "EQ", "NE", "LT", "LE", "GT", "GE", 
			"AND_", "XOR", "OR", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", 
			"RBRACK", "COMMA", "DOT", "COLON", "COLONCOLON", "PC", "IMMEDIATE", "INDEX", 
			"ACC", "NUMBER", "DIGIT", "HEX", "BIN", "Identifier", "Addressing", "Diretive", 
			"CheapLabel", "UnnamedLabel", "Label", "ADC", "AND", "ASL", "BCC", "BCS", 
			"BEQ", "BIT", "BMI", "BNE", "BPL", "BRK", "BVC", "BVS", "CLC", "CLD", 
			"CLI", "CLV", "CMP", "CPX", "CPY", "DEC", "DEX", "DEY", "EOR", "INC", 
			"INX", "INY", "JMP", "JSR", "LDA", "LDX", "LDY", "LSR", "NOP", "ORA", 
			"PHA", "PHP", "PLA", "PLP", "ROL", "ROR", "RTI", "RTS", "SBC", "SEC", 
			"SED", "SEI", "STA", "STX", "STY", "TAX", "TAY", "TSX", "TXA", "TXS", 
			"TYA", "BRA", "PHX", "PHY", "PLX", "PLY", "STZ", "TRB", "TSB", "BBR0", 
			"BBR1", "BBR2", "BBR3", "BBR4", "BBR5", "BBR6", "BBR7", "BBS0", "BBS1", 
			"BBS2", "BBS3", "BBS4", "BBS5", "BBS6", "BBS7", "RMB0", "RMB1", "RMB2", 
			"RMB3", "RMB4", "RMB5", "RMB6", "RMB7", "SMB0", "SMB1", "SMB2", "SMB3", 
			"SMB4", "SMB5", "SMB6", "SMB7", "ALR", "ANC", "ARR", "AXS", "DCP", "ISC", 
			"LAS", "LAX", "RLA", "RRA", "SAX", "SLO", "SRE", "BRL", "COP", "JML", 
			"JSL", "MVN", "MVP", "PEA", "PEI", "PER", "PHB", "PHD", "PHK", "PLB", 
			"PLD", "REP", "RTL", "SEP", "STP", "TCD", "TCS", "TDC", "TSC", "TXY", 
			"TYX", "WAI", "WDM", "XBA", "XCE", "CPA", "DEA", "INA", "SWA", "TAD", 
			"TAS", "TDA", "TSA", "LBCC", "LBCS", "LBEQ", "LBMI", "LBNE", "LBPL", 
			"LBVC", "LBVS", "ADD", "SUB", "BGE", "BLT", "BGT", "BLE", "BNZ", "BZE", 
			"JEQ", "JNE", "JMI", "JPL", "JCS", "JCC", "JVS", "JVC", "COMMENT", "C_COMMENT", 
			"STRING", "CHAR", "EOL", "WS"
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(72);
				match(EOL);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			line();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(79);
				match(EOL);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(80);
					line();
					}
				}

				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
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
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				labelEqu();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				labelDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				varDef();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				storage();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
				control();
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
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				indirectInstruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				absoluteInstruction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				immediateInstruction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
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
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==COLON || _la==Identifier) {
					{
					setState(105);
					inlineLabel();
					}
				}

				setState(108);
				match(Opcode);
				setState(109);
				match(LPAREN);
				setState(110);
				expression(0);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(111);
					match(COMMA);
					setState(112);
					match(INDEX);
					}
				}

				setState(115);
				match(RPAREN);
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

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==COLON || _la==Identifier) {
					{
					setState(120);
					inlineLabel();
					}
				}

				setState(123);
				match(Opcode);
				setState(124);
				match(LBRACK);
				setState(125);
				expression(0);
				setState(126);
				match(RBRACK);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(127);
					match(COMMA);
					setState(128);
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
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(133);
				inlineLabel();
				}
			}

			setState(136);
			match(Opcode);
			setState(137);
			expression(0);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(138);
				match(COMMA);
				setState(139);
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
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(142);
				inlineLabel();
				}
			}

			setState(145);
			match(Opcode);
			setState(146);
			match(IMMEDIATE);
			setState(147);
			expression(0);
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
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(149);
				inlineLabel();
				}
			}

			setState(152);
			match(Opcode);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACC) {
				{
				setState(153);
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
			setState(156);
			identifier();
			setState(157);
			match(EQ);
			setState(158);
			expression(0);
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
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				inlineLabel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
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
			setState(164);
			identifier();
			setState(165);
			match(SET);
			setState(166);
			expression(0);
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
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(168);
				identifier();
				}
			}

			setState(171);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicativeContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(CA65Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CA65Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CA65Parser.MOD, 0); }
		public TerminalNode BITAND() { return getToken(CA65Parser.BITAND, 0); }
		public TerminalNode BITXOR() { return getToken(CA65Parser.BITXOR, 0); }
		public TerminalNode SHL() { return getToken(CA65Parser.SHL, 0); }
		public TerminalNode SHR() { return getToken(CA65Parser.SHR, 0); }
		public MultiplicativeContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class AdditiveContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CA65Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CA65Parser.MINUS, 0); }
		public TerminalNode BITOR() { return getToken(CA65Parser.BITOR, 0); }
		public AdditiveContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class BitwiseContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND_() { return getToken(CA65Parser.AND_, 0); }
		public TerminalNode XOR() { return getToken(CA65Parser.XOR, 0); }
		public TerminalNode OR() { return getToken(CA65Parser.OR, 0); }
		public BitwiseContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class NegationContext extends ExpressionContext {
		public Token prefix;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(CA65Parser.NOT, 0); }
		public NegationContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class PrimaryContext extends ExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class ExtractionContext extends ExpressionContext {
		public Token prefix;
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
		public TerminalNode LOBYTE() { return getToken(CA65Parser.LOBYTE, 0); }
		public TerminalNode HIBYTE() { return getToken(CA65Parser.HIBYTE, 0); }
		public TerminalNode LOWORD() { return getToken(CA65Parser.LOWORD, 0); }
		public TerminalNode HIWORD() { return getToken(CA65Parser.HIWORD, 0); }
		public TerminalNode BANKBYTE() { return getToken(CA65Parser.BANKBYTE, 0); }
		public ExtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class UnaryContext extends ExpressionContext {
		public Token prefix;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CA65Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CA65Parser.MINUS, 0); }
		public TerminalNode BITNOT() { return getToken(CA65Parser.BITNOT, 0); }
		public TerminalNode LT() { return getToken(CA65Parser.LT, 0); }
		public TerminalNode GT() { return getToken(CA65Parser.GT, 0); }
		public UnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class ComparativeContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(CA65Parser.EQ, 0); }
		public TerminalNode NE() { return getToken(CA65Parser.NE, 0); }
		public TerminalNode LT() { return getToken(CA65Parser.LT, 0); }
		public TerminalNode GT() { return getToken(CA65Parser.GT, 0); }
		public TerminalNode LE() { return getToken(CA65Parser.LE, 0); }
		public TerminalNode GE() { return getToken(CA65Parser.GE, 0); }
		public ComparativeContext(ExpressionContext ctx) { copyFrom(ctx); }
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

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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

				setState(174);
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
				setState(175);
				((UnaryContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__0 || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (PLUS - 145)) | (1L << (MINUS - 145)) | (1L << (BITNOT - 145)) | (1L << (LT - 145)) | (1L << (GT - 145)))) != 0)) ) {
					((UnaryContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(176);
				expression(7);
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
				setState(177);
				((ExtractionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (LOBYTE - 148)) | (1L << (HIBYTE - 148)) | (1L << (LOWORD - 148)) | (1L << (HIWORD - 148)) | (1L << (BANKBYTE - 148)))) != 0)) ) {
					((ExtractionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(178);
				match(LPAREN);
				setState(179);
				expression(0);
				setState(180);
				match(RPAREN);
				}
				break;
			case NOT:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				((NegationContext)_localctx).prefix = match(NOT);
				setState(183);
				expression(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(187);
						((MultiplicativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (MUL - 153)) | (1L << (DIV - 153)) | (1L << (MOD - 153)) | (1L << (BITAND - 153)) | (1L << (BITXOR - 153)) | (1L << (SHL - 153)) | (1L << (SHR - 153)))) != 0)) ) {
							((MultiplicativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(190);
						((AdditiveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (PLUS - 145)) | (1L << (MINUS - 145)) | (1L << (BITOR - 145)))) != 0)) ) {
							((AdditiveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ComparativeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(193);
						((ComparativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (EQ - 161)) | (1L << (NE - 161)) | (1L << (LT - 161)) | (1L << (LE - 161)) | (1L << (GT - 161)) | (1L << (GE - 161)))) != 0)) ) {
							((ComparativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(196);
						((BitwiseContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 167)) & ~0x3f) == 0 && ((1L << (_la - 167)) & ((1L << (AND_ - 167)) | (1L << (XOR - 167)) | (1L << (OR - 167)))) != 0)) ) {
							((BitwiseContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(202);
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
		enterRule(_localctx, 24, RULE_primaryExpression);
		try {
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(LPAREN);
				setState(204);
				expression(0);
				setState(205);
				match(RPAREN);
				}
				break;
			case MUL:
			case PC:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				literal();
				}
				break;
			case PseudoVar:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				varRef();
				}
				break;
			case PseudoFunc:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
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
				setState(210);
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
		enterRule(_localctx, 26, RULE_labelRef);
		int _la;
		try {
			int _alt;
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case COLONCOLON:
			case Identifier:
			case Addressing:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Addressing) {
					{
					setState(213);
					match(Addressing);
					}
				}

				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLONCOLON) {
					{
					setState(216);
					match(COLONCOLON);
					}
				}

				setState(219);
				identifier();
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(220);
						match(COLONCOLON);
						setState(221);
						identifier();
						}
						} 
					}
					setState(226);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				}
				break;
			case UnnamedLabel:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
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
		enterRule(_localctx, 28, RULE_varRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
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
		enterRule(_localctx, 30, RULE_functionRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			((FunctionRefContext)_localctx).func = match(PseudoFunc);
			setState(233);
			match(LPAREN);
			setState(234);
			((FunctionRefContext)_localctx).expression = expression(0);
			((FunctionRefContext)_localctx).args.add(((FunctionRefContext)_localctx).expression);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(235);
				match(COMMA);
				setState(236);
				((FunctionRefContext)_localctx).expression = expression(0);
				((FunctionRefContext)_localctx).args.add(((FunctionRefContext)_localctx).expression);
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
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
		enterRule(_localctx, 32, RULE_identifier);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(IDENT);
				setState(245);
				match(LPAREN);
				setState(246);
				expression(0);
				setState(247);
				match(RPAREN);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
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
		enterRule(_localctx, 34, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (MUL - 153)) | (1L << (PC - 153)) | (1L << (NUMBER - 153)))) != 0) || _la==STRING) ) {
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
		enterRule(_localctx, 36, RULE_statement);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROC:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				proc();
				}
				break;
			case SCOPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				scope();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				enumerator();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				struct();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				union();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				ifStmt();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				repeat();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				define();
				}
				break;
			case MACRO:
				enterOuterAlt(_localctx, 9);
				{
				setState(262);
				macro();
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
		public TerminalNode ENDPROC() { return getToken(CA65Parser.ENDPROC, 0); }
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
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
		enterRule(_localctx, 38, RULE_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(PROC);
			setState(266);
			identifier();
			setState(271); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(267);
				match(EOL);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(268);
					line();
					}
				}

				}
				}
				setState(273); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(275);
			match(ENDPROC);
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
		public TerminalNode ENDSCOPE() { return getToken(CA65Parser.ENDSCOPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
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
		enterRule(_localctx, 40, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(SCOPE);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(278);
				identifier();
				}
			}

			setState(285); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(281);
				match(EOL);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(282);
					line();
					}
				}

				}
				}
				setState(287); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(289);
			match(ENDSCOPE);
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
		public TerminalNode ENDENUM() { return getToken(CA65Parser.ENDENUM, 0); }
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
		enterRule(_localctx, 42, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(ENUM);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(292);
				identifier();
				}
			}

			setState(299); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(295);
				match(EOL);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==Identifier) {
					{
					setState(296);
					((EnumeratorContext)_localctx).enumMember = enumMember();
					((EnumeratorContext)_localctx).member.add(((EnumeratorContext)_localctx).enumMember);
					}
				}

				}
				}
				setState(301); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(303);
			match(ENDENUM);
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
		enterRule(_localctx, 44, RULE_enumMember);
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
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
		public TerminalNode ENDSTRUCT() { return getToken(CA65Parser.ENDSTRUCT, 0); }
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
		enterRule(_localctx, 46, RULE_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(STRUCT);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(310);
				identifier();
				}
			}

			setState(317); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(313);
				match(EOL);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRUCT) | (1L << UNION) | (1L << IDENT))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (BYTE - 81)) | (1L << (RES - 81)) | (1L << (DBYT - 81)) | (1L << (WORD - 81)) | (1L << (ADDR - 81)) | (1L << (FARADDR - 81)) | (1L << (DWORD - 81)) | (1L << (TAG - 81)))) != 0) || _la==Identifier) {
					{
					setState(314);
					((StructContext)_localctx).structMember = structMember();
					((StructContext)_localctx).member.add(((StructContext)_localctx).structMember);
					}
				}

				}
				}
				setState(319); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(321);
			match(ENDSTRUCT);
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
		public TerminalNode ENDUNION() { return getToken(CA65Parser.ENDUNION, 0); }
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
		enterRule(_localctx, 48, RULE_union);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(UNION);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(324);
				identifier();
				}
			}

			setState(331); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(327);
				match(EOL);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRUCT) | (1L << UNION) | (1L << IDENT))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (BYTE - 81)) | (1L << (RES - 81)) | (1L << (DBYT - 81)) | (1L << (WORD - 81)) | (1L << (ADDR - 81)) | (1L << (FARADDR - 81)) | (1L << (DWORD - 81)) | (1L << (TAG - 81)))) != 0) || _la==Identifier) {
					{
					setState(328);
					((UnionContext)_localctx).structMember = structMember();
					((UnionContext)_localctx).member.add(((UnionContext)_localctx).structMember);
					}
				}

				}
				}
				setState(333); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(335);
			match(ENDUNION);
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
		enterRule(_localctx, 50, RULE_structMember);
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				struct();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
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
				setState(339);
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
		enterRule(_localctx, 52, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(342);
				identifier();
				}
			}

			setState(345);
			((FieldContext)_localctx).allocator = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (BYTE - 81)) | (1L << (RES - 81)) | (1L << (DBYT - 81)) | (1L << (WORD - 81)) | (1L << (ADDR - 81)) | (1L << (FARADDR - 81)) | (1L << (DWORD - 81)) | (1L << (TAG - 81)))) != 0)) ) {
				((FieldContext)_localctx).allocator = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << PseudoVar) | (1L << PseudoFunc) | (1L << IDENT))) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (PLUS - 145)) | (1L << (MINUS - 145)) | (1L << (BITNOT - 145)) | (1L << (LOBYTE - 145)) | (1L << (HIBYTE - 145)) | (1L << (LOWORD - 145)) | (1L << (HIWORD - 145)) | (1L << (BANKBYTE - 145)) | (1L << (MUL - 145)) | (1L << (LT - 145)) | (1L << (GT - 145)) | (1L << (NOT - 145)) | (1L << (LPAREN - 145)) | (1L << (COLONCOLON - 145)) | (1L << (PC - 145)) | (1L << (NUMBER - 145)) | (1L << (Identifier - 145)) | (1L << (Addressing - 145)) | (1L << (UnnamedLabel - 145)))) != 0) || _la==STRING) {
				{
				setState(346);
				expression(0);
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
		public Token type;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseifContext elseif() {
			return getRuleContext(ElseifContext.class,0);
		}
		public TerminalNode IF() { return getToken(CA65Parser.IF, 0); }
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			((IfStmtContext)_localctx).type = match(IF);
			setState(350);
			expression(0);
			setState(355); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(351);
				match(EOL);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(352);
					line();
					}
				}

				}
				}
				setState(357); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(359);
			elseif();
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

	public static class ElseifContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(CA65Parser.ELSEIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseifContext elseif() {
			return getRuleContext(ElseifContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitElseif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitElseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_elseif);
		int _la;
		try {
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSEIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(ELSEIF);
				setState(362);
				expression(0);
				setState(367); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(363);
					match(EOL);
					setState(365);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
						{
						setState(364);
						line();
						}
					}

					}
					}
					setState(369); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EOL );
				setState(371);
				elseif();
				}
				break;
			case ENDIF:
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				elseStmt();
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

	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(CA65Parser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(CA65Parser.ENDIF, 0); }
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_elseStmt);
		int _la;
		try {
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				match(ELSE);
				setState(381); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(377);
					match(EOL);
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
						{
						setState(378);
						line();
						}
					}

					}
					}
					setState(383); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EOL );
				setState(385);
				match(ENDIF);
				}
				break;
			case ENDIF:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				match(ENDIF);
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
		public TerminalNode ENDREPEAT() { return getToken(CA65Parser.ENDREPEAT, 0); }
		public TerminalNode COMMA() { return getToken(CA65Parser.COMMA, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
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
		enterRule(_localctx, 60, RULE_repeat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(REPEAT);
			setState(390);
			expression(0);
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(391);
				match(COMMA);
				setState(392);
				identifier();
				}
			}

			setState(399); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(395);
				match(EOL);
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << DEFINE) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(396);
					line();
					}
				}

				}
				}
				setState(401); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(403);
			match(ENDREPEAT);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> param = new ArrayList<IdentifierContext>();
		public TerminalNode DEFINE() { return getToken(CA65Parser.DEFINE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 62, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(DEFINE);
			setState(406);
			identifier();
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(407);
				match(LPAREN);
				setState(408);
				((DefineContext)_localctx).identifier = identifier();
				((DefineContext)_localctx).param.add(((DefineContext)_localctx).identifier);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(409);
					match(COMMA);
					setState(410);
					((DefineContext)_localctx).identifier = identifier();
					((DefineContext)_localctx).param.add(((DefineContext)_localctx).identifier);
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(416);
				match(RPAREN);
				}
				break;
			}
			setState(420);
			expression(0);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> param = new ArrayList<IdentifierContext>();
		public TerminalNode MACRO() { return getToken(CA65Parser.MACRO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ENDMACRO() { return getToken(CA65Parser.ENDMACRO, 0); }
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CA65Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CA65Parser.COMMA, i);
		}
		public List<MaclineContext> macline() {
			return getRuleContexts(MaclineContext.class);
		}
		public MaclineContext macline(int i) {
			return getRuleContext(MaclineContext.class,i);
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
		enterRule(_localctx, 64, RULE_macro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(MACRO);
			setState(423);
			identifier();
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(424);
				((MacroContext)_localctx).identifier = identifier();
				((MacroContext)_localctx).param.add(((MacroContext)_localctx).identifier);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(425);
					match(COMMA);
					setState(426);
					((MacroContext)_localctx).identifier = identifier();
					((MacroContext)_localctx).param.add(((MacroContext)_localctx).identifier);
					}
					}
					setState(431);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(438); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(434);
				match(EOL);
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << Allocator) | (1L << Control) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << UNION) | (1L << IF) | (1L << REPEAT) | (1L << MACRO) | (1L << EXITMACRO) | (1L << DEFINE) | (1L << LOCAL) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(435);
					macline();
					}
				}

				}
				}
				setState(440); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(442);
			match(ENDMACRO);
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

	public static class MaclineContext extends ParserRuleContext {
		public TerminalNode LOCAL() { return getToken(CA65Parser.LOCAL, 0); }
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
		public TerminalNode EXITMACRO() { return getToken(CA65Parser.EXITMACRO, 0); }
		public TerminalNode MACRO() { return getToken(CA65Parser.MACRO, 0); }
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
		public StorageContext storage() {
			return getRuleContext(StorageContext.class,0);
		}
		public ControlContext control() {
			return getRuleContext(ControlContext.class,0);
		}
		public MaclineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterMacline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitMacline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitMacline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaclineContext macline() throws RecognitionException {
		MaclineContext _localctx = new MaclineContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_macline);
		int _la;
		try {
			setState(470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				match(LOCAL);
				setState(445);
				identifier();
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(446);
					match(COMMA);
					setState(447);
					identifier();
					}
					}
					setState(452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				match(EXITMACRO);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(454);
				match(MACRO);
				setState(455);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(456);
				instruction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(457);
				labelEqu();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(458);
				labelDef();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(459);
				varDef();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(460);
				proc();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(461);
				scope();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(462);
				enumerator();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(463);
				struct();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(464);
				union();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(465);
				ifStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(466);
				repeat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(467);
				define();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(468);
				storage();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(469);
				control();
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

	public static class StorageContext extends ParserRuleContext {
		public Token allocator;
		public TerminalNode Allocator() { return getToken(CA65Parser.Allocator, 0); }
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
		enterRule(_localctx, 68, RULE_storage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			((StorageContext)_localctx).allocator = match(Allocator);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << PseudoVar) | (1L << PseudoFunc) | (1L << IDENT))) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (PLUS - 145)) | (1L << (MINUS - 145)) | (1L << (BITNOT - 145)) | (1L << (LOBYTE - 145)) | (1L << (HIBYTE - 145)) | (1L << (LOWORD - 145)) | (1L << (HIWORD - 145)) | (1L << (BANKBYTE - 145)) | (1L << (MUL - 145)) | (1L << (LT - 145)) | (1L << (GT - 145)) | (1L << (NOT - 145)) | (1L << (LPAREN - 145)) | (1L << (COLONCOLON - 145)) | (1L << (PC - 145)) | (1L << (NUMBER - 145)) | (1L << (Identifier - 145)) | (1L << (Addressing - 145)) | (1L << (UnnamedLabel - 145)))) != 0) || _la==STRING) {
				{
				setState(473);
				expression(0);
				setState(478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(474);
					match(COMMA);
					setState(475);
					expression(0);
					}
					}
					setState(480);
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
		enterRule(_localctx, 70, RULE_control);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			((ControlContext)_localctx).command = match(Control);
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				{
				setState(484);
				expression(0);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(485);
					match(COMMA);
					setState(486);
					expression(0);
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				setState(492);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0173\u01f2\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\3\2\3\2"+
		"\5\2T\n\2\7\2V\n\2\f\2\16\2Y\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3d\n\3\3\4\3\4\3\4\3\4\5\4j\n\4\3\5\5\5m\n\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5t\n\5\3\5\3\5\3\5\5\5y\n\5\3\5\5\5|\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"\u0084\n\5\5\5\u0086\n\5\3\6\5\6\u0089\n\6\3\6\3\6\3\6\3\6\5\6\u008f\n"+
		"\6\3\7\5\7\u0092\n\7\3\7\3\7\3\7\3\7\3\b\5\b\u0099\n\b\3\b\3\b\5\b\u009d"+
		"\n\b\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u00a5\n\n\3\13\3\13\3\13\3\13\3\f\5\f"+
		"\u00ac\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bb"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c9\n\r\f\r"+
		"\16\r\u00cc\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d6\n"+
		"\16\3\17\5\17\u00d9\n\17\3\17\5\17\u00dc\n\17\3\17\3\17\3\17\7\17\u00e1"+
		"\n\17\f\17\16\17\u00e4\13\17\3\17\5\17\u00e7\n\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00f0\n\21\f\21\16\21\u00f3\13\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00fd\n\22\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u010a\n\24\3\25\3\25\3\25\3\25\5\25\u0110"+
		"\n\25\6\25\u0112\n\25\r\25\16\25\u0113\3\25\3\25\3\26\3\26\5\26\u011a"+
		"\n\26\3\26\3\26\5\26\u011e\n\26\6\26\u0120\n\26\r\26\16\26\u0121\3\26"+
		"\3\26\3\27\3\27\5\27\u0128\n\27\3\27\3\27\5\27\u012c\n\27\6\27\u012e\n"+
		"\27\r\27\16\27\u012f\3\27\3\27\3\30\3\30\5\30\u0136\n\30\3\31\3\31\5\31"+
		"\u013a\n\31\3\31\3\31\5\31\u013e\n\31\6\31\u0140\n\31\r\31\16\31\u0141"+
		"\3\31\3\31\3\32\3\32\5\32\u0148\n\32\3\32\3\32\5\32\u014c\n\32\6\32\u014e"+
		"\n\32\r\32\16\32\u014f\3\32\3\32\3\33\3\33\3\33\5\33\u0157\n\33\3\34\5"+
		"\34\u015a\n\34\3\34\3\34\5\34\u015e\n\34\3\35\3\35\3\35\3\35\5\35\u0164"+
		"\n\35\6\35\u0166\n\35\r\35\16\35\u0167\3\35\3\35\3\36\3\36\3\36\3\36\5"+
		"\36\u0170\n\36\6\36\u0172\n\36\r\36\16\36\u0173\3\36\3\36\3\36\5\36\u0179"+
		"\n\36\3\37\3\37\3\37\5\37\u017e\n\37\6\37\u0180\n\37\r\37\16\37\u0181"+
		"\3\37\3\37\5\37\u0186\n\37\3 \3 \3 \3 \5 \u018c\n \3 \3 \5 \u0190\n \6"+
		" \u0192\n \r \16 \u0193\3 \3 \3!\3!\3!\3!\3!\3!\7!\u019e\n!\f!\16!\u01a1"+
		"\13!\3!\3!\5!\u01a5\n!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u01ae\n\"\f\"\16"+
		"\"\u01b1\13\"\5\"\u01b3\n\"\3\"\3\"\5\"\u01b7\n\"\6\"\u01b9\n\"\r\"\16"+
		"\"\u01ba\3\"\3\"\3#\3#\3#\3#\7#\u01c3\n#\f#\16#\u01c6\13#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01d9\n#\3$\3$\3$\3$\7$\u01df"+
		"\n$\f$\16$\u01e2\13$\5$\u01e4\n$\3%\3%\3%\3%\7%\u01ea\n%\f%\16%\u01ed"+
		"\13%\3%\5%\u01f0\n%\3%\2\3\30&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFH\2\13\6\2\3\3\u0093\u0095\u00a5\u00a5\u00a7"+
		"\u00a7\3\2\u0096\u009a\3\2\u009b\u00a1\4\2\u0093\u0094\u00a2\u00a2\3\2"+
		"\u00a3\u00a8\3\2\u00a9\u00ab\6\2\u009b\u009b\u00b7\u00b7\u00bb\u00bb\u0170"+
		"\u0170\4\2SY^^\3\2\u0093\u0094\2\u0239\2M\3\2\2\2\4c\3\2\2\2\6i\3\2\2"+
		"\2\b\u0085\3\2\2\2\n\u0088\3\2\2\2\f\u0091\3\2\2\2\16\u0098\3\2\2\2\20"+
		"\u009e\3\2\2\2\22\u00a4\3\2\2\2\24\u00a6\3\2\2\2\26\u00ab\3\2\2\2\30\u00ba"+
		"\3\2\2\2\32\u00d5\3\2\2\2\34\u00e6\3\2\2\2\36\u00e8\3\2\2\2 \u00ea\3\2"+
		"\2\2\"\u00fc\3\2\2\2$\u00fe\3\2\2\2&\u0109\3\2\2\2(\u010b\3\2\2\2*\u0117"+
		"\3\2\2\2,\u0125\3\2\2\2.\u0135\3\2\2\2\60\u0137\3\2\2\2\62\u0145\3\2\2"+
		"\2\64\u0156\3\2\2\2\66\u0159\3\2\2\28\u015f\3\2\2\2:\u0178\3\2\2\2<\u0185"+
		"\3\2\2\2>\u0187\3\2\2\2@\u0197\3\2\2\2B\u01a8\3\2\2\2D\u01d8\3\2\2\2F"+
		"\u01da\3\2\2\2H\u01e5\3\2\2\2JL\7\u0172\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2"+
		"\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PW\5\4\3\2QS\7\u0172\2\2RT\5\4\3\2S"+
		"R\3\2\2\2ST\3\2\2\2TV\3\2\2\2UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"XZ\3\2\2\2YW\3\2\2\2Z[\7\2\2\3[\3\3\2\2\2\\d\5\6\4\2]d\5\20\t\2^d\5\22"+
		"\n\2_d\5\24\13\2`d\5&\24\2ad\5F$\2bd\5H%\2c\\\3\2\2\2c]\3\2\2\2c^\3\2"+
		"\2\2c_\3\2\2\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\5\3\2\2\2ej\5\b\5\2fj\5"+
		"\n\6\2gj\5\f\7\2hj\5\16\b\2ie\3\2\2\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\7"+
		"\3\2\2\2km\5\26\f\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\4\2\2op\7\u00ad"+
		"\2\2ps\5\30\r\2qr\7\u00b3\2\2rt\7\u00b9\2\2sq\3\2\2\2st\3\2\2\2tu\3\2"+
		"\2\2ux\7\u00ae\2\2vw\7\u00b3\2\2wy\7\u00b9\2\2xv\3\2\2\2xy\3\2\2\2y\u0086"+
		"\3\2\2\2z|\5\26\f\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\4\2\2~\177\7\u00b1"+
		"\2\2\177\u0080\5\30\r\2\u0080\u0083\7\u00b2\2\2\u0081\u0082\7\u00b3\2"+
		"\2\u0082\u0084\7\u00b9\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085l\3\2\2\2\u0085{\3\2\2\2\u0086\t\3\2\2\2\u0087\u0089"+
		"\5\26\f\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2"+
		"\u008a\u008b\7\4\2\2\u008b\u008e\5\30\r\2\u008c\u008d\7\u00b3\2\2\u008d"+
		"\u008f\7\u00b9\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\13\3"+
		"\2\2\2\u0090\u0092\5\26\f\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0094\7\4\2\2\u0094\u0095\7\u00b8\2\2\u0095\u0096"+
		"\5\30\r\2\u0096\r\3\2\2\2\u0097\u0099\5\26\f\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\7\4\2\2\u009b\u009d\7\u00ba"+
		"\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\17\3\2\2\2\u009e\u009f"+
		"\5\"\22\2\u009f\u00a0\7\u00a3\2\2\u00a0\u00a1\5\30\r\2\u00a1\21\3\2\2"+
		"\2\u00a2\u00a5\5\26\f\2\u00a3\u00a5\5\"\22\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\23\3\2\2\2\u00a6\u00a7\5\"\22\2\u00a7\u00a8\7\31"+
		"\2\2\u00a8\u00a9\5\30\r\2\u00a9\25\3\2\2\2\u00aa\u00ac\5\"\22\2\u00ab"+
		"\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\u00b5"+
		"\2\2\u00ae\27\3\2\2\2\u00af\u00b0\b\r\1\2\u00b0\u00bb\5\32\16\2\u00b1"+
		"\u00b2\t\2\2\2\u00b2\u00bb\5\30\r\t\u00b3\u00b4\t\3\2\2\u00b4\u00b5\7"+
		"\u00ad\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7\u00ae\2\2\u00b7\u00bb\3"+
		"\2\2\2\u00b8\u00b9\7\u00ac\2\2\u00b9\u00bb\5\30\r\3\u00ba\u00af\3\2\2"+
		"\2\u00ba\u00b1\3\2\2\2\u00ba\u00b3\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00ca"+
		"\3\2\2\2\u00bc\u00bd\f\7\2\2\u00bd\u00be\t\4\2\2\u00be\u00c9\5\30\r\b"+
		"\u00bf\u00c0\f\6\2\2\u00c0\u00c1\t\5\2\2\u00c1\u00c9\5\30\r\7\u00c2\u00c3"+
		"\f\5\2\2\u00c3\u00c4\t\6\2\2\u00c4\u00c9\5\30\r\6\u00c5\u00c6\f\4\2\2"+
		"\u00c6\u00c7\t\7\2\2\u00c7\u00c9\5\30\r\5\u00c8\u00bc\3\2\2\2\u00c8\u00bf"+
		"\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\31\3\2\2\2\u00cc\u00ca\3\2\2"+
		"\2\u00cd\u00ce\7\u00ad\2\2\u00ce\u00cf\5\30\r\2\u00cf\u00d0\7\u00ae\2"+
		"\2\u00d0\u00d6\3\2\2\2\u00d1\u00d6\5$\23\2\u00d2\u00d6\5\36\20\2\u00d3"+
		"\u00d6\5 \21\2\u00d4\u00d6\5\34\17\2\u00d5\u00cd\3\2\2\2\u00d5\u00d1\3"+
		"\2\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\33\3\2\2\2\u00d7\u00d9\7\u00c0\2\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3"+
		"\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00dc\7\u00b6\2\2\u00db\u00da\3\2\2\2"+
		"\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e2\5\"\22\2\u00de\u00df"+
		"\7\u00b6\2\2\u00df\u00e1\5\"\22\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e7\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00e7\7\u00c3\2\2\u00e6\u00d8\3\2\2\2\u00e6\u00e5"+
		"\3\2\2\2\u00e7\35\3\2\2\2\u00e8\u00e9\7\5\2\2\u00e9\37\3\2\2\2\u00ea\u00eb"+
		"\7\6\2\2\u00eb\u00ec\7\u00ad\2\2\u00ec\u00f1\5\30\r\2\u00ed\u00ee\7\u00b3"+
		"\2\2\u00ee\u00f0\5\30\r\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u00f5\7\u00ae\2\2\u00f5!\3\2\2\2\u00f6\u00f7\7@\2\2\u00f7\u00f8"+
		"\7\u00ad\2\2\u00f8\u00f9\5\30\r\2\u00f9\u00fa\7\u00ae\2\2\u00fa\u00fd"+
		"\3\2\2\2\u00fb\u00fd\7\u00bf\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00fb\3\2\2"+
		"\2\u00fd#\3\2\2\2\u00fe\u00ff\t\b\2\2\u00ff%\3\2\2\2\u0100\u010a\5(\25"+
		"\2\u0101\u010a\5*\26\2\u0102\u010a\5,\27\2\u0103\u010a\5\60\31\2\u0104"+
		"\u010a\5\62\32\2\u0105\u010a\58\35\2\u0106\u010a\5> \2\u0107\u010a\5@"+
		"!\2\u0108\u010a\5B\"\2\u0109\u0100\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0102"+
		"\3\2\2\2\u0109\u0103\3\2\2\2\u0109\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109"+
		"\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\'\3\2\2\2"+
		"\u010b\u010c\7\13\2\2\u010c\u0111\5\"\22\2\u010d\u010f\7\u0172\2\2\u010e"+
		"\u0110\5\4\3\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2"+
		"\2\2\u0111\u010d\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7\f\2\2\u0116)\3\2\2\2"+
		"\u0117\u0119\7\t\2\2\u0118\u011a\5\"\22\2\u0119\u0118\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u011f\3\2\2\2\u011b\u011d\7\u0172\2\2\u011c\u011e\5\4\3"+
		"\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011b"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\7\n\2\2\u0124+\3\2\2\2\u0125\u0127\7\r\2\2"+
		"\u0126\u0128\5\"\22\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012d"+
		"\3\2\2\2\u0129\u012b\7\u0172\2\2\u012a\u012c\5.\30\2\u012b\u012a\3\2\2"+
		"\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u0129\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\7\16\2\2\u0132-\3\2\2\2\u0133\u0136\5\"\22\2\u0134\u0136\5\20\t"+
		"\2\u0135\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136/\3\2\2\2\u0137\u0139"+
		"\7\17\2\2\u0138\u013a\5\"\22\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2"+
		"\u013a\u013f\3\2\2\2\u013b\u013d\7\u0172\2\2\u013c\u013e\5\64\33\2\u013d"+
		"\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013b\3\2"+
		"\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\7\20\2\2\u0144\61\3\2\2\2\u0145\u0147\7\21"+
		"\2\2\u0146\u0148\5\"\22\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u014d\3\2\2\2\u0149\u014b\7\u0172\2\2\u014a\u014c\5\64\33\2\u014b\u014a"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u0149\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0152\7\22\2\2\u0152\63\3\2\2\2\u0153\u0157\5\60\31\2\u0154"+
		"\u0157\5\62\32\2\u0155\u0157\5\66\34\2\u0156\u0153\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0156\u0155\3\2\2\2\u0157\65\3\2\2\2\u0158\u015a\5\"\22\2\u0159"+
		"\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\t\t"+
		"\2\2\u015c\u015e\5\30\r\2\u015d\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\67\3\2\2\2\u015f\u0160\7\23\2\2\u0160\u0165\5\30\r\2\u0161\u0163\7\u0172"+
		"\2\2\u0162\u0164\5\4\3\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0166\3\2\2\2\u0165\u0161\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0165\3\2"+
		"\2\2\u0167\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\5:\36\2\u016a"+
		"9\3\2\2\2\u016b\u016c\7\26\2\2\u016c\u0171\5\30\r\2\u016d\u016f\7\u0172"+
		"\2\2\u016e\u0170\5\4\3\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0172\3\2\2\2\u0171\u016d\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\5:\36\2\u0176"+
		"\u0179\3\2\2\2\u0177\u0179\5<\37\2\u0178\u016b\3\2\2\2\u0178\u0177\3\2"+
		"\2\2\u0179;\3\2\2\2\u017a\u017f\7\25\2\2\u017b\u017d\7\u0172\2\2\u017c"+
		"\u017e\5\4\3\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2"+
		"\2\2\u017f\u017b\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0186\7\24\2\2\u0184\u0186\7"+
		"\24\2\2\u0185\u017a\3\2\2\2\u0185\u0184\3\2\2\2\u0186=\3\2\2\2\u0187\u0188"+
		"\7\27\2\2\u0188\u018b\5\30\r\2\u0189\u018a\7\u00b3\2\2\u018a\u018c\5\""+
		"\22\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0191\3\2\2\2\u018d"+
		"\u018f\7\u0172\2\2\u018e\u0190\5\4\3\2\u018f\u018e\3\2\2\2\u018f\u0190"+
		"\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u018d\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\7\30"+
		"\2\2\u0196?\3\2\2\2\u0197\u0198\7\36\2\2\u0198\u01a4\5\"\22\2\u0199\u019a"+
		"\7\u00ad\2\2\u019a\u019f\5\"\22\2\u019b\u019c\7\u00b3\2\2\u019c\u019e"+
		"\5\"\22\2\u019d\u019b\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2"+
		"\u019f\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3"+
		"\7\u00ae\2\2\u01a3\u01a5\3\2\2\2\u01a4\u0199\3\2\2\2\u01a4\u01a5\3\2\2"+
		"\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\5\30\r\2\u01a7A\3\2\2\2\u01a8\u01a9"+
		"\7\32\2\2\u01a9\u01b2\5\"\22\2\u01aa\u01af\5\"\22\2\u01ab\u01ac\7\u00b3"+
		"\2\2\u01ac\u01ae\5\"\22\2\u01ad\u01ab\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af"+
		"\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2"+
		"\2\2\u01b2\u01aa\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b8\3\2\2\2\u01b4"+
		"\u01b6\7\u0172\2\2\u01b5\u01b7\5D#\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3"+
		"\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b4\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\7\33"+
		"\2\2\u01bdC\3\2\2\2\u01be\u01bf\7 \2\2\u01bf\u01c4\5\"\22\2\u01c0\u01c1"+
		"\7\u00b3\2\2\u01c1\u01c3\5\"\22\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2"+
		"\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01d9\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c7\u01d9\7\35\2\2\u01c8\u01c9\7\32\2\2\u01c9\u01d9\5"+
		"\"\22\2\u01ca\u01d9\5\6\4\2\u01cb\u01d9\5\20\t\2\u01cc\u01d9\5\22\n\2"+
		"\u01cd\u01d9\5\24\13\2\u01ce\u01d9\5(\25\2\u01cf\u01d9\5*\26\2\u01d0\u01d9"+
		"\5,\27\2\u01d1\u01d9\5\60\31\2\u01d2\u01d9\5\62\32\2\u01d3\u01d9\58\35"+
		"\2\u01d4\u01d9\5> \2\u01d5\u01d9\5@!\2\u01d6\u01d9\5F$\2\u01d7\u01d9\5"+
		"H%\2\u01d8\u01be\3\2\2\2\u01d8\u01c7\3\2\2\2\u01d8\u01c8\3\2\2\2\u01d8"+
		"\u01ca\3\2\2\2\u01d8\u01cb\3\2\2\2\u01d8\u01cc\3\2\2\2\u01d8\u01cd\3\2"+
		"\2\2\u01d8\u01ce\3\2\2\2\u01d8\u01cf\3\2\2\2\u01d8\u01d0\3\2\2\2\u01d8"+
		"\u01d1\3\2\2\2\u01d8\u01d2\3\2\2\2\u01d8\u01d3\3\2\2\2\u01d8\u01d4\3\2"+
		"\2\2\u01d8\u01d5\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9"+
		"E\3\2\2\2\u01da\u01e3\7\7\2\2\u01db\u01e0\5\30\r\2\u01dc\u01dd\7\u00b3"+
		"\2\2\u01dd\u01df\5\30\r\2\u01de\u01dc\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0"+
		"\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2"+
		"\2\2\u01e3\u01db\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4G\3\2\2\2\u01e5\u01ef"+
		"\7\b\2\2\u01e6\u01eb\5\30\r\2\u01e7\u01e8\7\u00b3\2\2\u01e8\u01ea\5\30"+
		"\r\2\u01e9\u01e7\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01f0\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f0\t\n"+
		"\2\2\u01ef\u01e6\3\2\2\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"I\3\2\2\2HMSWcilsx{\u0083\u0085\u0088\u008e\u0091\u0098\u009c\u00a4\u00ab"+
		"\u00ba\u00c8\u00ca\u00d5\u00d8\u00db\u00e2\u00e6\u00f1\u00fc\u0109\u010f"+
		"\u0113\u0119\u011d\u0121\u0127\u012b\u012f\u0135\u0139\u013d\u0141\u0147"+
		"\u014b\u014f\u0156\u0159\u015d\u0163\u0167\u016f\u0173\u0178\u017d\u0181"+
		"\u0185\u018b\u018f\u0193\u019f\u01a4\u01af\u01b2\u01b6\u01ba\u01c4\u01d8"+
		"\u01e0\u01e3\u01eb\u01ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}