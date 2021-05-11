// Generated from com/parisoft/ca65/lsp/parser/grammar/g4/CA65.g4 by ANTLR 4.9.2
package com.parisoft.ca65.lsp.parser.grammar.g4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CA65Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CA65Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CA65Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CA65Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(CA65Parser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(CA65Parser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#indirectInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndirectInstruction(CA65Parser.IndirectInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#absoluteInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#implicitInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#labelEqu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelEqu(CA65Parser.LabelEquContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#labelDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDef(CA65Parser.LabelDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(CA65Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#inlineLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineLabel(CA65Parser.InlineLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CA65Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplicative}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(CA65Parser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Additive}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(CA65Parser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bitwise}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise(CA65Parser.BitwiseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(CA65Parser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(CA65Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Extraction}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraction(CA65Parser.ExtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(CA65Parser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparative}
	 * labeled alternative in {@link CA65Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparative(CA65Parser.ComparativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(CA65Parser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#labelRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelRef(CA65Parser.LabelRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#varRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(CA65Parser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#functionRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionRef(CA65Parser.FunctionRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CA65Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CA65Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CA65Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#proc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc(CA65Parser.ProcContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(CA65Parser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#enumerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator(CA65Parser.EnumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#enumMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumMember(CA65Parser.EnumMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct(CA65Parser.StructContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(CA65Parser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#structMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructMember(CA65Parser.StructMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(CA65Parser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link CA65Parser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(CA65Parser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIf}
	 * labeled alternative in {@link CA65Parser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(CA65Parser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Else}
	 * labeled alternative in {@link CA65Parser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(CA65Parser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#repeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(CA65Parser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(CA65Parser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#macro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro(CA65Parser.MacroContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#endStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndStmt(CA65Parser.EndStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#storage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorage(CA65Parser.StorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl(CA65Parser.ControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#expansion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpansion(CA65Parser.ExpansionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#expansionPush}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpansionPush(CA65Parser.ExpansionPushContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#expansionPop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpansionPop(CA65Parser.ExpansionPopContext ctx);
}