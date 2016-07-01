package elaboration;

/**
 * Created by Rogier on 15-06-16 in Enschede.
 * This class contains all types supported by Lava.
 */


/**
 * Lava data type.
 */
abstract public class Type {
    /**
     * The singleton instance of the {@link Bool} type.
     */
    public static final Type BOOL = new Bool();
    /**
     * The singleton instance of the {@link Int} type.
     */
    public static final Type INT = new Int();

    /**
     * The singleton instance of the {@link Char} type.
     */
    public static final Type CHAR = new Char();

    /**
     * The singleton instance of the {@link Void} type.
     */
    public static final Type VOID = new Void();

    private final TypeKind kind;

    /**
     * Constructor for subclasses.
     *
     * @param kind the kind
     */
    Type(TypeKind kind) {
        this.kind = kind;
    }

    /**
     * Returns the kind of this type.
     *
     * @return the kind
     */
    public TypeKind getKind() {
        return this.kind;
    }

    /**
     * returns the size (in bytes) of a value of this type.
     *
     * @return the int
     */
    abstract public int size();

    /**
     * Representation of the Lava Temperature (Boolean) type.
     */
    static public class Bool extends Type {
        /**
         * The constant BOOL_SIZE.
         */
        public static final int BOOL_SIZE = 1;


        private Bool() {
            super(TypeKind.BOOL);
        }

        @Override
        public int size() {
            return BOOL_SIZE;
        }

        @Override
        public String toString() {
            return "Boolean";
        }
    }

    /**
     * Representation of the Lava Rock (Integer) type.
     */
    static public class Int extends Type {
        /**
         * The constant INT_SIZE.
         */
        public static final int INT_SIZE = 1;

        private Int() {
            super(TypeKind.INT);
        }

        @Override
        public int size() {
            return INT_SIZE;
        }

        @Override
        public String toString() {
            return "Integer";
        }
    }



    /**
     * Representation of an Lava Mineral (Character) type.
     */
    static public class Char extends Type {
        /**
         * The constant CHAR_SIZE.
         */
        public static final int CHAR_SIZE = 1;

        private Char() {
            super(TypeKind.CHAR);
        }

        @Override
        public int size() {
            return CHAR_SIZE;
        }

        @Override
        public String toString() {
            return "Char";
        }
    }

    /**
     * The type Void.
     */
    static public class Void extends Type {
        /**
         * The constant VOID_SIZE.
         */
        public static final int VOID_SIZE = 0;

        private Void() {
            super(TypeKind.VOID);
        }

        @Override
        public int size() {
            return VOID_SIZE;
        }

        @Override
        public String toString() {
            return "Void";
        }
    }


}
