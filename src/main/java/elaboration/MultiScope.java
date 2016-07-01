package elaboration;

import java.util.*;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
public class MultiScope {

    /**
     * Stack of maps from declared variables to their types.
     */
    private final Stack<Map<String, Type>> types;

    /** Stack of maps of variables to their integer offset. */
    private final Stack<Map<String, Integer>> scopes;

    /** Stack of lists containing all parameters in this scope. */
    private final Stack<List<String>> parameters;

    /** Stack of lists containing all local variables in this scope.*/
    private final Stack<List<String>> localVar;

    /** The amount of scopes */
    private int scopeCount = 0;


    /**
     * Instantiates a new Multi scope.
     */
    public MultiScope() {
        types = new Stack<>();
        scopes = new Stack<>();
        parameters = new Stack<>();
        localVar = new Stack<>();
        this.types.add(new HashMap<>());
        this.scopes.add(new HashMap<>());
        this.parameters.add(new ArrayList<>());
        localVar.add(new ArrayList<>());
        scopeCount++;
    }


    /**
     * Open a scope containing all values of its enclosing scope.
     */
    public void openScope() {
        scopeCount++;
        this.types.add(new HashMap<>(this.types.peek()));
        this.scopes.add(new HashMap<>(this.scopes.peek()));
        this.parameters.add(new ArrayList<>(parameters.peek()));
        this.localVar.add(new ArrayList<>(localVar.peek()));
    }

    /**
     * Close scope and the first item of each stack.
     * @throws ParseException when the scope count
     */
    public void closeScope() throws ParseException {

        if (this.types.size() == 1) {
            List<String> errors = new ArrayList<>();
            errors.add("Scoping error, no scopes exist anymore");
            throw new ParseException(errors);
        }
        scopeCount--;
        this.types.pop();
        this.scopes.pop();
        this.parameters.pop();
        localVar.pop();
    }

    /**
     * Put a variable in the scope of global variables, local variables and function parameters.
     * Global variables will be on the first scope and have offsets from range 1..n.
     * Local variables will be on the second scope and all following scopes and the variables will have offsets
     * in range 1..n. Parameters could be on any scope, but the definition of the Lava grammar tells us that parameters
     * will always be encoutered from the second scope on.
     *
     * @param id          the id of this variable.
     * @param type        the type of this variable
     * @param isParameter marks when this variable is a parameter.
     * @return if it succeeded putting this variable in this scope.
     */
    public boolean put(String id, Type type, boolean isParameter) {
        boolean typeNotDefined = !types.peek().containsKey(id);
        boolean notDefinedInScope = !this.scopes.peek().containsKey(id);

        if (typeNotDefined && notDefinedInScope) {
            types.peek().put(id, type);


            Map<String, Integer> scope = scopes.peek();
            if (!isParameter) {
                if (scopeCount == 1) {
                    int size = 0;
                    for (String var : scope.keySet()) {
                        size += types.peek().get(var).size();
                    }
                    size += type.size();
                    scope.put(id, size);
                } else {
                    int size = 0;
                    List<String> local = localVar.peek();
                    for (String var : local) {
                        size += types.peek().get(var).size();
                    }
                    localVar.peek().add(id);
                    size += type.size();
                    scope.put(id, size);

                }
            } else {
                int paramSize = 0;
                List<String> param = parameters.peek();
                for (String var : param) {
                    paramSize += types.peek().get(var).size();
                }
                paramSize += type.size();
                scope.put(id, paramSize);
                parameters.peek().add(id);
            }



        }
        return typeNotDefined && notDefinedInScope;
    }

    /**
     * Type type.
     *
     * @param id the id
     * @return the type
     */
    public Type type(String id) {
        return types.peek().get(id);
    }

    /**
     * Offset integer.
     *
     * @param id the id
     * @return the integer
     */
    public Integer offset(String id) {
        return scopes.peek().get(id);
    }

    /**
     * Is parameter boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean isParameter(String id) {
        return parameters.peek().contains(id);
    }

    /**
     * Is local boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean isLocal(String id) {
        return localVar.peek().contains(id);
    }
}
