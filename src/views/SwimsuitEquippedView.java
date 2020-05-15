package views;

import ClothesEquipped.SwimsuitEquipped;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SwimsuitEquippedView implements IView  {
    SwimsuitEquipped swimsuitEquipped;
    SwimsuitEquippedView(SwimsuitEquipped s){swimsuitEquipped = s;}
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
