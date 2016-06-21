package model;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 */
public class Addr extends Operand {
    /* Haskell prefix for the code generation represented as an Enum */
    private AddrType prefix;
    /* Register which contains the memory address. */
    private Reg register;
    /* Value representing the memory address or an immediate value depending on the prefix. */
    private int value;

    /**
     * Creates an Addr with a type and a register to point to.
     * @param type type should be {@link AddrType} IndAddr.
     * @param register register containing the memory address.
     */
    public Addr(AddrType type, Reg register){
        super(Type.ADDR);
        assert type == AddrType.IndAddr;
        this.prefix = type;
        this.register = register;
        this.value = -1;
    }

    public Addr(AddrType type,int value){
        super(Type.ADDR);
        assert type == AddrType.ImmValue || type == AddrType.DirAddr;
        this.prefix = type;
        this.value = value;
        this.register = null;
    }

    @Override
    public String toString() {
        if (register == null){
            return prefix + " " + value;
        }
        if (value == -1){
            return prefix + " " + register;
        }

        return super.toString();
    }


    public enum AddrType {
        IndAddr,
        ImmValue,
        DirAddr
    }
}
