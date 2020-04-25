package Item;

import Field.Field;
import Player.*;
import Prototype.Test;

import java.util.HashMap;

/**
 * Asot reprezentalja a jatekban, hasznalataval 2 egysegnyi havat tud eltakarítani egy munkaegység felhasználasaval a jatekos, aki hasznalja.
 */
public class Spade extends Item {
    /**
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    private int durability = Integer.MAX_VALUE;
    public void setDurability(int d){
        durability = d;
    }
    @Override
    public void Use(Player p) {
        Field field = p.getField();
        field.DecrLayerOfSnow(2);
    }

    public String toString(HashMap<String,Object> objects){
        String result = "item\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\tTYPE: " + this.getClass() + "\n" +
                "\tholder: " + Test.getKeyByValue(objects,this.getHolder()) + "\n" +
                "\tdurability: " + this.durability + "\n";
        return result;
    }
}
