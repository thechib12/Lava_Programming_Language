package model;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 */
public class Addr extends Operand {
    private String prefix;
    private Reg register;
    private int value;

    public Addr(Reg register){
        super(Type.ADDR);
        this.prefix = "IndAddr";
        this.register = register;
        this.value = -1;
    }

    public Addr(int value, boolean immediate){
        super(Type.ADDR);
        if (immediate){
            this.prefix = "ImmValue";
        } else {
            this.prefix = "DirAddr";
        }
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
}
