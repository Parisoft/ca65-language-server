// Generated from com/parisoft/ca65/lsp/parser/grammar/g4/CA65.g4 by ANTLR 4.9.2
package com.parisoft.ca65.lsp.parser.grammar.g4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CA65Parser}.
 */
public interface CA65Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CA65Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CA65Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CA65Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(CA65Parser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(CA65Parser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CA65Parser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CA65Parser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#indirectInstruction}.
	 * @param ctx the parse tree
	 */
	void enterIndirectInstruction(CA65Parser.IndirectInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#indirectInstruction}.
	 * @param ctx the parse tree
	 */
	void exitIndirectInstruction(CA65Parser.IndirectInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#absoluteInstruction}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#absoluteInstruction}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 */
	void enterImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 */
	void exitImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#implicitInstruction}.
	 * @param ctx the parse tree
	 */
	void enterImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#implicitInstruction}.
	 * @param ctx the parse tree
	 */
	void exitImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#labelEqu}.
	 * @param ctx the parse tree
	 */
	void enterLabelEqu(CA65Parser.LabelEquContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#labelEqu}.
	 * @param ctx the parse tree
	 */
	void exitLabelEqu(CA65Parser.LabelEquContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#labelDef}.
	 * @param ctx the parse tree
	 */
	void enterLabelDef(CA65Parser.LabelDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#labelDef}.
	 * @param ctx the parse tree
	 */
	void exitLabelDef(CA65Parser.LabelDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(CA65Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(CA65Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#inlineLabel}.
	 * @param ctx the parse tree
	 */
	void enterInlineLabel(CA65Parser.InlineLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#inlineLabel}.
	 * @param ctx the parse tree
	 */
	void exitInlineLabel(CA65Parser.InlineLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CA65Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CA65Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplicative}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(CA65Parser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplicative}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(CA65Parser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Additive}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(CA65Parser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Additive}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(CA65Parser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bitwise}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitwise(CA65Parser.BitwiseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bitwise}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitwise(CA65Parser.BitwiseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegation(CA65Parser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegation(CA65Parser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(CA65Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(CA65Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Extraction}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExtraction(CA65Parser.ExtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Extraction}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExtraction(CA65Parser.ExtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(CA65Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(CA65Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparative}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparative(CA65Parser.ComparativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparative}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparative(CA65Parser.ComparativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(CA65Parser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(CA65Parser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#labelRef}.
	 * @param ctx the parse tree
	 */
	void enterLabelRef(CA65Parser.LabelRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#labelRef}.
	 * @param ctx the parse tree
	 */
	void exitLabelRef(CA65Parser.LabelRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#varRef}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(CA65Parser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#varRef}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(CA65Parser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#functionRef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionRef(CA65Parser.FunctionRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#functionRef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionRef(CA65Parser.FunctionRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CA65Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CA65Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CA65Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CA65Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CA65Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CA65Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#proc}.
	 * @param ctx the parse tree
	 */
	void enterProc(CA65Parser.ProcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#proc}.
	 * @param ctx the parse tree
	 */
	void exitProc(CA65Parser.ProcContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(CA65Parser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(CA65Parser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#enumerator}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator(CA65Parser.EnumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#enumerator}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator(CA65Parser.EnumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#enumMember}.
	 * @param ctx the parse tree
	 */
	void enterEnumMember(CA65Parser.EnumMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#enumMember}.
	 * @param ctx the parse tree
	 */
	void exitEnumMember(CA65Parser.EnumMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#struct}.
	 * @param ctx the parse tree
	 */
	void enterStruct(CA65Parser.StructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#struct}.
	 * @param ctx the parse tree
	 */
	void exitStruct(CA65Parser.StructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(CA65Parser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(CA65Parser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#structMember}.
	 * @param ctx the parse tree
	 */
	void enterStructMember(CA65Parser.StructMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#structMember}.
	 * @param ctx the parse tree
	 */
	void exitStructMember(CA65Parser.StructMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CA65Parser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CA65Parser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(CA65Parser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(CA65Parser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(CA65Parser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(CA65Parser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(CA65Parser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(CA65Parser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#repeat}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(CA65Parser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#repeat}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(CA65Parser.RepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(CA65Parser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(CA65Parser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(CA65Parser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(CA65Parser.MacroContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#macline}.
	 * @param ctx the parse tree
	 */
	void enterMacline(CA65Parser.MaclineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#macline}.
	 * @param ctx the parse tree
	 */
	void exitMacline(CA65Parser.MaclineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#storage}.
	 * @param ctx the parse tree
	 */
	void enterStorage(CA65Parser.StorageContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#storage}.
	 * @param ctx the parse tree
	 */
	void exitStorage(CA65Parser.StorageContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#control}.
	 * @param ctx the parse tree
	 */
	void enterControl(CA65Parser.ControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#control}.
	 * @param ctx the parse tree
	 */
	void exitControl(CA65Parser.ControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#expansion}.
	 * @param ctx the parse tree
	 */
	void enterExpansion(CA65Parser.ExpansionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#expansion}.
	 * @param ctx the parse tree
	 */
	void exitExpansion(CA65Parser.ExpansionContext ctx);
}