package Item;

import Field.Field;
import Player.*;
import Prototype.Test;

import java.util.HashMap;

/**
 * Asot reprezentalja a jatekban, hasznalataval 2 egysegnyi havat tud eltakarítani egy munkaegység felhasznalasaval a jatekos, aki hasznalja.
 */
public class Spade extends Item {
    /**
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    private int durability;
    public void setDurability(int d){
        durability = d;
    }
    public Spade(int dur){
        durability = dur;
    }

    @Override
    public void Use(Player p) {
        this.getHolder().decreaseWorkUnits();
        Field field = p.getField();
        field.DecrLayerOfSnow(2);
        if(durability > 0){
            if(durability - 1 == 0){
                this.getHolder().RemoveItem(this);
            }else{
            durability--;
            }
        }
    }

    /**
     * spade-nek a kimeneti nyelvre valo forditasa
     * @param objects hashmap ami tarolja a letrehozott objektumokat az id-jukkel parositva
     * @return
     */
    public String toString(HashMap<String,Object> objects){
        String result = "item:\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\ttype: " + this.toString() + "\n" +
                "\tholder: " + Test.getKeyByValue(objects,this.getHolder()) + "\n" +
                "\tdurability: " + this.durability + "\n";
        return result;
    }

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "spade";
    }
}
