package elaboration;

import grammar.LavaBaseListener;
import grammar.LavaParser;
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

    @Override
    public void exitLocalVariableDeclaration(LavaParser.LocalVariableDeclarationContext ctx) {
        this.scope.put(ctx.VARID().getText(),getType(ctx.type()));
        setType(ctx.VARID(),getType(ctx.type()));
        setType(ctx,getType(ctx.type()));
    }

    @Override
    public void exitType(LavaParser.TypeContext ctx) {
        if (ctx.arrayType().isEmpty()){
            setType(ctx, getType(ctx.primitiveType()));
        } else {
//            Type type = new Type.Array()


            setType(ctx, getType(ctx.primitiveType()));
        }

    }

    @Override
    public void exitIntType(LavaParser.IntTypeContext ctx) {
        super.exitIntType(ctx);
    }

    @Override
    public void exitBoolType(LavaParser.BoolTypeContext ctx) {
        super.exitBoolType(ctx);
    }

    @Override
    public void exitDoubleType(LavaParser.DoubleTypeContext ctx) {
        super.exitDoubleType(ctx);
    }

    @Override
    public void exitCharType(LavaParser.CharTypeContext ctx) {
        super.exitCharType(ctx);
    }

    @Override
    public void exitStringType(LavaParser.StringTypeContext ctx) {
        super.exitStringType(ctx);
    }

    @Override
    public void exitVoidType(LavaParser.VoidTypeContext ctx) {
        super.exitVoidType(ctx);
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
