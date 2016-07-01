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
 */
class FunctionLabeler extends LavaBaseListener {
    private Map<String, Label> labels;


    /**
     * Label func map.
     *
     * @param tree the tree
     * @return the map
     */
    public Map<String, Label> labelFunc(ParseTree tree) {
        labels = new HashMap<>();
        new ParseTreeWalker().walk(this, tree);
        return labels;
    }

    @Override
    public void exitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx) {
        labels.put(ctx.ID().getText(), new Label(ctx.ID().getText()));
    }
}
