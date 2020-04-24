package Field;


import Coverable.Coverable;
import Game.Entity;
import Item.Item;
import Player.Player;
import Skeleton.Skeleton;

import java.util.List;

/**
 * A mezo egy tipusa. A jegtablak kozott levo lyukat reprezentalja a jatekban.
 * Nem lehet ra iglut epiteni. Teherbírása 0. Nem lehetnek rajta targyak.
 */
public class Hole extends Field {

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


}
