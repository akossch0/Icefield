package Item;

import Field.IceBlock;
import Game.OutputToString;
import Player.*;
import Prototype.Test;

import java.util.HashMap;

/**
 * Absztrakt alaposztaly, a konkret peldanyai az Aso (Spade), Etel (Food),
 * Buvarruha (Swimsuit), Kotel (Rope), Nyero targy(WinningItem).
 * A targyakat reprezentalja a jatekban.
 */
public abstract class Item implements OutputToString {
    /**
     * A birtokosa az itemnek
     */
    private Player holder = null;

    private IceBlock field = null;

    /**
     * Az itemek kepesseget ezen a metoduson keresztul lehete hasznalni
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    public abstract void Use(Player p);



    public void setField(IceBlock f) { field = f; }

    public IceBlock getField() {
        if(holder == null)
            return field;
        return null;
    }

    /**
     * A tulajdonost allitja be
     * @param p az uj tulajdonosa az itemnek
     */
    public void setHolder(Player p){
        holder = p;
    }

    /**
     * Visszaadja a targyat birtoklo jatekost
     *
     */
    public Player getHolder(){
        return holder;
    }

    public String toString(HashMap<String,Object> objects){
        String holder = Test.getKeyByValue(objects,this.getHolder()) == null ?"":Test.getKeyByValue(objects,this.getHolder());
        String result = "item:\n" +
                    "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                    "\ttype: " + toString() + "\n" +
                    "\tholder: " + holder + "\n";
        return result;
    }
}
