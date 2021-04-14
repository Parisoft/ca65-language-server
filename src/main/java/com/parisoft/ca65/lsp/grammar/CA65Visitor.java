// Generated from /home/paris/git/ca65-language-server/src/main/antlr4/com/parisoft/ca65/lsp/grammar/CA65.g4 by ANTLR 4.9.1
package com.parisoft.ca65.lsp.grammar;
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
	 * Visit a parse tree produced by {@link CA65Parser#inlineLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineLabel(CA65Parser.InlineLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(CA65Parser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#implicitInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#absoluteInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#indirectInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndirectInstruction(CA65Parser.IndirectInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(CA65Parser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(CA65Parser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(CA65Parser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpression(CA65Parser.XorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(CA65Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#geExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeExpression(CA65Parser.GeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#leExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeExpression(CA65Parser.LeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#gtExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtExpression(CA65Parser.GtExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#ltExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpression(CA65Parser.LtExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#neExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeExpression(CA65Parser.NeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#eqExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(CA65Parser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#bitorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitorExpression(CA65Parser.BitorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#subExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpression(CA65Parser.SubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#addExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(CA65Parser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#mulExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpression(CA65Parser.MulExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#divExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpression(CA65Parser.DivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#modExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModExpression(CA65Parser.ModExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#bitandExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitandExpression(CA65Parser.BitandExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#bitxorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitxorExpression(CA65Parser.BitxorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#shlExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShlExpression(CA65Parser.ShlExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#shrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShrExpression(CA65Parser.ShrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#bankbyteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBankbyteExpression(CA65Parser.BankbyteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#hibyteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHibyteExpression(CA65Parser.HibyteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#lobyteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobyteExpression(CA65Parser.LobyteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#bitnotExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitnotExpression(CA65Parser.BitnotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#negativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeExpression(CA65Parser.NegativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#positiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveExpression(CA65Parser.PositiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(CA65Parser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#labelRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelRef(CA65Parser.LabelRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CA65Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CA65Parser.IdentifierContext ctx);
}