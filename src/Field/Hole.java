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
public class Hole extends Field {

    /**
     * hole implementacio miatt false
     * @return
     */
    @Override
    public boolean IsOpen() {
        return false;
    }

    /**
     * hole implementacio miatt ures
     * @param item az item amit elfogad
     */
    @Override
    public void setItem(Item item) { }
    @Override
    public Item getItem(){return null;}
    /**
     * hole-ban nicns item igy null a visszateres
     * @return
     */
    @Override
    public Item RemoveItem() {
        return null;
    }

    /**
     * lyukba eses
     * @param e az entity aki a lyukba lep
     */
    @Override
    public void Accept(Entity e) {
        entities.add(e);
        e.setInWater(true);

        for (Entity i: entities) {
            i.Meet(e);
        }
    }

    /**
     *
     * @param n a reteggel valo csokkentes mennyisege
     */
    @Override
    public void DecrLayerOfSnow(int n) {
        if(n<=getLayerOfSnow()) setLayerOfSnow(getLayerOfSnow()-n);
        else{setLayerOfSnow(0);}
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c a strategy
     */
    public void Cover(Coverable c){ }

    /**
     * hole kimeneti nyelvve valo atirasa
     * @param objects a tarolt objektumok az azonositashoz kell
     * @return
     */
    public String toString(HashMap<String,Object> objects){
        String result = "field:\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\ttype: " + "hole" + "\n" +
                "\tlayersOfSnow: " + this.getLayerOfSnow() + "\n" +
                "\tneighbours: " + concatNeighbours(getNeighbours(),objects) + "\n" +
                "\tlimit: " + this.getCapacity();
        return result;
    }
}
