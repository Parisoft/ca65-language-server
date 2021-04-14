// Generated from com/parisoft/ca65/lsp/grammar/CA65.g4 by ANTLR 4.9.2
package com.parisoft.ca65.lsp.grammar;
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
	 * Enter a parse tree produced by {@link CA65Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(CA65Parser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(CA65Parser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(CA65Parser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(CA65Parser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(CA65Parser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(CA65Parser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#xorExpression}.
	 * @param ctx the parse tree
	 */
	void enterXorExpression(CA65Parser.XorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#xorExpression}.
	 * @param ctx the parse tree
	 */
	void exitXorExpression(CA65Parser.XorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(CA65Parser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(CA65Parser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#geExpression}.
	 * @param ctx the parse tree
	 */
	void enterGeExpression(CA65Parser.GeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#geExpression}.
	 * @param ctx the parse tree
	 */
	void exitGeExpression(CA65Parser.GeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#leExpression}.
	 * @param ctx the parse tree
	 */
	void enterLeExpression(CA65Parser.LeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#leExpression}.
	 * @param ctx the parse tree
	 */
	void exitLeExpression(CA65Parser.LeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#gtExpression}.
	 * @param ctx the parse tree
	 */
	void enterGtExpression(CA65Parser.GtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#gtExpression}.
	 * @param ctx the parse tree
	 */
	void exitGtExpression(CA65Parser.GtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#ltExpression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(CA65Parser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#ltExpression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(CA65Parser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#neExpression}.
	 * @param ctx the parse tree
	 */
	void enterNeExpression(CA65Parser.NeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#neExpression}.
	 * @param ctx the parse tree
	 */
	void exitNeExpression(CA65Parser.NeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#eqExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(CA65Parser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#eqExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(CA65Parser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#bitorExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitorExpression(CA65Parser.BitorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#bitorExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitorExpression(CA65Parser.BitorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#subExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(CA65Parser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#subExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(CA65Parser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#addExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(CA65Parser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#addExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(CA65Parser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(CA65Parser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(CA65Parser.MulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#divExpression}.
	 * @param ctx the parse tree
	 */
	void enterDivExpression(CA65Parser.DivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#divExpression}.
	 * @param ctx the parse tree
	 */
	void exitDivExpression(CA65Parser.DivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#modExpression}.
	 * @param ctx the parse tree
	 */
	void enterModExpression(CA65Parser.ModExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#modExpression}.
	 * @param ctx the parse tree
	 */
	void exitModExpression(CA65Parser.ModExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#bitandExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitandExpression(CA65Parser.BitandExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#bitandExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitandExpression(CA65Parser.BitandExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#bitxorExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitxorExpression(CA65Parser.BitxorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#bitxorExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitxorExpression(CA65Parser.BitxorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#shlExpression}.
	 * @param ctx the parse tree
	 */
	void enterShlExpression(CA65Parser.ShlExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#shlExpression}.
	 * @param ctx the parse tree
	 */
	void exitShlExpression(CA65Parser.ShlExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#shrExpression}.
	 * @param ctx the parse tree
	 */
	void enterShrExpression(CA65Parser.ShrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#shrExpression}.
	 * @param ctx the parse tree
	 */
	void exitShrExpression(CA65Parser.ShrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#bankbyteExpression}.
	 * @param ctx the parse tree
	 */
	void enterBankbyteExpression(CA65Parser.BankbyteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#bankbyteExpression}.
	 * @param ctx the parse tree
	 */
	void exitBankbyteExpression(CA65Parser.BankbyteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#hibyteExpression}.
	 * @param ctx the parse tree
	 */
	void enterHibyteExpression(CA65Parser.HibyteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#hibyteExpression}.
	 * @param ctx the parse tree
	 */
	void exitHibyteExpression(CA65Parser.HibyteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#lobyteExpression}.
	 * @param ctx the parse tree
	 */
	void enterLobyteExpression(CA65Parser.LobyteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#lobyteExpression}.
	 * @param ctx the parse tree
	 */
	void exitLobyteExpression(CA65Parser.LobyteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#bitnotExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitnotExpression(CA65Parser.BitnotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#bitnotExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitnotExpression(CA65Parser.BitnotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#negativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeExpression(CA65Parser.NegativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#negativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeExpression(CA65Parser.NegativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#positiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPositiveExpression(CA65Parser.PositiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#positiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPositiveExpression(CA65Parser.PositiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CA65Parser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(CA65Parser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CA65Parser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(CA65Parser.ReferenceContext ctx);
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
}