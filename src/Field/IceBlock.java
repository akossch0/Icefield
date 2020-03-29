package Field;

import Coverable.*;
import Item.*;
import Player.Player;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class IceBlock extends Field {
    /**
     * Ez a fuggveny hivodik amikor egy player erre a mezore lep
     * @param p a jatekos aki a mezore lep
     */
    @Override
    public void Accept(Player p) {
        Skeleton.Called(this,"Accept");
        getPlayers().add(p);
        if(Skeleton.Question("<<Az új játékos új mezőre kerülésével túl lépi-e a játékosok száma a mező teherbíróképességét?(Igen/Nem)>> ")){
            for(int i = 0; i < getPlayers().size(); ++i){
                getPlayers().get(i).setInWater(true);
            }
            Coverable nogloo = new NoGloo();
            Gloo(nogloo);
        }
        Skeleton.Return();
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
    public void Gloo(Coverable c){
        Skeleton.Called(this,"Gloo");
        cover = c;
        Skeleton.Return();
    }

}
