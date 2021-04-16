// Generated from com/parisoft/ca65/lsp/grammar/CA65.g4 by ANTLR 4.9.2
package com.parisoft.ca65.lsp.grammar;
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
		T__0=1, Opcode=2, SCOPE=3, ENDSCOPE=4, PROC=5, ENDPROC=6, ENUM=7, ENDENUM=8, 
		STRUCT=9, ENDSTRUCT=10, UNION=11, ENDUNION=12, IF=13, ENDIF=14, ELSE=15, 
		ELSEIF=16, REPEAT=17, ENDREPEAT=18, SET=19, INCLUDE=20, INCBIN=21, SEGMENT=22, 
		ASIZE=23, CPU=24, ISIZE=25, PARAMCOUNT=26, TIME=27, VERSION=28, ADDRSIZE=29, 
		BANK=30, BLANK=31, CONCAT=32, CONST=33, IDENT=34, LEFT=35, MATCH=36, MAX=37, 
		MID=38, MIN=39, REF=40, REFERENCED=41, RIGHT=42, SIZEOF=43, STRAT=44, 
		SPRINTF=45, STRING_=46, STRLEN=47, TCOUNT=48, XMATCH=49, BYTE=50, RES=51, 
		DBYT=52, WORD=53, ADDR=54, FARADDR=55, DWORD=56, ASCIIZ=57, LOBYTES=58, 
		HIBYTES=59, BANKBYTES=60, TAG=61, A16=62, A8=63, ALIGN=64, ASSERT=65, 
		AUTOIMPORT=66, BSS=67, CASE=68, CHARMAP=69, CODE=70, CONDES=71, CONSTRUCTOR=72, 
		DATA=73, DEBUGINFO=74, DEF=75, DESTRUCTOR=76, END=77, ERROR=78, EXPORT=79, 
		EXPORTZP=80, FATAL=81, FEATURE=82, FILEOPT=83, FOPT=84, FORCEIMPORT=85, 
		GLOBAL=86, GLOBALZP=87, I16=88, I8=89, IMPORT=90, IMPORTZP=91, INTERRUPTOR=92, 
		ISMNEM=93, ISMNEMONIC=94, LINECONT=95, LIST=96, LISTBYTES=97, LOCALCHAR=98, 
		MACPACK=99, ORG=100, OUT=101, PAGELEN=102, PAGELENGTH=103, POPCPU=104, 
		POPSEG=105, PUSHCPU=106, PUSHSEG=107, RELOC=108, RODATA=109, SETCPU=110, 
		SMART=111, WARNING=112, ZEROPAGE=113, PLUS=114, MINUS=115, BITNOT=116, 
		LOBYTE=117, HIBYTE=118, LOWORD=119, HIWORD=120, BANKBYTE=121, MUL=122, 
		DIV=123, MOD=124, BITAND=125, BITXOR=126, SHL=127, SHR=128, BITOR=129, 
		EQ=130, NE=131, LT=132, LE=133, GT=134, GE=135, BAND=136, XOR=137, OR=138, 
		NOT=139, LPAREN=140, RPAREN=141, LBRACE=142, RBRACE=143, LBRACK=144, RBRACK=145, 
		COMMA=146, DOT=147, COLON=148, COLONCOLON=149, PC=150, IMMEDIATE=151, 
		INDEX=152, ACC=153, NUMBER=154, DIGIT=155, HEX=156, BIN=157, Identifier=158, 
		Addressing=159, Diretive=160, CheapLabel=161, UnnamedLabel=162, Label=163, 
		ADC=164, AND=165, ASL=166, BCC=167, BCS=168, BEQ=169, BIT=170, BMI=171, 
		BNE=172, BPL=173, BRK=174, BVC=175, BVS=176, CLC=177, CLD=178, CLI=179, 
		CLV=180, CMP=181, CPX=182, CPY=183, DEC=184, DEX=185, DEY=186, EOR=187, 
		INC=188, INX=189, INY=190, JMP=191, JSR=192, LDA=193, LDX=194, LDY=195, 
		LSR=196, NOP=197, ORA=198, PHA=199, PHP=200, PLA=201, PLP=202, ROL=203, 
		ROR=204, RTI=205, RTS=206, SBC=207, SEC=208, SED=209, SEI=210, STA=211, 
		STX=212, STY=213, TAX=214, TAY=215, TSX=216, TXA=217, TXS=218, TYA=219, 
		BRA=220, PHX=221, PHY=222, PLX=223, PLY=224, STZ=225, TRB=226, TSB=227, 
		BBR0=228, BBR1=229, BBR2=230, BBR3=231, BBR4=232, BBR5=233, BBR6=234, 
		BBR7=235, BBS0=236, BBS1=237, BBS2=238, BBS3=239, BBS4=240, BBS5=241, 
		BBS6=242, BBS7=243, RMB0=244, RMB1=245, RMB2=246, RMB3=247, RMB4=248, 
		RMB5=249, RMB6=250, RMB7=251, SMB0=252, SMB1=253, SMB2=254, SMB3=255, 
		SMB4=256, SMB5=257, SMB6=258, SMB7=259, ALR=260, ANC=261, ARR=262, AXS=263, 
		DCP=264, ISC=265, LAS=266, LAX=267, RLA=268, RRA=269, SAX=270, SLO=271, 
		SRE=272, BRL=273, COP=274, JML=275, JSL=276, MVN=277, MVP=278, PEA=279, 
		PEI=280, PER=281, PHB=282, PHD=283, PHK=284, PLB=285, PLD=286, REP=287, 
		RTL=288, SEP=289, STP=290, TCD=291, TCS=292, TDC=293, TSC=294, TXY=295, 
		TYX=296, WAI=297, WDM=298, XBA=299, XCE=300, CPA=301, DEA=302, INA=303, 
		SWA=304, TAD=305, TAS=306, TDA=307, TSA=308, LBCC=309, LBCS=310, LBEQ=311, 
		LBMI=312, LBNE=313, LBPL=314, LBVC=315, LBVS=316, ADD=317, SUB=318, BGE=319, 
		BLT=320, BGT=321, BLE=322, BNZ=323, BZE=324, JEQ=325, JNE=326, JMI=327, 
		JPL=328, JCS=329, JCC=330, JVS=331, JVC=332, COMMENT=333, C_COMMENT=334, 
		STRING=335, CHAR=336, EOL=337, WS=338;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_instruction = 2, RULE_indirectInstruction = 3, 
		RULE_absoluteInstruction = 4, RULE_immediateInstruction = 5, RULE_implicitInstruction = 6, 
		RULE_labelEqu = 7, RULE_labelDef = 8, RULE_varDef = 9, RULE_inlineLabel = 10, 
		RULE_expression = 11, RULE_primaryExpression = 12, RULE_labelRef = 13, 
		RULE_varRef = 14, RULE_functionRef = 15, RULE_identifier = 16, RULE_literal = 17, 
		RULE_proc = 18, RULE_scope = 19, RULE_enumerator = 20, RULE_struct = 21, 
		RULE_union = 22, RULE_field = 23, RULE_ifDirective = 24, RULE_elseifDirective = 25, 
		RULE_elseDirective = 26, RULE_repeatDirective = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "instruction", "indirectInstruction", "absoluteInstruction", 
			"immediateInstruction", "implicitInstruction", "labelEqu", "labelDef", 
			"varDef", "inlineLabel", "expression", "primaryExpression", "labelRef", 
			"varRef", "functionRef", "identifier", "literal", "proc", "scope", "enumerator", 
			"struct", "union", "field", "ifDirective", "elseifDirective", "elseDirective", 
			"repeatDirective"
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
			null, null, null, null, null, null, "'+'", "'-'", null, null, null, null, 
			null, null, "'*'", "'/'", null, null, null, null, null, null, "'='", 
			"'<>'", "'<'", "'<='", "'>'", "'>='", null, null, null, null, "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "'::'", null, 
			"'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Opcode", "SCOPE", "ENDSCOPE", "PROC", "ENDPROC", "ENUM", 
			"ENDENUM", "STRUCT", "ENDSTRUCT", "UNION", "ENDUNION", "IF", "ENDIF", 
			"ELSE", "ELSEIF", "REPEAT", "ENDREPEAT", "SET", "INCLUDE", "INCBIN", 
			"SEGMENT", "ASIZE", "CPU", "ISIZE", "PARAMCOUNT", "TIME", "VERSION", 
			"ADDRSIZE", "BANK", "BLANK", "CONCAT", "CONST", "IDENT", "LEFT", "MATCH", 
			"MAX", "MID", "MIN", "REF", "REFERENCED", "RIGHT", "SIZEOF", "STRAT", 
			"SPRINTF", "STRING_", "STRLEN", "TCOUNT", "XMATCH", "BYTE", "RES", "DBYT", 
			"WORD", "ADDR", "FARADDR", "DWORD", "ASCIIZ", "LOBYTES", "HIBYTES", "BANKBYTES", 
			"TAG", "A16", "A8", "ALIGN", "ASSERT", "AUTOIMPORT", "BSS", "CASE", "CHARMAP", 
			"CODE", "CONDES", "CONSTRUCTOR", "DATA", "DEBUGINFO", "DEF", "DESTRUCTOR", 
			"END", "ERROR", "EXPORT", "EXPORTZP", "FATAL", "FEATURE", "FILEOPT", 
			"FOPT", "FORCEIMPORT", "GLOBAL", "GLOBALZP", "I16", "I8", "IMPORT", "IMPORTZP", 
			"INTERRUPTOR", "ISMNEM", "ISMNEMONIC", "LINECONT", "LIST", "LISTBYTES", 
			"LOCALCHAR", "MACPACK", "ORG", "OUT", "PAGELEN", "PAGELENGTH", "POPCPU", 
			"POPSEG", "PUSHCPU", "PUSHSEG", "RELOC", "RODATA", "SETCPU", "SMART", 
			"WARNING", "ZEROPAGE", "PLUS", "MINUS", "BITNOT", "LOBYTE", "HIBYTE", 
			"LOWORD", "HIWORD", "BANKBYTE", "MUL", "DIV", "MOD", "BITAND", "BITXOR", 
			"SHL", "SHR", "BITOR", "EQ", "NE", "LT", "LE", "GT", "GE", "BAND", "XOR", 
			"OR", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
			"COMMA", "DOT", "COLON", "COLONCOLON", "PC", "IMMEDIATE", "INDEX", "ACC", 
			"NUMBER", "DIGIT", "HEX", "BIN", "Identifier", "Addressing", "Diretive", 
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(56);
				match(EOL);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			line();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(63);
				match(EOL);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(64);
					line();
					}
				}

				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
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
		public IfDirectiveContext ifDirective() {
			return getRuleContext(IfDirectiveContext.class,0);
		}
		public RepeatDirectiveContext repeatDirective() {
			return getRuleContext(RepeatDirectiveContext.class,0);
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
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				labelEqu();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				labelDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				varDef();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				proc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				scope();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				enumerator();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				struct();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				ifDirective();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(83);
				repeatDirective();
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
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				indirectInstruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				absoluteInstruction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				immediateInstruction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==COLON || _la==Identifier) {
					{
					setState(92);
					inlineLabel();
					}
				}

				setState(95);
				match(Opcode);
				setState(96);
				match(LPAREN);
				setState(97);
				expression(0);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(98);
					match(COMMA);
					setState(99);
					match(INDEX);
					}
				}

				setState(102);
				match(RPAREN);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(103);
					match(COMMA);
					setState(104);
					match(INDEX);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT || _la==COLON || _la==Identifier) {
					{
					setState(107);
					inlineLabel();
					}
				}

				setState(110);
				match(Opcode);
				setState(111);
				match(LBRACK);
				setState(112);
				expression(0);
				setState(113);
				match(RBRACK);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(114);
					match(COMMA);
					setState(115);
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
			expression(0);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(125);
				match(COMMA);
				setState(126);
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
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(129);
				inlineLabel();
				}
			}

			setState(132);
			match(Opcode);
			setState(133);
			match(IMMEDIATE);
			setState(134);
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
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==COLON || _la==Identifier) {
				{
				setState(136);
				inlineLabel();
				}
			}

			setState(139);
			match(Opcode);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACC) {
				{
				setState(140);
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
			setState(143);
			identifier();
			setState(144);
			match(EQ);
			setState(145);
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
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				inlineLabel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
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
			setState(151);
			identifier();
			setState(152);
			match(SET);
			setState(153);
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
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(155);
				identifier();
				}
			}

			setState(158);
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
		public TerminalNode BAND() { return getToken(CA65Parser.BAND, 0); }
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
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASIZE:
			case CPU:
			case ISIZE:
			case PARAMCOUNT:
			case TIME:
			case VERSION:
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

				setState(161);
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
				setState(162);
				((UnaryContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__0 || ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (PLUS - 114)) | (1L << (MINUS - 114)) | (1L << (BITNOT - 114)) | (1L << (LT - 114)) | (1L << (GT - 114)))) != 0)) ) {
					((UnaryContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(163);
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
				setState(164);
				((ExtractionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (LOBYTE - 117)) | (1L << (HIBYTE - 117)) | (1L << (LOWORD - 117)) | (1L << (HIWORD - 117)) | (1L << (BANKBYTE - 117)))) != 0)) ) {
					((ExtractionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(165);
				match(LPAREN);
				setState(166);
				expression(0);
				setState(167);
				match(RPAREN);
				}
				break;
			case NOT:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				((NegationContext)_localctx).prefix = match(NOT);
				setState(170);
				expression(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(185);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(174);
						((MultiplicativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & ((1L << (MUL - 122)) | (1L << (DIV - 122)) | (1L << (MOD - 122)) | (1L << (BITAND - 122)) | (1L << (BITXOR - 122)) | (1L << (SHL - 122)) | (1L << (SHR - 122)))) != 0)) ) {
							((MultiplicativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(177);
						((AdditiveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (PLUS - 114)) | (1L << (MINUS - 114)) | (1L << (BITOR - 114)))) != 0)) ) {
							((AdditiveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ComparativeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(180);
						((ComparativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (EQ - 130)) | (1L << (NE - 130)) | (1L << (LT - 130)) | (1L << (LE - 130)) | (1L << (GT - 130)) | (1L << (GE - 130)))) != 0)) ) {
							((ComparativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(183);
						((BitwiseContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (BAND - 136)) | (1L << (XOR - 136)) | (1L << (OR - 136)))) != 0)) ) {
							((BitwiseContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(184);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(189);
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
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(LPAREN);
				setState(191);
				expression(0);
				setState(192);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				varRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				functionRef();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				labelRef();
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
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case COLONCOLON:
			case Identifier:
			case Addressing:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Addressing) {
					{
					setState(200);
					match(Addressing);
					}
				}

				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLONCOLON) {
					{
					setState(203);
					match(COLONCOLON);
					}
				}

				setState(206);
				identifier();
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(207);
						match(COLONCOLON);
						setState(208);
						identifier();
						}
						} 
					}
					setState(213);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				}
				break;
			case UnnamedLabel:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
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
		public TerminalNode ASIZE() { return getToken(CA65Parser.ASIZE, 0); }
		public TerminalNode CPU() { return getToken(CA65Parser.CPU, 0); }
		public TerminalNode ISIZE() { return getToken(CA65Parser.ISIZE, 0); }
		public TerminalNode PARAMCOUNT() { return getToken(CA65Parser.PARAMCOUNT, 0); }
		public TerminalNode TIME() { return getToken(CA65Parser.TIME, 0); }
		public TerminalNode VERSION() { return getToken(CA65Parser.VERSION, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASIZE) | (1L << CPU) | (1L << ISIZE) | (1L << PARAMCOUNT) | (1L << TIME) | (1L << VERSION))) != 0)) ) {
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

	public static class FunctionRefContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> args = new ArrayList<ExpressionContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CA65Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CA65Parser.RPAREN, 0); }
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
			setState(219);
			identifier();
			setState(220);
			match(LPAREN);
			setState(221);
			((FunctionRefContext)_localctx).expression = expression(0);
			((FunctionRefContext)_localctx).args.add(((FunctionRefContext)_localctx).expression);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(222);
				match(COMMA);
				setState(223);
				((FunctionRefContext)_localctx).expression = expression(0);
				((FunctionRefContext)_localctx).args.add(((FunctionRefContext)_localctx).expression);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
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
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(IDENT);
				setState(232);
				match(LPAREN);
				setState(233);
				expression(0);
				setState(234);
				match(RPAREN);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
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
			setState(239);
			_la = _input.LA(1);
			if ( !(((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & ((1L << (MUL - 122)) | (1L << (PC - 122)) | (1L << (NUMBER - 122)))) != 0) || _la==STRING) ) {
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
		enterRule(_localctx, 36, RULE_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(PROC);
			setState(242);
			identifier();
			setState(247); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				match(EOL);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(244);
					line();
					}
				}

				}
				}
				setState(249); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(251);
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
		enterRule(_localctx, 38, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(SCOPE);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(254);
				identifier();
				}
			}

			setState(261); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(257);
				match(EOL);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(258);
					line();
					}
				}

				}
				}
				setState(263); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(265);
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
		public TerminalNode ENUM() { return getToken(CA65Parser.ENUM, 0); }
		public TerminalNode ENDENUM() { return getToken(CA65Parser.ENDENUM, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<LabelEquContext> labelEqu() {
			return getRuleContexts(LabelEquContext.class);
		}
		public LabelEquContext labelEqu(int i) {
			return getRuleContext(LabelEquContext.class,i);
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
		enterRule(_localctx, 40, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ENUM);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(268);
				identifier();
				}
			}

			setState(276); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(271);
				match(EOL);
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(272);
					identifier();
					}
					break;
				case 2:
					{
					setState(273);
					labelEqu();
					}
					break;
				}
				}
				}
				setState(278); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(280);
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

	public static class StructContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(CA65Parser.STRUCT, 0); }
		public TerminalNode ENDSTRUCT() { return getToken(CA65Parser.ENDSTRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<StructContext> struct() {
			return getRuleContexts(StructContext.class);
		}
		public StructContext struct(int i) {
			return getRuleContext(StructContext.class,i);
		}
		public List<UnionContext> union() {
			return getRuleContexts(UnionContext.class);
		}
		public UnionContext union(int i) {
			return getRuleContext(UnionContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
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
		enterRule(_localctx, 42, RULE_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(STRUCT);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(283);
				identifier();
				}
			}

			setState(292); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(286);
				match(EOL);
				setState(290);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRUCT:
					{
					setState(287);
					struct();
					}
					break;
				case UNION:
					{
					setState(288);
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
					{
					setState(289);
					field();
					}
					break;
				case ENDSTRUCT:
				case EOL:
					break;
				default:
					break;
				}
				}
				}
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(296);
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
		public TerminalNode UNION() { return getToken(CA65Parser.UNION, 0); }
		public TerminalNode ENDUNION() { return getToken(CA65Parser.ENDUNION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(CA65Parser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(CA65Parser.EOL, i);
		}
		public List<StructContext> struct() {
			return getRuleContexts(StructContext.class);
		}
		public StructContext struct(int i) {
			return getRuleContext(StructContext.class,i);
		}
		public List<UnionContext> union() {
			return getRuleContexts(UnionContext.class);
		}
		public UnionContext union(int i) {
			return getRuleContext(UnionContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
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
		enterRule(_localctx, 44, RULE_union);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(UNION);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(299);
				identifier();
				}
			}

			setState(308); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(302);
				match(EOL);
				setState(306);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRUCT:
					{
					setState(303);
					struct();
					}
					break;
				case UNION:
					{
					setState(304);
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
					{
					setState(305);
					field();
					}
					break;
				case ENDUNION:
				case EOL:
					break;
				default:
					break;
				}
				}
				}
				setState(310); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(312);
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
		enterRule(_localctx, 46, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT || _la==Identifier) {
				{
				setState(314);
				identifier();
				}
			}

			setState(317);
			((FieldContext)_localctx).allocator = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYTE) | (1L << RES) | (1L << DBYT) | (1L << WORD) | (1L << ADDR) | (1L << FARADDR) | (1L << DWORD) | (1L << TAG))) != 0)) ) {
				((FieldContext)_localctx).allocator = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ASIZE) | (1L << CPU) | (1L << ISIZE) | (1L << PARAMCOUNT) | (1L << TIME) | (1L << VERSION) | (1L << IDENT))) != 0) || ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (PLUS - 114)) | (1L << (MINUS - 114)) | (1L << (BITNOT - 114)) | (1L << (LOBYTE - 114)) | (1L << (HIBYTE - 114)) | (1L << (LOWORD - 114)) | (1L << (HIWORD - 114)) | (1L << (BANKBYTE - 114)) | (1L << (MUL - 114)) | (1L << (LT - 114)) | (1L << (GT - 114)) | (1L << (NOT - 114)) | (1L << (LPAREN - 114)) | (1L << (COLONCOLON - 114)) | (1L << (PC - 114)) | (1L << (NUMBER - 114)) | (1L << (Identifier - 114)) | (1L << (Addressing - 114)) | (1L << (UnnamedLabel - 114)))) != 0) || _la==STRING) {
				{
				setState(318);
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

	public static class IfDirectiveContext extends ParserRuleContext {
		public Token type;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseifDirectiveContext elseifDirective() {
			return getRuleContext(ElseifDirectiveContext.class,0);
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
		public IfDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterIfDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitIfDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitIfDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDirectiveContext ifDirective() throws RecognitionException {
		IfDirectiveContext _localctx = new IfDirectiveContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ifDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			((IfDirectiveContext)_localctx).type = match(IF);
			setState(322);
			expression(0);
			setState(327); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(323);
				match(EOL);
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(324);
					line();
					}
				}

				}
				}
				setState(329); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(331);
			elseifDirective();
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

	public static class ElseifDirectiveContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(CA65Parser.ELSEIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseifDirectiveContext elseifDirective() {
			return getRuleContext(ElseifDirectiveContext.class,0);
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
		public ElseDirectiveContext elseDirective() {
			return getRuleContext(ElseDirectiveContext.class,0);
		}
		public ElseifDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterElseifDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitElseifDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitElseifDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifDirectiveContext elseifDirective() throws RecognitionException {
		ElseifDirectiveContext _localctx = new ElseifDirectiveContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_elseifDirective);
		int _la;
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSEIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(ELSEIF);
				setState(334);
				expression(0);
				setState(339); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(335);
					match(EOL);
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
						{
						setState(336);
						line();
						}
					}

					}
					}
					setState(341); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EOL );
				setState(343);
				elseifDirective();
				}
				break;
			case ENDIF:
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				elseDirective();
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

	public static class ElseDirectiveContext extends ParserRuleContext {
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
		public ElseDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterElseDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitElseDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitElseDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseDirectiveContext elseDirective() throws RecognitionException {
		ElseDirectiveContext _localctx = new ElseDirectiveContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_elseDirective);
		int _la;
		try {
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(ELSE);
				setState(353); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(349);
					match(EOL);
					setState(351);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
						{
						setState(350);
						line();
						}
					}

					}
					}
					setState(355); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EOL );
				setState(357);
				match(ENDIF);
				}
				break;
			case ENDIF:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
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

	public static class RepeatDirectiveContext extends ParserRuleContext {
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
		public RepeatDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).enterRepeatDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CA65Listener ) ((CA65Listener)listener).exitRepeatDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CA65Visitor ) return ((CA65Visitor<? extends T>)visitor).visitRepeatDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatDirectiveContext repeatDirective() throws RecognitionException {
		RepeatDirectiveContext _localctx = new RepeatDirectiveContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_repeatDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(REPEAT);
			setState(362);
			expression(0);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(363);
				match(COMMA);
				setState(364);
				identifier();
				}
			}

			setState(371); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(367);
				match(EOL);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Opcode) | (1L << SCOPE) | (1L << PROC) | (1L << ENUM) | (1L << STRUCT) | (1L << IF) | (1L << REPEAT) | (1L << IDENT))) != 0) || _la==COLON || _la==Identifier) {
					{
					setState(368);
					line();
					}
				}

				}
				}
				setState(373); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
			setState(375);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0154\u017c\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\3\2\3\2\5\2D\n\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\5\4]\n\4\3\5\5\5`\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5g\n\5\3\5\3\5\3\5\5\5l\n\5\3\5\5\5o\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5w\n\5\5\5y\n\5\3\6\5\6|\n\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0082\n\6\3\7\5\7\u0085\n\7\3\7\3\7\3\7\3\7\3\b\5\b\u008c\n\b\3\b\3\b"+
		"\5\b\u0090\n\b\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u0098\n\n\3\13\3\13\3\13\3"+
		"\13\3\f\5\f\u009f\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00ae\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00bc\n\r\f\r\16\r\u00bf\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00c9\n\16\3\17\5\17\u00cc\n\17\3\17\5\17\u00cf\n\17\3\17\3\17\3"+
		"\17\7\17\u00d4\n\17\f\17\16\17\u00d7\13\17\3\17\5\17\u00da\n\17\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\7\21\u00e3\n\21\f\21\16\21\u00e6\13\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f0\n\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\5\24\u00f8\n\24\6\24\u00fa\n\24\r\24\16\24\u00fb\3\24"+
		"\3\24\3\25\3\25\5\25\u0102\n\25\3\25\3\25\5\25\u0106\n\25\6\25\u0108\n"+
		"\25\r\25\16\25\u0109\3\25\3\25\3\26\3\26\5\26\u0110\n\26\3\26\3\26\3\26"+
		"\5\26\u0115\n\26\6\26\u0117\n\26\r\26\16\26\u0118\3\26\3\26\3\27\3\27"+
		"\5\27\u011f\n\27\3\27\3\27\3\27\3\27\5\27\u0125\n\27\6\27\u0127\n\27\r"+
		"\27\16\27\u0128\3\27\3\27\3\30\3\30\5\30\u012f\n\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0135\n\30\6\30\u0137\n\30\r\30\16\30\u0138\3\30\3\30\3\31\5\31"+
		"\u013e\n\31\3\31\3\31\5\31\u0142\n\31\3\32\3\32\3\32\3\32\5\32\u0148\n"+
		"\32\6\32\u014a\n\32\r\32\16\32\u014b\3\32\3\32\3\33\3\33\3\33\3\33\5\33"+
		"\u0154\n\33\6\33\u0156\n\33\r\33\16\33\u0157\3\33\3\33\3\33\5\33\u015d"+
		"\n\33\3\34\3\34\3\34\5\34\u0162\n\34\6\34\u0164\n\34\r\34\16\34\u0165"+
		"\3\34\3\34\5\34\u016a\n\34\3\35\3\35\3\35\3\35\5\35\u0170\n\35\3\35\3"+
		"\35\5\35\u0174\n\35\6\35\u0176\n\35\r\35\16\35\u0177\3\35\3\35\3\35\2"+
		"\3\30\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		"\2\13\6\2\3\3tv\u0086\u0086\u0088\u0088\3\2w{\3\2|\u0082\4\2tu\u0083\u0083"+
		"\3\2\u0084\u0089\3\2\u008a\u008c\3\2\31\36\6\2||\u0098\u0098\u009c\u009c"+
		"\u0151\u0151\4\2\64:??\2\u01ac\2=\3\2\2\2\4V\3\2\2\2\6\\\3\2\2\2\bx\3"+
		"\2\2\2\n{\3\2\2\2\f\u0084\3\2\2\2\16\u008b\3\2\2\2\20\u0091\3\2\2\2\22"+
		"\u0097\3\2\2\2\24\u0099\3\2\2\2\26\u009e\3\2\2\2\30\u00ad\3\2\2\2\32\u00c8"+
		"\3\2\2\2\34\u00d9\3\2\2\2\36\u00db\3\2\2\2 \u00dd\3\2\2\2\"\u00ef\3\2"+
		"\2\2$\u00f1\3\2\2\2&\u00f3\3\2\2\2(\u00ff\3\2\2\2*\u010d\3\2\2\2,\u011c"+
		"\3\2\2\2.\u012c\3\2\2\2\60\u013d\3\2\2\2\62\u0143\3\2\2\2\64\u015c\3\2"+
		"\2\2\66\u0169\3\2\2\28\u016b\3\2\2\2:<\7\u0153\2\2;:\3\2\2\2<?\3\2\2\2"+
		"=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@G\5\4\3\2AC\7\u0153\2\2BD\5\4"+
		"\3\2CB\3\2\2\2CD\3\2\2\2DF\3\2\2\2EA\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\2\2\3K\3\3\2\2\2LW\5\6\4\2MW\5\20\t\2NW\5"+
		"\22\n\2OW\5\24\13\2PW\5&\24\2QW\5(\25\2RW\5*\26\2SW\5,\27\2TW\5\62\32"+
		"\2UW\58\35\2VL\3\2\2\2VM\3\2\2\2VN\3\2\2\2VO\3\2\2\2VP\3\2\2\2VQ\3\2\2"+
		"\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\5\3\2\2\2X]\5\b\5\2Y]\5\n"+
		"\6\2Z]\5\f\7\2[]\5\16\b\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2"+
		"]\7\3\2\2\2^`\5\26\f\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\4\2\2bc\7\u008e"+
		"\2\2cf\5\30\r\2de\7\u0094\2\2eg\7\u009a\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2"+
		"\2\2hk\7\u008f\2\2ij\7\u0094\2\2jl\7\u009a\2\2ki\3\2\2\2kl\3\2\2\2ly\3"+
		"\2\2\2mo\5\26\f\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\4\2\2qr\7\u0092\2"+
		"\2rs\5\30\r\2sv\7\u0093\2\2tu\7\u0094\2\2uw\7\u009a\2\2vt\3\2\2\2vw\3"+
		"\2\2\2wy\3\2\2\2x_\3\2\2\2xn\3\2\2\2y\t\3\2\2\2z|\5\26\f\2{z\3\2\2\2{"+
		"|\3\2\2\2|}\3\2\2\2}~\7\4\2\2~\u0081\5\30\r\2\177\u0080\7\u0094\2\2\u0080"+
		"\u0082\7\u009a\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\13\3\2"+
		"\2\2\u0083\u0085\5\26\f\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\7\4\2\2\u0087\u0088\7\u0099\2\2\u0088\u0089"+
		"\5\30\r\2\u0089\r\3\2\2\2\u008a\u008c\5\26\f\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\7\4\2\2\u008e\u0090\7\u009b"+
		"\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\17\3\2\2\2\u0091\u0092"+
		"\5\"\22\2\u0092\u0093\7\u0084\2\2\u0093\u0094\5\30\r\2\u0094\21\3\2\2"+
		"\2\u0095\u0098\5\26\f\2\u0096\u0098\5\"\22\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\23\3\2\2\2\u0099\u009a\5\"\22\2\u009a\u009b\7\25"+
		"\2\2\u009b\u009c\5\30\r\2\u009c\25\3\2\2\2\u009d\u009f\5\"\22\2\u009e"+
		"\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\u0096"+
		"\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\b\r\1\2\u00a3\u00ae\5\32\16\2\u00a4"+
		"\u00a5\t\2\2\2\u00a5\u00ae\5\30\r\t\u00a6\u00a7\t\3\2\2\u00a7\u00a8\7"+
		"\u008e\2\2\u00a8\u00a9\5\30\r\2\u00a9\u00aa\7\u008f\2\2\u00aa\u00ae\3"+
		"\2\2\2\u00ab\u00ac\7\u008d\2\2\u00ac\u00ae\5\30\r\3\u00ad\u00a2\3\2\2"+
		"\2\u00ad\u00a4\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00bd"+
		"\3\2\2\2\u00af\u00b0\f\7\2\2\u00b0\u00b1\t\4\2\2\u00b1\u00bc\5\30\r\b"+
		"\u00b2\u00b3\f\6\2\2\u00b3\u00b4\t\5\2\2\u00b4\u00bc\5\30\r\7\u00b5\u00b6"+
		"\f\5\2\2\u00b6\u00b7\t\6\2\2\u00b7\u00bc\5\30\r\6\u00b8\u00b9\f\4\2\2"+
		"\u00b9\u00ba\t\7\2\2\u00ba\u00bc\5\30\r\5\u00bb\u00af\3\2\2\2\u00bb\u00b2"+
		"\3\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00bd\3\2\2"+
		"\2\u00c0\u00c1\7\u008e\2\2\u00c1\u00c2\5\30\r\2\u00c2\u00c3\7\u008f\2"+
		"\2\u00c3\u00c9\3\2\2\2\u00c4\u00c9\5$\23\2\u00c5\u00c9\5\36\20\2\u00c6"+
		"\u00c9\5 \21\2\u00c7\u00c9\5\34\17\2\u00c8\u00c0\3\2\2\2\u00c8\u00c4\3"+
		"\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\33\3\2\2\2\u00ca\u00cc\7\u00a1\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3"+
		"\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cf\7\u0097\2\2\u00ce\u00cd\3\2\2\2"+
		"\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d5\5\"\22\2\u00d1\u00d2"+
		"\7\u0097\2\2\u00d2\u00d4\5\"\22\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\3\2"+
		"\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00da\7\u00a4\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\35\3\2\2\2\u00db\u00dc\t\b\2\2\u00dc\37\3\2\2\2\u00dd\u00de"+
		"\5\"\22\2\u00de\u00df\7\u008e\2\2\u00df\u00e4\5\30\r\2\u00e0\u00e1\7\u0094"+
		"\2\2\u00e1\u00e3\5\30\r\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7\u00e8\7\u008f\2\2\u00e8!\3\2\2\2\u00e9\u00ea\7$\2\2\u00ea\u00eb"+
		"\7\u008e\2\2\u00eb\u00ec\5\30\r\2\u00ec\u00ed\7\u008f\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00f0\7\u00a0\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ee\3\2\2"+
		"\2\u00f0#\3\2\2\2\u00f1\u00f2\t\t\2\2\u00f2%\3\2\2\2\u00f3\u00f4\7\7\2"+
		"\2\u00f4\u00f9\5\"\22\2\u00f5\u00f7\7\u0153\2\2\u00f6\u00f8\5\4\3\2\u00f7"+
		"\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f5\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00fe\7\b\2\2\u00fe\'\3\2\2\2\u00ff\u0101\7\5\2\2"+
		"\u0100\u0102\5\"\22\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0107"+
		"\3\2\2\2\u0103\u0105\7\u0153\2\2\u0104\u0106\5\4\3\2\u0105\u0104\3\2\2"+
		"\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0103\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010c\7\6\2\2\u010c)\3\2\2\2\u010d\u010f\7\t\2\2\u010e\u0110\5\"\22\2"+
		"\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0116\3\2\2\2\u0111\u0114"+
		"\7\u0153\2\2\u0112\u0115\5\"\22\2\u0113\u0115\5\20\t\2\u0114\u0112\3\2"+
		"\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116"+
		"\u0111\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\u011a\3\2\2\2\u011a\u011b\7\n\2\2\u011b+\3\2\2\2\u011c\u011e"+
		"\7\13\2\2\u011d\u011f\5\"\22\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2"+
		"\u011f\u0126\3\2\2\2\u0120\u0124\7\u0153\2\2\u0121\u0125\5,\27\2\u0122"+
		"\u0125\5.\30\2\u0123\u0125\5\60\31\2\u0124\u0121\3\2\2\2\u0124\u0122\3"+
		"\2\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0120\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\f\2\2\u012b-\3\2\2\2\u012c\u012e"+
		"\7\r\2\2\u012d\u012f\5\"\22\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2"+
		"\u012f\u0136\3\2\2\2\u0130\u0134\7\u0153\2\2\u0131\u0135\5,\27\2\u0132"+
		"\u0135\5.\30\2\u0133\u0135\5\60\31\2\u0134\u0131\3\2\2\2\u0134\u0132\3"+
		"\2\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136"+
		"\u0130\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013b\7\16\2\2\u013b/\3\2\2\2\u013c\u013e"+
		"\5\"\22\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2"+
		"\u013f\u0141\t\n\2\2\u0140\u0142\5\30\r\2\u0141\u0140\3\2\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\61\3\2\2\2\u0143\u0144\7\17\2\2\u0144\u0149\5\30\r\2\u0145"+
		"\u0147\7\u0153\2\2\u0146\u0148\5\4\3\2\u0147\u0146\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0145\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\5\64"+
		"\33\2\u014e\63\3\2\2\2\u014f\u0150\7\22\2\2\u0150\u0155\5\30\r\2\u0151"+
		"\u0153\7\u0153\2\2\u0152\u0154\5\4\3\2\u0153\u0152\3\2\2\2\u0153\u0154"+
		"\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0151\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\5\64"+
		"\33\2\u015a\u015d\3\2\2\2\u015b\u015d\5\66\34\2\u015c\u014f\3\2\2\2\u015c"+
		"\u015b\3\2\2\2\u015d\65\3\2\2\2\u015e\u0163\7\21\2\2\u015f\u0161\7\u0153"+
		"\2\2\u0160\u0162\5\4\3\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0164\3\2\2\2\u0163\u015f\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2"+
		"\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016a\7\20\2\2\u0168"+
		"\u016a\7\20\2\2\u0169\u015e\3\2\2\2\u0169\u0168\3\2\2\2\u016a\67\3\2\2"+
		"\2\u016b\u016c\7\23\2\2\u016c\u016f\5\30\r\2\u016d\u016e\7\u0094\2\2\u016e"+
		"\u0170\5\"\22\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0175\3"+
		"\2\2\2\u0171\u0173\7\u0153\2\2\u0172\u0174\5\4\3\2\u0173\u0172\3\2\2\2"+
		"\u0173\u0174\3\2\2\2\u0174\u0176\3\2\2\2\u0175\u0171\3\2\2\2\u0176\u0177"+
		"\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017a\7\24\2\2\u017a9\3\2\2\29=CGV\\_fknvx{\u0081\u0084\u008b\u008f\u0097"+
		"\u009e\u00ad\u00bb\u00bd\u00c8\u00cb\u00ce\u00d5\u00d9\u00e4\u00ef\u00f7"+
		"\u00fb\u0101\u0105\u0109\u010f\u0114\u0118\u011e\u0124\u0128\u012e\u0134"+
		"\u0138\u013d\u0141\u0147\u014b\u0153\u0157\u015c\u0161\u0165\u0169\u016f"+
		"\u0173\u0177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}