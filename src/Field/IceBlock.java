package Field;

import Coverable.Coverable;
import Item.*;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class IceBlock extends Field {
    private List<Item> items = new ArrayList<Item>();

    /**
     * Visszaad egy mar kiasott targyat es eltavolitja azt a mezobol.
     * @return
     */
    @Override
    public Item RemoveItem(){
        Skeleton.Called("RemoveItem");
        Skeleton.Return();
        return null;
    }

    /**
     *  Beallitja az fedettseg strategiat.
     * @param c
     */
    public void Gloo(Coverable c){
        Skeleton.Called("Gloo");
        Skeleton.Return();
    }
}
