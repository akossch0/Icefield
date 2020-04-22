package Field;

import Coverable.*;
import Game.Entity;
import Item.*;
import Player.Player;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class IceBlock extends Field {


    @Override
    public void Accept(Entity e) {
        getEntites().add(e);
        e.setField(this);
        for (Entity i: entities) {
            i.Meet(e);
        }
        if(getEntites().size()>getCapacity()){
            for (Entity i: getEntites()) {
                i.setInWater(true);
            }
            Coverable nogloo = new NoGloo();
            Cover(nogloo);
        }
    }

    /**
     * Visszaad egy mar kiasott targyat es eltavolitja azt a mezobol.
     * @return
     */
    @Override
    public Item RemoveItem(){
        Item i = item;
        item = null;
        return i;
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Cover(Coverable c){
        cover = c;
    }

}
