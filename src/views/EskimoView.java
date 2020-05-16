package views;

import Game.Actor;
import Player.Eskimo;

import java.awt.*;


public class EskimoView implements IView {
    Eskimo eskimo;
    EskimoView(Eskimo e){
        eskimo = e;
    };
    @Override
    public void Draw(Graphics graphics) {
    }

    @Override
    public void RefreshData() {

    }
}
