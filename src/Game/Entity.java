package Game;

import Field.Field;

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

    /**
     * egy entity aktualis fieldjet allitja be
     * @param field a bealitott aktualis field
     */
    public void setField(Field field) {

        this.field = field;
        field.Accept(this);
    }

    /**
     * az aktualis field lekerdezese
     * @return
     */
    public Field getField(){return field;}

    /**
     * kesobb megvalositott fuggveny, a vizbeeses miatt kell
     * @param b
     */
    public abstract void setInWater(boolean b);
}
