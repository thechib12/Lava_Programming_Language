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
    private Map<String, Type> functionReturnTypes;
    private ParseTreeProperty<Type> types;
    private Map<String, List<Type>> functionParameterTypes;
    private static final List<Type> fork = new ArrayList<>();
    private List<String> errors;

    static {
        fork.add(Type.VOID);
    }

    private static final List<Type> join = new ArrayList<>();

    static {
        join.add(Type.INT);
    }


    /**
     * Explore.
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

    @Override
    public void exitType(LavaParser.TypeContext ctx) {
        types.put(ctx, types.get(ctx.primitiveType()));
    }

    @Override
    public void exitVoidType(LavaParser.VoidTypeContext ctx) {
        types.put(ctx, Type.VOID);
    }

    @Override
    public void exitCharType(LavaParser.CharTypeContext ctx) {
        types.put(ctx, Type.CHAR);
    }

    @Override
    public void exitBoolType(LavaParser.BoolTypeContext ctx) {
        types.put(ctx, Type.BOOL);
    }

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
