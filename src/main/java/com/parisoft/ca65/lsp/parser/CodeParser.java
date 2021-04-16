package com.parisoft.ca65.lsp.parser;

import com.parisoft.ca65.lsp.grammar.CA65Lexer;
import com.parisoft.ca65.lsp.grammar.CA65Parser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import static java.lang.System.lineSeparator;

public class CodeParser {

    public static void main(String[] args) {
        String code = ""
                + "foo:"
                + lineSeparator()
//                + ".sizeof(9)"
                + lineSeparator()
                + "bar:"
                + lineSeparator()
                + "\t.mac lza\n"
                + "\tlda #0\n"
                + "\t.endmac";
        CA65ErrorListener errorListener = new CA65ErrorListener();
        CA65Lexer lexer = new CA65Lexer(CharStreams.fromString(code));
        CA65Parser parser = new CA65Parser(new CommonTokenStream(lexer));
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);
        new CA65POCVisitor().visit(parser.program());
        System.out.println("Errors: " + errorListener.errors);
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
