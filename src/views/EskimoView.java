package views;

import Game.Actor;
import Player.Eskimo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EskimoView implements IView {
    Eskimo eskimo;
    EskimoView(Eskimo e){
        eskimo = e;
    };
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
