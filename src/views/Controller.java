package views;

import Game.Game;



import java.awt.event.KeyListener;

public class Controller {
    static Game game;
    // Ide Kéne egy MouseHandler? az nem tudom mi
    //Ide kéne egy ButtonListener? az nem tudom mi
    KeyListener keyListener;
     static void UpdateRequired(){
         View v = game.getView();
         v.Update();
     }
}
