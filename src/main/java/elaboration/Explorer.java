package elaboration;

import grammar.LavaBaseListener;
import grammar.LavaParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
class Explorer extends LavaBaseListener {

    /**
     * List of the parameter type of the function fork.
     */
    private static final List<Type> fork = new ArrayList<>();
    /**
     * List of the parameter type of the function join.
     */
    private static final List<Type> join = new ArrayList<>();

    /** Static initialization of the List fork. */
    static {
        fork.add(Type.VOID);
    }

    /** Static initialization of the List join */
    static {
        join.add(Type.INT);
    }

    /**
     * Mapping of function and its return type.
     */
    private Map<String, Type> functionReturnTypes;
    /**
     * Types synthesised from the parse tree
     */
    private ParseTreeProperty<Type> types;
    /**
     * Mapping of function and its parameter types.
     */
    private Map<String, List<Type>> functionParameterTypes;
    /**
     * List of all errors encountered during the exploring.
     */
    private List<String> errors;

    /**
     * Explore the parse tree for functions, return types and parameter types by walking the parse tree.
     * Fork and join are predefined functions so they have static parameters.
     *
     * @param tree the tree
     */
    public void explore(ParseTree tree) {
        errors = new ArrayList<>();
        functionReturnTypes = new HashMap<>();
        functionParameterTypes = new HashMap<>();
        types = new ParseTreeProperty<>();
        new ParseTreeWalker().walk(this, tree);
        functionReturnTypes.put("fork", Type.VOID);
        functionReturnTypes.put("join", Type.VOID);
        functionParameterTypes.put("fork", fork);
        functionParameterTypes.put("join", join);
        functionReturnTypes.put("lock", Type.VOID);
        functionReturnTypes.put("unlock", Type.VOID);
        functionParameterTypes.put("lock", new ArrayList<>());
        functionParameterTypes.put("unlock", new ArrayList<>());
    }

    /**
     * This methods queries the function id and checks if it has not already been declared.
     * It also adds its return type and its parameter types.
     *
     * @param ctx FunctionDeclaration node.
     */
    @Override
    public void exitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx) {
        String id = ctx.ID().getText();
        if (functionReturnTypes.containsKey(id)) {
            errors.add("rupture " + id + "() is already declared");
        }
        functionReturnTypes.put(id, types.get(ctx.type()));
        int typeCount = ctx.parametersDeclaration().type().size();
        List<Type> types1 = new ArrayList<>();
        for (int i = 0; i < typeCount; i++) {
            types1.add(types.get(ctx.parametersDeclaration().type(i)));

        }
        functionParameterTypes.put(id, types1);
    }

    /**
     * Sets the type based on its primitive type, since their are no compound types in Lava
     * and a function cannot return or have parameter of shared type by its definition.
     * @param ctx Type node.
     */
    @Override
    public void exitType(LavaParser.TypeContext ctx) {
        types.put(ctx, types.get(ctx.primitiveType()));
    }

    /**
     * Sets this node as an Type.Void.
     * @param ctx Void Type node.
     */
    @Override
    public void exitVoidType(LavaParser.VoidTypeContext ctx) {
        types.put(ctx, Type.VOID);
    }

    /**
     * Sets this node as an Type.Char.
     * @param ctx Char Type node.
     */
    @Override
    public void exitCharType(LavaParser.CharTypeContext ctx) {
        types.put(ctx, Type.CHAR);
    }

    /**
     * Sets this node as an Type.Bool.
     * @param ctx Bool Type node.
     */
    @Override
    public void exitBoolType(LavaParser.BoolTypeContext ctx) {
        types.put(ctx, Type.BOOL);
    }

    /**
     * Sets this node as an Type.Int.
     * @param ctx Int Type node.
     */
    @Override
    public void exitIntType(LavaParser.IntTypeContext ctx) {
        types.put(ctx, Type.INT);
    }

    /**
     * Gets function return types.
     *
     * @return the function return types
     */
    public Map<String, Type> getFunctionReturnTypes() {
        return functionReturnTypes;
    }

    /**
     * Gets function parameter types.
     *
     * @return the function parameter types
     */
    public Map<String, List<Type>> getFunctionParameterTypes() {
        return functionParameterTypes;
    }

    /**
     * Gets errors.
     *
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }
}
