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
public class FunctionLabeler extends LavaBaseListener {
    private Map<String, Label> labels;


    public Map<String, Label> labelFunc(ParseTree tree) {
        labels = new HashMap<>();
        new ParseTreeWalker().walk(this, tree);
        return labels;
    }

    @Override
    public void exitFunctionDecl(LavaParser.FunctionDeclContext ctx) {
        labels.put(ctx.ID().getText(), new Label(ctx.ID().getText()));
    }
}
