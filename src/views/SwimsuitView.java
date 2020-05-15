package views;

import Item.Swimsuit;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SwimsuitView implements IView {
    Swimsuit swimsuit;
    SwimsuitView(Swimsuit s){swimsuit = s;}
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
