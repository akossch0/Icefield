package views;

import Game.Game;

import java.awt.*;

public class Controller {
     public static void UpdateRequired(){
         Game.getInstance().getView().Update();
     }
}
