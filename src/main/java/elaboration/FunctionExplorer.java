package elaboration;

import grammar.LavaBaseListener;
import grammar.LavaParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
public class FunctionExplorer extends LavaBaseListener {
    private Map<String, Type> functions;
    private ParseTreeProperty<Type> types;

    public Map<String, Type> explore(ParseTree tree) {
        functions = new HashMap<>();
        types = new ParseTreeProperty<>();
        new ParseTreeWalker().walk(this, tree);


        return functions;
    }


    @Override
    public void exitFunctiondecl(LavaParser.FunctiondeclContext ctx) {
        functions.put(ctx.ID().getText(), types.get(ctx.type()));
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
}
