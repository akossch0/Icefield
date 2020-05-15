package views;

import Item.Tent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TentView implements IView {
    Tent tent;
    TentView(Tent t){tent = t;}
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
