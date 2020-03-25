package Game;

import Item.Item;
import Player.Player;

import java.util.*;

public final class Manager {
    private Game game;
    private List<Player> players = new ArrayList<>();
    private Weather weather;
    private static Manager INSTANCE;

    public static Manager getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Manager();

        return INSTANCE;
    }

    public static void addItem(Item i){}

    public static void Start(){}

    public static void Lose(){ }
}
