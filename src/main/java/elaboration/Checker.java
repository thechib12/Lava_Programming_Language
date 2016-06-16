package elaboration;

import grammar.LavaBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

/**
 * Created by Rogier on 16-06-16 in Enschede.
 */
public class Checker extends LavaBaseListener {
    private CheckerResult checkerResult;

    private Scope scope;

    private List<String> errors;


    public CheckerResult check(ParseTree tree){
        return checkerResult;
    }




    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    private void addError(ParserRuleContext node, String message, Object... args) {
        int line = node.getStart().getLine();
        int column = node.getStart().getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    private void setOffset(ParseTree node, Integer offset) {
        this.checkerResult.setOffset(node, offset);
    }

    private void setType(ParseTree node, Type type) {
        this.checkerResult.setType(node, type);
    }

    private Type getType(ParseTree node) {
        return this.checkerResult.getType(node);
    }

    private void setEntry(ParseTree node, ParserRuleContext entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null flow graph entry");
        }
        this.checkerResult.setEntry(node, entry);
    }

    private ParserRuleContext getEntry(ParseTree node) {
        return this.checkerResult.getEntry(node);
    }
}
