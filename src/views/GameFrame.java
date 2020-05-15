package views;

import Field.Field;
import Game.Game;
import Item.Item;
import Player.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class GameFrame extends JFrame {
    Game game;
    static Field chosenField;
    static Player currentPlayer;
    static Player chosenPlayer;
    static Item chosenItem;

    public void InitComponents(){
        throw new NotImplementedException();
    }
    public void setGame(Game g){
        game = g;
    }
    public void Run(){
        throw new NotImplementedException();
    }
    public static void setChosenField(Direction dir){
        throw new NotImplementedException();
    }
    public static void setChosenPlayer(Player p){
        chosenPlayer = p;
    }
    public static void setChosenItem(Item i){
        chosenItem = i;
    }
}
