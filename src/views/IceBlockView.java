package views;

import Field.IceBlock;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class IceBlockView implements IView {
    IceBlock iceBlock;
    IceBlockView(IceBlock i){iceBlock = i;}
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
