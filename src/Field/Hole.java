package Field;


import Coverable.Coverable;
import Game.Entity;
import Game.OutputToString;
import Item.Item;
import Player.Player;
import Prototype.Test;

import java.util.HashMap;
import java.util.List;

/**
 * A mezo egy tipusa. A jegtablak kozott levo lyukat reprezentalja a jatekban.
 * Nem lehet ra iglut epiteni. Teherbírása 0. Nem lehetnek rajta targyak.
 */
public class Hole extends Field implements OutputToString {

    @Override
    public boolean IsOpen() {
        return false;
    }

    @Override
    public void setItem(Item item) { }

    @Override
    public Item RemoveItem() {
        return null;
    }

    @Override
    public void Accept(Entity e) {
        entities.add(e);
        e.setInWater(true);
        e.setField(this);
        for (Entity i: entities) {
            i.Meet(e);
        }
    }

    @Override
    public void DecrLayerOfSnow(int n) {
        if(n<=getLayerOfSnow()) setLayerOfSnow(getLayerOfSnow()-n);
        else{setLayerOfSnow(0);}
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Cover(Coverable c){ }

    public String toString(HashMap<String,Object> objects){
        String result = "field\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\tTYPE: " + this.getClass() + "\n" +
                "\tlayersOfSnow: " + this.getLayerOfSnow() + "\n" +
                "\tneighbours: " + concatNeighbours(getNeighbours(),objects) + "\n" +
                "\tlimit: " + this.getCapacity() + "\n";
        return result;
    }
}
