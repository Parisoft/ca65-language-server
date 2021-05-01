package com.parisoft.ca65.lsp.util;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.lsp4j.Position;

public class Contexts {

    public static String sourceText(ParserRuleContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);

        return ctx.start.getInputStream().getText(interval);
    }

    public static Position positionOf(ParserRuleContext ctx) {
        return new Position(ctx.getStart().getLine() - 1, ctx.getStart().getCharPositionInLine());
    }

    public static Position positionOf(Token token) {
        return new Position(token.getLine() - 1, token.getCharPositionInLine());
    }

    public static Position positionOf(ParserRuleContext ctx, Position offset) {
        return new Position(offset.getLine() + ctx.getStart().getLine() - 1,
                            offset.getCharacter() + ctx.getStart().getCharPositionInLine());
    }
}
