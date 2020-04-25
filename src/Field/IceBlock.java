package Field;

import Coverable.*;
import Game.Entity;
import Game.OutputToString;
import Item.*;
import Player.Player;
import Prototype.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A mezo egy tipusa. A jegtablat reprezentalja a jatekban.
 * Az eszkimok tudnak ra iglut epiteni és lehetnek targyak belefagyva, melyeket a jatekosok ki tudnak belole asni.
 */
public class IceBlock extends Field {
    /** A mezon talalhato item **/
    protected Item item = null;
    private boolean isOpen = false;

    @Override
    public boolean IsOpen() {
        return isOpen;
    }

    @Override
    public void setItem(Item _item) {
        if (item != null)
            item = _item;
    }
    public void setIsOpen(boolean b){
        isOpen = b;
    }
    @Override
    public void Accept(Entity e) {
        getEntites().add(e);

        for (Entity i: entities) {

            i.Meet(e);
        }
        if(getEntites().size()>getCapacity()){
            for (Entity i: getEntites()) {
                i.setInWater(true);
            }
            Coverable nogloo = new NoCover();
            Cover(nogloo);
        }
    }

    @Override
    public void DecrLayerOfSnow(int n) {
        if(getLayerOfSnow()==0){isOpen = true;}
        else if(n<=getLayerOfSnow()) setLayerOfSnow(getLayerOfSnow()-n);
        else{setLayerOfSnow(0);}
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

    public String toString(HashMap<String,Object> objects){
        String result = "field\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\tTYPE: " + this.getClass() + "\n" +
                "\tlayersOfSnow: " + this.getLayerOfSnow() + "\n" +
                "\tneighbours: " + concatNeighbours(getNeighbours(),objects) + "\n" +
                "\tlimit: " + this.getCapacity() + "\n" +
                "\topen: " + this.isOpen + "\n" +
                "\tcover: " + this.cover.getClass() + "\n" +
                "\titem: " + Test.getKeyByValue(objects,this.item) + "\n";
        return result;
    }

}
