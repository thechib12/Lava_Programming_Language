package elaboration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by Rogier + Christiaan on 15-06-16 in Enschede.
 */
public class CheckerResult {
    /** Mapping from expressions to types. */
    private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();
    /** Mapping from variables to coordinates. */
    private final ParseTreeProperty<Integer> offsets = new ParseTreeProperty<>();

    private final ParseTreeProperty<Boolean> localVar = new ParseTreeProperty<>();

    private final ParseTreeProperty<Boolean> parameterVar = new ParseTreeProperty<>();

    private final ParseTreeProperty<Boolean> sharedVar = new ParseTreeProperty<>();


    /**
     * Adds an association from a parse tree node containing a
     * variable reference to the offset
     * of that variable.  @param node the node
     *
     * @param offset the offset
     */
    public void setOffset(ParseTree node, int offset) {
        this.offsets.put(node, offset);
    }

    /**
     * Returns the declaration offset of the variable
     * accessed in a given parse tree node.  @param node the node
     *
     * @return the offset
     */
    public int getOffset(ParseTree node) {
        return this.offsets.get(node);
    }


    /**
     * Adds an association from a parse tree expression, type,
     * or assignment target node to the corresponding (inferred) type.  @param node the node
     *
     * @param type the type
     */
    public void setType(ParseTree node, Type type) {
        this.types.put(node, type);
    }

    /**
     * Returns the type associated with a given parse tree node.  @param node the node
     *
     * @return the type
     */
    public Type getType(ParseTree node) {
        return this.types.get(node);
    }

    /**
     * Sets shared var.
     *
     * @param node   the node
     * @param shared the shared
     */
    public void setSharedVar(ParseTree node, boolean shared) {
        this.sharedVar.put(node, shared);
    }

    /**
     * Gets shared var.
     *
     * @param node the node
     * @return the shared var
     */
    public Boolean getSharedVar(ParseTree node) {
        return sharedVar.get(node);
    }

    /**
     * Sets parameter var.
     *
     * @param var       the var
     * @param parameter the parameter
     */
    public void setParameterVar(ParseTree var, boolean parameter) {
        this.parameterVar.put(var, parameter);
    }

    /**
     * Gets parameter var.
     *
     * @param var the var
     * @return the parameter var
     */
    public Boolean getParameterVar(ParseTree var) {
        return parameterVar.get(var);
    }

    /**
     * Sets local var.
     *
     * @param var   the var
     * @param local the local
     */
    public void setLocalVar(ParseTree var, boolean local) {
        this.localVar.put(var, local);
    }

    /**
     * Gets local var.
     *
     * @param var the var
     * @return the local var
     */
    public Boolean getLocalVar(ParseTree var) {
        return localVar.get(var);
    }
}
