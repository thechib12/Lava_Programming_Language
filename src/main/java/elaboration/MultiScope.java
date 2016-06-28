package elaboration;

import java.util.*;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
public class MultiScope implements Scope {
    /**
     * Map from declared variables to their types.
     */
    private Stack<Map<String, Type>> types;

    private Map<String, Integer> globalScope;

    private Stack<Map<String, Integer>> scopes;

    private Stack<List<String>> parameters;

    private final int initialSize = 0;


    public MultiScope() {
        types = new Stack<>();
        scopes = new Stack<>();
        parameters = new Stack<>();
        this.types.add(new HashMap<>());
        this.scopes.add(new HashMap<>());
        this.parameters.add(new ArrayList<>());
    }


    @Override
    public void openScope() {
        this.types.add(new HashMap<>(this.types.peek()));
        this.scopes.add(new HashMap<>(this.scopes.peek()));
        this.parameters.add(new ArrayList<>(parameters.peek()));
    }

    @Override
    public void closeScope() {
        if (this.scopes.size() == 1) {
            throw new RuntimeException();
        }
        this.types.pop();
        this.scopes.pop();
        this.parameters.pop();
    }

    @Override
    public boolean contains(String id) {
        return this.scopes.peek().containsKey(id);
    }

    @Override
    public boolean put(String id, Type type, int stackIndex, boolean isParameter) {
        boolean typeNotDefined = !types.peek().containsKey(id);
        boolean notDefinedInScope = !this.scopes.peek().containsKey(id);

        if (typeNotDefined && notDefinedInScope) {
            int size = 0;
            Map<String, Integer> scope = scopes.peek();
            for (String var : scope.keySet()) {
                if (!isParameter(var)) {
                    size += types.peek().get(var).size();
                }

            }
            size += type.size();
            types.peek().put(id, type);
            if (!isParameter) {
                scope.put(id, size);
            } else {
                scope.put(id, stackIndex);
                parameters.peek().add(id);
            }



        }

        return typeNotDefined && notDefinedInScope;
    }

    @Override
    public Type type(String id) {
        return types.peek().get(id);
    }

    @Override
    public Integer offset(String id) {
        return scopes.peek().get(id);
    }

    public boolean isParameter(String id) {
        return parameters.peek().contains(id);
    }
}
