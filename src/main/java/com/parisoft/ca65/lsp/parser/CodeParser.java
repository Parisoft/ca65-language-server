package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.parser.grammar.CA65Token;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Lexer;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Parser;
import com.parisoft.ca65.lsp.parser.grammar.g4.CA65Visitor;
import com.parisoft.ca65.lsp.parser.lang.PseudoVar;
import com.parisoft.ca65.lsp.parser.symbol.EnumDcl;
import com.parisoft.ca65.lsp.parser.symbol.EnumDef;
import com.parisoft.ca65.lsp.parser.symbol.FieldDef;
import com.parisoft.ca65.lsp.parser.symbol.LabelDef;
import com.parisoft.ca65.lsp.parser.symbol.ProcDef;
import com.parisoft.ca65.lsp.parser.symbol.ScopeDef;
import com.parisoft.ca65.lsp.parser.symbol.StructDcl;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
import com.parisoft.ca65.lsp.parser.symbol.SymbolRef;
import com.parisoft.ca65.lsp.parser.symbol.UnnamedRef;
import com.parisoft.ca65.lsp.parser.symbol.Constant;
import com.parisoft.ca65.lsp.parser.symbol.VarDef;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.BANKBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.HIWORD;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOBYTE;
import static com.parisoft.ca65.lsp.parser.lang.PseudoFunc.LOWORD;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;
import static java.util.Collections.emptyMap;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("Duplicates")
public class CodeParser extends AbstractParseTreeVisitor<String> implements CA65Visitor<String> {

    private String code;
    private Path ctxPath;
    private Path symPath;
    private int ctxLine = 0;
    private int checkpoint = 0;
    private boolean eval = false;
    private int paramcount = 0;
    private int cpu = PseudoVar.CPU.CPU_6502.value();
    private int asize = 8;
    private int isize = 8;
    private Deque<Integer> cpuStack = new ArrayDeque<>();
    private Deque<Integer> asizeStack = new ArrayDeque<>();
    private Deque<Integer> isizeStack = new ArrayDeque<>();
    private List<String> macros = new ArrayList<>();
    private List<String> defines = new ArrayList<>();
    private Deque<Symbol> layer = new ArrayDeque<>();

    public static void main(String[] args) {
        String code = ""
                + "foo: ;comment"
                + lineSeparator()
                + "oba boba"
                + lineSeparator()
                + "bar:"
                + lineSeparator()
                + "\t.mac lza\n"
                + "\tlda #0\n"
                + "\t.endmac";
        CA65ErrorListener errorListener = new CA65ErrorListener();
        CodePointCharStream input = CharStreams.fromString(code);
//        input.seek(23);//start before "bar:"
        CA65Lexer lexer = new CA65Lexer(input);
        CA65Parser parser = new CA65Parser(new CommonTokenStream(lexer));
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);
        new CA65POCVisitor(parser, lexer).visit(parser.program());
        System.out.println("Errors: " + errorListener.errors);
    }

    public CodeParser(String code, Path path) {
        this.code = code;
        this.ctxPath = path;
        this.symPath = path;

        layer.push(new ScopeDef("", ctxPath, 0)); // Push the global scope
    }

    @Override
    public String visitProgram(CA65Parser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLine(CA65Parser.LineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitInstruction(CA65Parser.InstructionContext ctx) {
        setCheckpoint(ctx);
        return visitChildren(ctx);
    }

    @Override
    public String visitIndirectInstruction(CA65Parser.IndirectInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAbsoluteInstruction(CA65Parser.AbsoluteInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitImmediateInstruction(CA65Parser.ImmediateInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitImplicitInstruction(CA65Parser.ImplicitInstructionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLabelEqu(CA65Parser.LabelEquContext ctx) {
        setCheckpoint(ctx);

        String name = visitIdentifier(ctx.identifier());
        newSymbol(LabelDef.class, name, ctx);

        visit(ctx.expression());

        return name;
    }

    @Override
    public String visitLabelDef(CA65Parser.LabelDefContext ctx) {
        if (ctx.inlineLabel() != null) {
            return visitInlineLabel(ctx.inlineLabel());
        }

        setCheckpoint(ctx);

        String name = visit(ctx.identifier());
        Symbol symbol = newSymbol(LabelDef.class, name, ctx);

        layer.push(symbol);

        return name;
    }

    @Override
    public String visitVarDef(CA65Parser.VarDefContext ctx) {
        setCheckpoint(ctx);

        String name = visitIdentifier(ctx.identifier());
        int value = parseInt(eval(ctx.expression()));
        newConstant(VarDef.class, name, value, ctx);

        return name;
    }

    @Override
    public String visitInlineLabel(CA65Parser.InlineLabelContext ctx) {
        setCheckpoint(ctx);

        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : "";
        LabelDef symbol = newSymbol(LabelDef.class, name, ctx);

        layer.push(symbol);

        return name;
    }

    @Override
    public String visitMultiplicative(CA65Parser.MultiplicativeContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

            if (ctx.MUL() != null) {
                return valueOf(left * right);
            } else if (ctx.DIV() != null) {
                return valueOf(left / right);
            } else if (ctx.MOD() != null) {
                return valueOf(left % right);
            } else if (ctx.BITAND() != null) {
                return valueOf(left & right);
            } else if (ctx.BITXOR() != null) {
                return valueOf(left ^ right);
            } else if (ctx.SHL() != null) {
                return valueOf(left << right);
            } else if (ctx.SHR() != null) {
                return valueOf(left >> right);
            } else {
                throw new IllegalArgumentException("Unknown Multiplicative operator: " + ctx.op.getText());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitAdditive(CA65Parser.AdditiveContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

            if (ctx.PLUS() != null) {
                return valueOf(left + right);
            } else if (ctx.MINUS() != null) {
                return valueOf(left - right);
            } else if (ctx.BITOR() != null) {
                return valueOf(left | right);
            } else {
                throw new IllegalArgumentException("Unknown Additive operator: " + ctx.op.getText());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitBitwise(CA65Parser.BitwiseContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

            if (ctx.AND_() != null) {
                return valueOf(left != 0 && right != 0);
            } else if (ctx.OR() != null) {
                return valueOf(left != 0 || right != 0);
            } else if (ctx.XOR() != null) {
                return valueOf(left ^ right);
            } else {
                throw new IllegalArgumentException("Unknown Bitwise operator: " + ctx.op.getText());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitNegation(CA65Parser.NegationContext ctx) {
        if (eval) {
            return parseInt(visit(ctx.expression())) == 0 ? "0" : "1";
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitPrimary(CA65Parser.PrimaryContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitExtraction(CA65Parser.ExtractionContext ctx) {
        if (eval) {
            int value = parseInt(visit(ctx.expression()));

            if (ctx.LOBYTE() != null) {
                return valueOf(LOBYTE(value));
            } else if (ctx.HIBYTE() != null) {
                return valueOf(HIBYTE(value));
            } else if (ctx.LOWORD() != null) {
                return valueOf(LOWORD(value));
            } else if (ctx.HIWORD() != null) {
                return valueOf(HIWORD(value));
            } else {
                return valueOf(BANKBYTE(value));
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitUnary(CA65Parser.UnaryContext ctx) {
        if (eval) {
            int value = parseInt(visit(ctx.expression()));

            if (ctx.PLUS() != null) {
                return valueOf(value);
            } else if (ctx.MINUS() != null) {
                return valueOf(-value);
            } else if (ctx.BITNOT() != null) {
                return valueOf(~value);
            } else if (ctx.prefix.getText().equals("<")) {
                return valueOf(LOBYTE(value));
            } else if (ctx.prefix.getText().equals(">")) {
                return valueOf(HIBYTE(value));
            } else if (ctx.prefix.getText().equals("^")) {
                return valueOf(BANKBYTE(value));
            } else {
                throw new IllegalArgumentException("Unknown Unary operator: " + ctx.prefix.getText());
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitComparative(CA65Parser.ComparativeContext ctx) {
        if (eval) {
            int left = parseInt(visit(ctx.expression(0)));
            int right = parseInt(visit(ctx.expression(1)));

            if (ctx.EQ() != null) {
                return valueOf(left == right ? 1 : 0);
            } else if (ctx.NE() != null) {
                return valueOf(left != right ? 1 : 0);
            } else if (ctx.LT() != null) {
                return valueOf(left < right ? 1 : 0);
            } else if (ctx.GT() != null) {
                return valueOf(left > right ? 1 : 0);
            } else if (ctx.LE() != null) {
                return valueOf(left <= right ? 1 : 0);
            } else if (ctx.GE() != null) {
                return valueOf(left >= right ? 1 : 0);
            } else throw new IllegalArgumentException("Unknown Comparative operator: " + ctx.op.getText());
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitPrimaryExpression(CA65Parser.PrimaryExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitLabelRef(CA65Parser.LabelRefContext ctx) {
        if (ctx.UnnamedLabel() != null) {
            String name = ctx.UnnamedLabel().getSymbol().getText().substring(1);
            newSymbol(UnnamedRef.class, name, ctx);

            return name;
        }

        String owner = null;

        for (int i = 0; i < ctx.identifier().size(); i++) {
            CA65Parser.IdentifierContext identifier = ctx.identifier(i);
            String name = visitIdentifier(identifier);
            SymbolRef symbol = new SymbolRef(name, symPath, getLine(identifier), owner);
            symbol.setParent(layer.peek());
            symbol.save(ctxPath);

            if (eval && i == ctx.identifier().size() - 1) {
                // Search for a constant definition whose parent is owner
                return Symbol.Table.map
                        .getOrDefault(name, emptyMap())
                        .getOrDefault(ctxPath, emptyMap())
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getKey() <= symbol.getLine())
                        .sorted(reverseOrder(comparingInt(Map.Entry::getKey)))
                        .map(Map.Entry::getValue)
                        .filter(sym -> sym instanceof Constant)
                        .filter(sym -> sym.getParent().getName().equals(symbol.getOwner()))
                        .map(sym -> valueOf(((Constant) sym).getValue()))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Undefined constant: " + name));
            }

            owner = name;
        }

        return owner;
    }

    @Override
    public String visitVarRef(CA65Parser.VarRefContext ctx) {
        if (eval) {
            String var = ctx.var.getText().toUpperCase();

            switch (var) {
                case "ASIZE":
                    return valueOf(asize);
                case "ISIZE":
                    return valueOf(isize);
                case "CPU":
                    return valueOf(cpu);
                case "TIME":
                    return valueOf(System.currentTimeMillis() / 1000);
                case "VERSION": //TODO find out a way to get version
                    return "0";
                case "PARAMCOUNT":
                    return valueOf(paramcount);
                default:
                    return valueOf(PseudoVar.CPU.valueOf(var).value());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitFunctionRef(CA65Parser.FunctionRefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIdentifier(CA65Parser.IdentifierContext ctx) {
        //TODO check if identifier is a macro/define

        if (ctx.IDENT() != null) {
            return visit(ctx.expression());
        }

        return ctx.Identifier().getSymbol().getText();
    }

    @Override
    public String visitLiteral(CA65Parser.LiteralContext ctx) {
        String text = ctx.getText();

        if (ctx.NUMBER() != null) {
            if (text.contains("$") || text.contains("h") || text.contains("H")) {
                return valueOf(parseInt(text, 16));
            } else if (text.contains("%")) {
                return valueOf(parseInt(text, 2));
            } else {
                return valueOf(parseInt(text));
            }
        }

        return text;
    }

    @Override
    public String visitStatement(CA65Parser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("StatementWithEmptyBody")
    public String visitProc(CA65Parser.ProcContext ctx) {
        setCheckpoint(ctx);

        String name = visitIdentifier(ctx.identifier());
        ProcDef symbol = newSymbol(ProcDef.class, name, ctx);

        layer.push(symbol);
        ctx.line().forEach(this::visitLine);
        while (layer.poll() != symbol) ;

        return name;
    }

    @Override
    @SuppressWarnings("StatementWithEmptyBody")
    public String visitScope(CA65Parser.ScopeContext ctx) {
        setCheckpoint(ctx);

        String name = ctx.identifier() != null ? visitIdentifier(ctx.identifier()) : "";
        ScopeDef symbol = newSymbol(ScopeDef.class, name, ctx);

        layer.push(symbol);
        ctx.line().forEach(this::visitLine);
        while (layer.poll() != symbol) ;

        return name;
    }

    @Override
    public String visitEnumerator(CA65Parser.EnumeratorContext ctx) {
        setCheckpoint(ctx);

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            EnumDcl enumDcl = newSymbol(EnumDcl.class, name, ctx);

            layer.push(enumDcl);
        }

        int val = 0;
        String name;

        for (CA65Parser.EnumMemberContext member : ctx.enumMember()) {
            setCheckpoint(member);

            if (member.labelEqu() != null) {
                name = visitIdentifier(member.labelEqu().identifier());
                val = parseInt(visit(member.labelEqu().expression()));
            } else {
                name = visitIdentifier(member.identifier());
            }

            newConstant(EnumDef.class, name, val++, member);
        }

        if (ctx.identifier() != null) {
            layer.poll();
        }

        return null;
    }

    @Override
    public String visitEnumMember(CA65Parser.EnumMemberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitStruct(CA65Parser.StructContext ctx) {
        setCheckpoint(ctx);

        StructDcl structDcl = null;
        int size = 0;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            structDcl = newSymbol(StructDcl.class, name, ctx);

            layer.push(structDcl);
        }

        for (CA65Parser.StructMemberContext member : ctx.structMember()) {
            if (member.struct() != null) {
                size += parseInt(visitStruct(member.struct()));
            } else if (member.union() != null) {
                size += parseInt(visitUnion(member.union()));
            } else {
                CA65Parser.FieldContext field = member.field();
                setCheckpoint(field);

                String name = field.identifier() != null ? visitIdentifier(field.identifier()) : null;
                int bytes = field.expression() != null ? parseInt(visit(field.expression())) : 1;

                if (field.WORD() != null || field.DWORD() != null || field.ADDR() != null) {
                    bytes *= 2;
                } else if (field.FARADDR() != null) {
                    bytes *= 3;
                }

                if (name != null) {
                    newConstant(FieldDef.class, name, size, field).setSize(bytes);
                }

                size += bytes;
            }
        }

        if (structDcl != null) {
            structDcl.setSize(size);
        }

        return valueOf(size);
    }

    @Override
    public String visitUnion(CA65Parser.UnionContext ctx) {
        setCheckpoint(ctx);

        StructDcl unionDcl = null;
        int size = 0;

        if (ctx.identifier() != null) {
            String name = visitIdentifier(ctx.identifier());
            unionDcl = newSymbol( StructDcl.class,name, ctx);

            layer.push(unionDcl);
        }

        for (CA65Parser.StructMemberContext member : ctx.structMember()) {
            if (member.struct() != null) {
                size = Math.max(size, parseInt(visitStruct(member.struct())));
            } else if (member.union() != null) {
                size = Math.max(size, parseInt(visitUnion(member.union())));
            } else {
                CA65Parser.FieldContext field = member.field();
                setCheckpoint(field);

                String name = field.identifier() != null ? visitIdentifier(field.identifier()) : null;
                int bytes = field.expression() != null ? parseInt(visit(field.expression())) : 1;

                if (field.WORD() != null || field.DWORD() != null || field.ADDR() != null) {
                    bytes *= 2;
                } else if (field.FARADDR() != null) {
                    bytes *= 3;
                }

                if (name != null) {
                    newConstant(FieldDef.class, name, size, field).setSize(bytes);
                }

                size = Math.max(size, bytes);
            }
        }

        if (unionDcl != null) {
            unionDcl.setSize(size);
        }

        return valueOf(size);
    }

    @Override
    public String visitStructMember(CA65Parser.StructMemberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitField(CA65Parser.FieldContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitIfStmt(CA65Parser.IfStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitElseif(CA65Parser.ElseifContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitElseStmt(CA65Parser.ElseStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitRepeat(CA65Parser.RepeatContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitDefine(CA65Parser.DefineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMacro(CA65Parser.MacroContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMacline(CA65Parser.MaclineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitStorage(CA65Parser.StorageContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitControl(CA65Parser.ControlContext ctx) {
        return visitChildren(ctx);
    }

    private void setCheckpoint(ParserRuleContext ctx) {
        checkpoint = ((CA65Token) ctx.start).getPrvIndex();
    }

    @SuppressWarnings("unchecked")
    private <T extends Symbol> T newSymbol(Class<T> type, String name, ParserRuleContext ctx) {
        int symLine = getLine(ctx);

        if (ctxPath.equals(symPath)) {
            ctxLine = symLine;
        }

        try {
            return (T) type.getConstructor(String.class, Path.class, int.class)
                    .newInstance(name, symPath, symLine)
                    .setParent(layer.peek())
                    .save(ctxPath, ctxLine);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Symbol> T newConstant(Class<T> type, String name, int value, ParserRuleContext ctx) {
        int symLine = getLine(ctx);

        if (ctxPath.equals(symPath)) {
            ctxLine = symLine;
        }

        try {
            return (T) type.getConstructor(String.class, Path.class, int.class, int.class)
                    .newInstance(name, symPath, symLine, value)
                    .setParent(layer.peek())
                    .save(ctxPath, ctxLine);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    private String eval(ParserRuleContext ctx) {
        eval = true;

        try {
            return visit(ctx);
        } finally {
            eval = false;
        }
    }

    static class CA65ErrorListener extends BaseErrorListener {

        int errors = 0;

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errors++;

            super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        }
    }
}
