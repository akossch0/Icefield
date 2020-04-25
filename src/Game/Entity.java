package Game;

import Field.Field;

import java.util.List;

/**
 * Abstract osztaly. Jatekon belul fizikai lettel rendelkezo elolenyek ose.
 */
public abstract class Entity implements Actor{
    protected Field field = null;
    /**
     * A player a parameterben megadott mezore lep
     * @param f A mezo amire az entity lep
     */
    public void Step(Field f){
        field.Remove(this);
        field = f;
        f.Accept(this);
    }
    public void setField(Field field) {
        this.field = field;
    }
    public Field getField(){return field;}
    public abstract void setInWater(boolean b);
}
