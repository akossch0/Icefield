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
        if(Skeleton.Question("<<Az új játékos új mezőre kerülésével túl lépi-e a játékosok száma a mező teherbíróképességét?(Igen/Nem)>> ")){
            for(int i = 0; i < getEntites().size(); ++i){
                getEntites().get(i).setInWater(true);
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
        Skeleton.Called(this,"RemoveItem");
        Skeleton.Return();
        if(item != null){
            Item i = item;
            item = null;
            return i;
        }
        return null;
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Cover(Coverable c){
        Skeleton.Called(this,"Gloo");
        cover = c;
        Skeleton.Return();
    }

}
