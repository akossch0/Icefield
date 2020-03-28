package Field;

import Coverable.*;
import Item.*;
import Player.Player;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class IceBlock extends Field {
    private List<Item> items = new ArrayList<Item>();

    @Override
    public void Accept(Player p) {
        getPlayers().add(p);
        if(Skeleton.getQuestionresult()){
            for(int i = 0; i < getPlayers().size(); ++i){
                getPlayers().get(i).setInWater(true);
            }
            Coverable nogloo = new NoGloo();
            Gloo(nogloo);
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
