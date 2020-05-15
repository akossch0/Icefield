package views;

import Game.Actor;
import Player.Eskimo;


public class EskimoView implements IView {
    Eskimo eskimo;
    EskimoView(Eskimo e){
        eskimo = e;
    };
    @Override
    public void Draw() {
    }

    @Override
    public void RefreshData() {

    }
}
