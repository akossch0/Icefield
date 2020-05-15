package views;

import Game.PolarBear;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PolarBearView implements IView {
    PolarBear polarBear;
    PolarBearView(PolarBear p){polarBear = p;}
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
