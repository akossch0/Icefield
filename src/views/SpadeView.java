package views;

import Item.Spade;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SpadeView implements IView {
    Spade spade;
    SpadeView(Spade s){spade = s;}
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
