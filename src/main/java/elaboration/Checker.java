package elaboration;

import grammar.LavaBaseListener;
import grammar.LavaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rogier + Christiaan on 16-06-16 in Enschede.
 * Type checker, control flow creator and variable offset generator.
 */
public class Checker extends LavaBaseListener {
    /* Result object to store all the data from this checker.*/
    private CheckerResult checkerResult;

    /* The current scope of the the type checker, a single scope at this time.*/
    private MultiScope scope;
    private Map<String, Type> functionReturnTypes;
    private Map<String, List<Type>> functionParameters;
    private Map<String, Boolean> sharedVars;
    /* The list of errors that occured while checking.*/
    private List<String> errors;
    private String currentFunction;

    /**
     * @return the list of all errors.
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * This method walks the parse tree and checks the types of the program.
     *
     * @param tree input {@link ParseTree} of the Lava Program.
     * @return a {@link CheckerResult} object which stores all revelant data of the checking phase.
     */
    public CheckerResult check(ParseTree tree) throws ParseException {
        scope = new MultiScope();
        errors = new ArrayList<>();
        sharedVars = new HashMap<>();
        Explorer explorer = new Explorer();
        explorer.explore(tree);
        functionReturnTypes = explorer.getFunctionReturnTypes();
        functionParameters = explorer.getFunctionParameterTypes();
        checkerResult = new CheckerResult();
        new ParseTreeWalker().walk(this, tree);
        if (errors.size() > 0) {
            throw new ParseException(errors);
        }
        return checkerResult;
    }

//  Program ------------------------------------------------------------------------------------------------------------

    //  Functions ----------------------------------------------------------------------------------------------------------
    @Override
    public void enterFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx) {
        currentFunction = ctx.ID().getText();
        if (currentFunction.equals("fork")) {
            addError(ctx, "fork is a pre defined function, you cannot declare this");
        }
        scope.openScope();
    }

    @Override
    public void exitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx) {
        if (ctx.type().shared() != null) {
            addError(ctx, "functions cannot return a shared variable");
        }
        scope.closeScope();
    }

    @Override
    public void exitParametersDeclaration(LavaParser.ParametersDeclarationContext ctx) {
        for (int i = 0; i < ctx.type().size(); i++) {
            Type type = getType(ctx.type(i));
            if (type.getKind() == TypeKind.VOID) {
                addError(ctx, "Void is not a type for a variable");
            } else {
                if (!this.scope.put(ctx.VARID(i).getText(), type, true)) {
                    addError(ctx, "Variable already declared: " + ctx.VARID(i).getText());
                }
                setOffset(ctx.VARID(i), this.scope.offset(ctx.VARID(i).getText()));
                setLocal(ctx.VARID(i), false);
                sharedVars.put(ctx.VARID(i).getText(), false);
                setType(ctx.VARID(i), type);
            }

        }
    }

    @Override
    public void exitFunctionCall(LavaParser.FunctionCallContext ctx) {
        String id = ctx.ID().getText();
        int varCount = ctx.parameters().expr().size();
        List<Type> varTypes = new ArrayList<>();
        for (int i = 0; i < varCount; i++) {
            varTypes.add(getType(ctx.parameters().expr(i)));
        }
        if (!varTypes.equals(functionParameters.get(id))) {
            addError(ctx, "Invalid parameters used");
        }
    }

    @Override
    public void exitParameters(LavaParser.ParametersContext ctx) {

    }

    //  Block --------------------------------------------------------------------------------------------------------------
    @Override
    public void enterBlock(LavaParser.BlockContext ctx) {
        scope.openScope();
    }

    @Override
    public void exitBlock(LavaParser.BlockContext ctx) {
        scope.closeScope();
    }


    //  Variable Declarations and assignment -------------------------------------------------------------------------------
    @Override
    public void exitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx) {
        setType(ctx, getType(ctx.localVariableDeclaration()));
    }

    @Override
    public void exitVariableTarget(LavaParser.VariableTargetContext ctx) {
        String id = ctx.VARID().getText();
        this.setType(ctx, this.scope.type(id));
        this.setParameter(ctx, this.scope.isParameter(id));
        this.setLocal(ctx, this.scope.isLocal(id));
        this.setOffset(ctx, this.scope.offset(id));
        if (getSharedVar(id) == null) {
            System.out.println(ctx.VARID().getText() + ": " + ctx.VARID().getSymbol().getLine());
        }
        this.setShared(ctx, getSharedVar(id));
    }

    @Override
    public void exitPrimitiveDeclaration(LavaParser.PrimitiveDeclarationContext ctx) {
        Type type = getType(ctx.primitiveType());
        String id = ctx.VARID().getText();
        if (type.getKind() == TypeKind.VOID) {
            addError(ctx, "Void is not a type for a variable");
        }
        if (!this.scope.put(id, type, false)) {
            addError(ctx, "Variable already declared: " + id);
        }
        setOffset(ctx, this.scope.offset(id));
        setLocal(ctx, this.scope.isLocal(id));
        setType(ctx, type);
        setType(ctx.VARID(), type);
        if (ctx.shared() != null) {
            sharedVars.put(id, true);
        } else {
            sharedVars.put(id, false);
        }
        setShared(ctx, getSharedVar(id));

    }


    //  Statements ---------------------------------------------------------------------------------------------------------
    @Override
    public void exitAssignStat(LavaParser.AssignStatContext ctx) {
        Type type = this.getType(ctx.expr());
        Type type1 = this.getType(ctx.target());
        if (type == null || type1 == null) {
            addError(ctx, "Variable not defined!");
        } else {
            if (type == type1) {
                setType(ctx, type);
            } else {
                addError(ctx, "You cant assign a " + type.toString() + " to a " + type1.toString());
            }

            this.setOffset(ctx, this.checkerResult.getOffset(ctx.target()));
            this.setParameter(ctx, getParameter(ctx.target()));
            this.setLocal(ctx, getLocal(ctx.target()));
            this.setShared(ctx, checkerResult.getSharedVar(ctx.target()));
        }

    }

    @Override
    public void exitIfStat(LavaParser.IfStatContext ctx) {
        int exprCount = ctx.expr().size();
        for (int i = 0; i < exprCount; i++) {
            checkType(ctx.expr(i), Type.BOOL);
        }
    }

    @Override
    public void exitReturnStat(LavaParser.ReturnStatContext ctx) {
        setType(ctx, getType(ctx.expr()));
        Type returnType = getType(ctx.expr());
        Type currentReturnType = functionReturnTypes.get(currentFunction);
        if (returnType == Type.INT && currentReturnType == Type.CHAR) {
            addError(ctx, "Jesus Christ Marie, they're minerals, not rocks! - Hank Schrader ");
        } else if (returnType != currentReturnType) {
            addError(ctx, "Incompatible Return type!");
        }
    }

    @Override
    public void exitWhileStat(LavaParser.WhileStatContext ctx) {
        checkType(ctx.expr(), Type.BOOL);

    }


//  Expressions --------------------------------------------------------------------------------------------------------

    @Override
    public void exitIdExpr(LavaParser.IdExprContext ctx) {
        String id = ctx.VARID().getText();
        Type type = this.scope.type(id);
        if (type == null) {
            addError(ctx, "Variable '%s' not declared", id);
        } else {
            setType(ctx, type);
            setParameter(ctx, this.scope.isParameter(id));
            setLocal(ctx, this.scope.isLocal(id));
            setOffset(ctx, this.scope.offset(id));
            setShared(ctx, getSharedVar(id));
        }
    }

    @Override
    public void exitBoolExpr(LavaParser.BoolExprContext ctx) {
        checkType(ctx.expr(0), Type.BOOL);
        checkType(ctx.expr(1), Type.BOOL);
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitFalseExpr(LavaParser.FalseExprContext ctx) {
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitCompExpr(LavaParser.CompExprContext ctx) {
        checkType(ctx.expr(0), Type.INT, Type.CHAR);
        checkType(ctx.expr(1), Type.INT, Type.CHAR);
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitNotExpr(LavaParser.NotExprContext ctx) {
        Type type = Type.INT;
        if (ctx.negaOp().NOT() != null) {
            type = Type.BOOL;
        }
        checkType(ctx.expr(), type);
        setType(ctx, type);
    }

    @Override
    public void exitParExpr(LavaParser.ParExprContext ctx) {
        setType(ctx, getType(ctx.expr()));
    }

    @Override
    public void exitPlusExpr(LavaParser.PlusExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);
        setType(ctx, Type.INT);
    }

    @Override
    public void exitCharExpr(LavaParser.CharExprContext ctx) {
        setType(ctx, Type.CHAR);
    }

    @Override
    public void exitTrueExpr(LavaParser.TrueExprContext ctx) {
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitNumExpr(LavaParser.NumExprContext ctx) {
        setType(ctx, Type.INT);
    }

    @Override
    public void exitMultExpr(LavaParser.MultExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(0), Type.INT);
        setType(ctx, Type.INT);

    }

    @Override
    public void exitFunctionExpr(LavaParser.FunctionExprContext ctx) {
        setType(ctx, functionReturnTypes.get(ctx.functionCall().ID().getText()));
    }

//   Types -------------------------------------------------------------------------------------------------------------

    @Override
    public void exitType(LavaParser.TypeContext ctx) {
        setType(ctx, getType(ctx.primitiveType()));
    }

    @Override
    public void exitIntType(LavaParser.IntTypeContext ctx) {
        setType(ctx, Type.INT);
    }

    @Override
    public void exitBoolType(LavaParser.BoolTypeContext ctx) {
        setType(ctx, Type.BOOL);
    }


    @Override
    public void exitCharType(LavaParser.CharTypeContext ctx) {
        setType(ctx, Type.CHAR);
    }


    @Override
    public void exitVoidType(LavaParser.VoidTypeContext ctx) {
        setType(ctx, Type.VOID);
    }


    /**
     * Checks this node for its correct type and throws errors if its type is not correct.
     *
     * @param node     current node in the parse tree.
     * @param expected type that is expected
     */
    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);
        if (actual == null) {
            addError(node, "Missing inferred type of " + node.getText());
        } else if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    /**
     * Variation to the above method. This method checks if the node belongs to any of the expected types.
     *
     * @param node     current node in the parse tree.
     * @param expected types that should be expected
     */
    private void checkType(ParserRuleContext node, Type... expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        boolean matchedType = false;
        for (Type type : expected) {
            if (actual.equals(type)) {
                matchedType = true;
            }
        }
        if (!matchedType) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    /**
     * This method formats the error given and adds the error to the list of errors.
     *
     * @param node    current node in the parse tree.
     * @param message the input error message.
     * @param args    optional arguments.
     */
    private void addError(ParserRuleContext node, String message, Object... args) {
        int line = node.getStart().getLine();
        int column = node.getStart().getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    private void addError(ParseTree node, String message) {
        this.errors.add(node.getText() + " Variable not declared in this scope! ");
    }

    private Boolean getSharedVar(String id) {
        return sharedVars.get(id);
    }

    /**
     * Sets the offset of this node.
     *
     * @param node   current node.
     * @param offset memory offset of this node.
     */
    private void setOffset(ParseTree node, Integer offset) {
        if (offset != null) {
            this.checkerResult.setOffset(node, offset);
        } else {
            addError(node, "Scoping error, variable already defined in other scope!");
        }
    }


    /**
     * Sets the type for this node.
     *
     * @param node current node.
     * @param type type of this node.
     */
    private void setType(ParseTree node, Type type) {
        this.checkerResult.setType(node, type);
    }

    /**
     * @param node current node.
     * @return the type of this node.
     */
    private Type getType(ParseTree node) {
        return this.checkerResult.getType(node);
    }

    private void setShared(ParseTree node, boolean shared) {
        this.checkerResult.setSharedVar(node, shared);
    }

    private void setParameter(ParseTree node, boolean parameter) {
        this.checkerResult.setParameterVar(node, parameter);
    }

    private boolean getParameter(ParseTree node) {
        return this.checkerResult.getParameterVar(node);
    }

    private void setLocal(ParseTree node, boolean local) {
        this.checkerResult.setLocalVar(node, local);
    }

    private boolean getLocal(ParseTree node) {
        return this.checkerResult.getLocalVar(node);
    }
}
