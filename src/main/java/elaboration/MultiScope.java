package elaboration;

import java.util.*;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
class MultiScope {
    /**
     * Map from declared variables to their types.
     */
    private final Stack<Map<String, Type>> types;

    private final Stack<Map<String, Integer>> scopes;

    private final Stack<List<String>> parameters;

    private final Stack<List<String>> localVar;

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
     * Open scope.
     */
    public void openScope() {
        scopeCount++;
        this.types.add(new HashMap<>(this.types.peek()));
        this.scopes.add(new HashMap<>(this.scopes.peek()));
        this.parameters.add(new ArrayList<>(parameters.peek()));
        this.localVar.add(new ArrayList<>(localVar.peek()));
    }

    /**
     * Close scope.
     */
    public void closeScope() {

        if (this.types.size() == 1) {
            throw new RuntimeException();
        }
        scopeCount--;
        this.types.pop();
        this.scopes.pop();
        this.parameters.pop();
        localVar.pop();
    }

    /**
     * Contains boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean contains(String id) {
        return this.types.peek().containsKey(id);
    }

    /**
     * Put boolean.
     *
     * @param id          the id
     * @param type        the type
     * @param isParameter the is parameter
     * @return the boolean
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
