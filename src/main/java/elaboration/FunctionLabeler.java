package elaboration;

import grammar.LavaBaseListener;
import grammar.LavaParser;
import model.Label;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 * FunctionLabeler finds each function declaration in the Lava program and creates a label for it,
 * so other functions can jump to that label.
 */
class FunctionLabeler extends LavaBaseListener {
    private Map<String, Label> labels;


    /**
     * Walk the parse tree and return all functions and labels.
     *
     * @param tree the tree
     * @return the map
     */
    public Map<String, Label> labelFunctions(ParseTree tree) {
        labels = new HashMap<>();
        new ParseTreeWalker().walk(this, tree);
        return labels;
    }

    /**
     * Puts the function id and a corresponding label into the mapping.
     *
     * @param ctx FunctionDeclaration node.
     */
    @Override
    public void exitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx) {
        labels.put(ctx.ID().getText(), new Label(ctx.ID().getText()));
    }
}
