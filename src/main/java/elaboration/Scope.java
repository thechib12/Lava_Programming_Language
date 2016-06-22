package elaboration;

/**
 * Created by Rogier on 22-06-16 in Enschede.
 */
public interface Scope {

    void openScope();

    void closeScope();


    /** Tests if a given identifier is declared in this scope. */
    boolean contains(String id);

    /** Declares an identifier with a given type, if the identifier
     * is not yet in this scope.
     * @return <code>true</code> if the identifier was added;
     * <code>false</code> if it was already declared.
     */
    boolean put(String id, Type type);


    /** Returns the type of a given (presumably declared) identifier.
     */
    Type type(String id);

    /** Returns the offset of a given (presumably declared) identifier.
     * with respect to the beginning of this scope's activation record.
     * Offsets are assigned in order of declaration.
     */
    Integer offset(String id);
}
