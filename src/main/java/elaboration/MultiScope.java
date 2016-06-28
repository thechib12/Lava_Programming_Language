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

    private Stack<Integer> localVarCount;

    private final int initialSize = 0;


    public MultiScope() {
        types = new Stack<>();
        scopes = new Stack<>();
        parameters = new Stack<>();
        localVarCount = new Stack<>();
        this.types.add(new HashMap<>());
        this.scopes.add(new HashMap<>());
        this.parameters.add(new ArrayList<>());
        System.out.println("Init local count : " + localVarCount.peek());
    }

    public void initFunctionsPart() {
        localVarCount.add(0);
    }


    public void openScope() {
        System.out.println("Open local count : " + localVarCount.peek());
        this.types.add(new HashMap<>(this.types.peek()));
        this.scopes.add(new HashMap<>(this.scopes.peek()));
        this.parameters.add(new ArrayList<>(parameters.peek()));
        this.localVarCount.add(localVarCount.peek());
    }

    public void closeScope() {
        if (this.types.size() == 1) {
            throw new RuntimeException();
        }
        System.out.println("Close local count : " + localVarCount.peek());
        this.types.pop();
        this.scopes.pop();
        this.parameters.pop();
        localVarCount.pop();
    }

    public boolean contains(String id) {
        return this.types.peek().containsKey(id);
    }

    public boolean put(String id, Type type, int stackIndex, boolean isParameter) {
        boolean typeNotDefined = !types.peek().containsKey(id);
        boolean notDefinedInScope = !this.scopes.peek().containsKey(id);

        if (typeNotDefined && notDefinedInScope) {
            if (localVarCount.size() == 0) {

            }
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
                localVarCount.add(localVarCount.peek() + 1);
            } else {
                scope.put(id, stackIndex);
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
}
