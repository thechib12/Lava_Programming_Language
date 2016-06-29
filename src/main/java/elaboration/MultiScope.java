package elaboration;

import java.util.*;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
public class MultiScope {
    /**
     * Map from declared variables to their types.
     */
    private Stack<Map<String, Type>> types;

    private Stack<Map<String, Integer>> scopes;

    private Stack<List<String>> parameters;

    private Stack<List<String>> localVar;

    private int scopeCount = 0;


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



    public void openScope() {
        scopeCount++;
        this.types.add(new HashMap<>(this.types.peek()));
        this.scopes.add(new HashMap<>(this.scopes.peek()));
        this.parameters.add(new ArrayList<>(parameters.peek()));
        this.localVar.add(new ArrayList<>(localVar.peek()));
    }

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

    public boolean contains(String id) {
        return this.types.peek().containsKey(id);
    }

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

    public Type type(String id) {
        return types.peek().get(id);
    }
    public Integer offset(String id) {
        return scopes.peek().get(id);
    }

    public boolean isParameter(String id) {
        return parameters.peek().contains(id);
    }

    public boolean isLocal(String id) {
        return localVar.peek().contains(id);
    }
}
