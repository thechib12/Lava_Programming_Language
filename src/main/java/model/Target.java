package model;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 */
public class Target extends Operand {
    private String prefix;
    private Reg register;
    private int value;


    public Target(int value, boolean relative){
        super(Type.TARGET);
        if (relative){
            prefix = "Rel";
        } else {
            prefix = "Abs";
        }
        this.value = value;
        this.register = null;
    }

    public Target(Reg register){
        super(Type.TARGET);
        prefix = "Ind";
        this.register = register;
        value = -1;
    }

}
