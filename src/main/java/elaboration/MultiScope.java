package elaboration;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
public class MultiScope implements Scope {
    /**
     * Map from declared variables to their types.
     */
    private Map<String, Type> types;

    private Stack<Map<String, Integer>> scopes;

    private final int initialSize = 0;


    public MultiScope() {
        types = new HashMap<>();
        scopes = new Stack<>();
        this.scopes.add(new HashMap<>());
    }


    @Override
    public void openScope() {
        this.scopes.add(new HashMap<>(this.scopes.peek()));
    }

    @Override
    public void closeScope() {
        if (this.scopes.size() == 1) {
            throw new RuntimeException();
        }
        this.scopes.pop();
    }

    @Override
    public boolean contains(String id) {
        return this.scopes.peek().containsKey(id);
    }

    @Override
    public boolean put(String id, Type type) {
        boolean sameType = (!types.containsKey(id)) || (types.containsKey(id) && types.get(id) != type);
        boolean notDefinedInScope = !this.scopes.peek().containsKey(id);

        if (sameType && notDefinedInScope) {
            int size = 0;
            Map<String, Integer> scope = scopes.peek();
            for (String var : scope.keySet()) {
                size += types.get(var).size();
            }
            size += type.size();
            types.put(id, type);
            scope.put(id, size);


        }

        return sameType && notDefinedInScope;
    }

    @Override
    public Type type(String id) {
        return types.get(id);
    }

    @Override
    public Integer offset(String id) {
        return scopes.peek().get(id);
    }
}
