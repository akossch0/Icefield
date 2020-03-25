package Game;

import Field.Field;

import java.util.*;

public final class Game {
    private List<Field> fields = new ArrayList<>();
    private static Game INSTANCE;

    private Game(){}

    public static Game getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Game();

        return INSTANCE;
    }

    public void StartGame(){

    }

    public void InitMap(){

    }

    public void Blizzard(){

    }
    public void Win(){

    }

    public void Lose(){

    }
}
