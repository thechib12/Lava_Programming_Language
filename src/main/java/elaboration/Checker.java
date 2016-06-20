package elaboration;

import grammar.LavaBaseListener;
import grammar.LavaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier + Christiaan on 16-06-16 in Enschede.
 */
public class Checker extends LavaBaseListener {
    private CheckerResult checkerResult;

    private Scope scope;

    private List<String> errors;




    public CheckerResult check(ParseTree tree){
        checkerResult = new CheckerResult();
        scope = new Scope();
        errors = new ArrayList<>();
        new ParseTreeWalker().walk(this,tree);
        return checkerResult;
    }

    @Override
    public void exitMain(LavaParser.MainContext ctx) {
        setEntry(ctx,getEntry(ctx.block()));
    }

    @Override
    public void exitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx) {
        setType(ctx,getType(ctx.localVariableDeclaration()));
        setEntry(ctx,getEntry(ctx.localVariableDeclaration()));
    }

    @Override
    public void exitBlock(LavaParser.BlockContext ctx) {
        setEntry(ctx,getEntry(ctx.blockStatements()));
    }

    @Override
    public void exitBlockStatements(LavaParser.BlockStatementsContext ctx) {
        setEntry(ctx, getEntry(ctx.blockStatement(0)));

    }

    @Override
    public void exitBlockStatement(LavaParser.BlockStatementContext ctx) {
        if (ctx.localVariableDeclarationStatement() != null){
            setEntry(ctx,getEntry(ctx.localVariableDeclarationStatement()));
        } else {
            setEntry(ctx,getEntry(ctx.statement()));
        }
    }

    @Override
    public void exitIdExpr(LavaParser.IdExprContext ctx) {
        String id = ctx.VARID().getText();
        Type type = this.scope.type(id);
        if (type == null) {
            addError(ctx, "Variable '%s' not declared", id);
        } else {
            setType(ctx, type);
            setOffset(ctx, this.scope.offset(id));
            setEntry(ctx, ctx);
        }
    }

    @Override
    public void exitBoolExpr(LavaParser.BoolExprContext ctx) {
        checkType(ctx.expr(0), Type.BOOL);
        checkType(ctx.expr(1), Type.BOOL);
        setType(ctx,Type.BOOL);
        setEntry(ctx, ctx.expr(0));
    }

    @Override
    public void exitFalseExpr(LavaParser.FalseExprContext ctx) {
        setType(ctx,Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitCompExpr(LavaParser.CompExprContext ctx) {
        checkType(ctx.expr(0), Type.INT, Type.CHAR);
        checkType(ctx.expr(1), Type.INT, Type.CHAR);
        setType(ctx, Type.BOOL);
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitNotExpr(LavaParser.NotExprContext ctx) {
        Type type;
        if (ctx.negaOp().NOT() != null) {
            type = Type.BOOL;
        } else {
            assert ctx.negaOp().MINUS() != null;
            type = Type.INT;
        }
        checkType(ctx.expr(), type);
        setType(ctx, type);
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitParExpr(LavaParser.ParExprContext ctx) {
        setType(ctx, getType(ctx.expr()));
        setEntry(ctx, getEntry(ctx));
    }

    @Override
    public void exitPlusExpr(LavaParser.PlusExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);
        setType(ctx, Type.INT);
        setEntry(ctx, getEntry(ctx.expr(0)));

    }

    @Override
    public void exitAssignStat(LavaParser.AssignStatContext ctx) {
        Type type = this.getType(ctx.expr());
        Type type1 = this.getType(ctx.target());
        if (type == type1) {
            setType(ctx, type);
        } else {
            errors.add("Assignment type error");
        }
        this.setOffset(ctx, this.checkerResult.getOffset(ctx.target()));
        this.setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitVariableTarget(LavaParser.VariableTargetContext ctx) {
        this.setType(ctx, this.scope.type(ctx.VARID().getText()));
        this.setOffset(ctx,this.scope.offset(ctx.VARID().getText()));
    }

    @Override
    public void exitArrayIndexTarget(LavaParser.ArrayIndexTargetContext ctx) {
        if (getType(ctx.expr()).getKind() != TypeKind.INT ){
            addError(ctx,"Array index must be a rock.");
        } else {
//            int size = ctx.expr();
            this.setType(ctx, this.scope.type(ctx.VARID().getText()));
            this.setOffset(ctx,this.scope.offset(ctx.VARID().getText()) );
        }

    }

    @Override
    public void exitCharExpr(LavaParser.CharExprContext ctx) {
        setType(ctx, Type.CHAR);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitTrueExpr(LavaParser.TrueExprContext ctx) {
        setType(ctx, Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitNumExpr(LavaParser.NumExprContext ctx) {
        setType(ctx, Type.INT);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIfStat(LavaParser.IfStatContext ctx) {
        int exprCount = ctx.expr().size();
        for (int i = 0; i < exprCount; i++) {
            checkType(ctx.expr(i), Type.BOOL);
        }

        int statementCount = ctx.block().size();
        for (int j = 0; j < statementCount; j++) {
            setEntry(ctx, ctx.block(j));
        }
        setEntry(ctx, ctx.expr(0));
    }

    @Override
    public void exitReturnStat(LavaParser.ReturnStatContext ctx) {
        setType(ctx, getType(ctx.expr()));
        setEntry(ctx, ctx);
    }

    @Override
    public void exitWhileStat(LavaParser.WhileStatContext ctx) {
        checkType(ctx.expr(), Type.BOOL);
        setEntry(ctx, ctx.expr());

    }

    @Override
    public void exitMultExpr(LavaParser.MultExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(0), Type.INT);
        setType(ctx, Type.INT);
        setEntry(ctx, ctx.expr(0));

    }

    @Override
    public void exitPrimDecl(LavaParser.PrimDeclContext ctx) {
        Type type = getType(ctx.primitiveType());
        if (type.getKind() == TypeKind.VOID){
            addError(ctx,"Void is not a type for a variable");
        } else {
            this.scope.put(ctx.VARID().getText(),type);
            setType(ctx, type);
            setType(ctx.VARID(),type);
        }
        if (ctx.expr() != null){
            setEntry(ctx,getEntry(ctx.expr()));
        } else {
            setEntry(ctx,ctx);
        }

    }

    @Override
    public void exitArrayDecl(LavaParser.ArrayDeclContext ctx) {
//        int size = Integer.parseInt(ctx.NUM().getSymbol().getText());
//        Type type = new Type.Array(0,size,getType(ctx.primitiveType()));
//        if (type.getKind() == TypeKind.VOID){
//            addError(ctx,"Void is not a type for an array");
//        } else {
//            this.scope.put(ctx.VARID().getText(),type);
//            setType(ctx, type);
//            setType(ctx.VARID(),type);
//        }

    }

    @Override
    public void exitIntType(LavaParser.IntTypeContext ctx) {
        setType(ctx,Type.INT);
    }

    @Override
    public void exitBoolType(LavaParser.BoolTypeContext ctx) {
        setType(ctx,Type.BOOL);
    }


    @Override
    public void exitCharType(LavaParser.CharTypeContext ctx) {
        setType(ctx,Type.CHAR);
    }


    @Override
    public void exitVoidType(LavaParser.VoidTypeContext ctx) {
        setType(ctx,Type.VOID);
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

    private void checkType(ParserRuleContext node, Type... expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        for (Type type :
             expected) {
            if (!actual.equals(type)) {
                addError(node, "Expected type '%s' but found '%s'", expected,
                        actual);
            }
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
