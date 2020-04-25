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

    /**
     * visszaadja az isOpen adattagot
     * @return
     */
    @Override
    public boolean IsOpen() {
        return isOpen;
    }

    /**
     * beallitja a jegtablanak az itemjet
     * @param _item a beallitott item
     */
    @Override
    public void setItem(Item _item) {
            item = _item;
    }
    @Override
    public Item getItem(){return item;}

    /**
     * isOpen settere
     * @param b a logikai ertek
     */
    public void setIsOpen(boolean b){
        isOpen = b;
    }

    /**
     * jegtablara lep az entity
     * @param e az entity aki a jegtablara lep
     */
    @Override
    public void Accept(Entity e) {
        getEntites().add(e);

        for (Entity i: entities) {
            i.Meet(e);
        }

        int numberOfPlayers = 0;
        for(int i = 0; i < getEntites().size(); i++){
            if(getEntites().get(i) instanceof Player){
                numberOfPlayers++;
            }
        }

        if(numberOfPlayers > getCapacity()){
            for (Entity i: getEntites()) {
                i.setInWater(true);
            }
            Coverable nogloo = new NoCover();
            Cover(nogloo);
        }
    }

    /**
     *
     * @param n a reteggel valo csokkentes szama
     */
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

    /**
     * az iceblock kimeneti nyelvve valo alakitasa
     * @param objects a hashmap ami tarolja az objektumokat es a hozza tartozo
     *                id-ket
     * @return
     */
    public String toString(HashMap<String,Object> objects){
        String itemString = Test.getKeyByValue(objects,this.item) == null ? "" : Test.getKeyByValue(objects,this.item);
        String result = "field:\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n" +
                "\ttype: " + "iceblock" + "\n" +
                "\tlayersOfSnow: " + this.getLayerOfSnow() + "\n" +
                "\tneighbours: " + concatNeighbours(getNeighbours(),objects) + "\n" +
                "\tlimit: " + this.getCapacity() + "\n" +
                "\topen: " + this.isOpen + "\n" +
                "\tcover: " + this.cover.toString() + "\n" +
                "\titem: " + itemString;
        return result;
    }
}
