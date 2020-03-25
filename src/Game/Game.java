package Game;

import Field.Field;

import java.util.*;
import Skeleton.*;


public final class Game {
    /**
     * A jatekteren talalhato osszes mezo
      */
    private List<Field> fields = new ArrayList<>();

    /**
     * a statikus valtozo amin hivjuk a fuggvenyeket
     */
    private static Game INSTANCE;

    /**
     * @return visszakuldi a statikus valtozot ha nem ures, amugy pedig peldanyosit
     */
    public static Game getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Game();

        return INSTANCE;
    }

    /**
     * elinditja a jatekot
     */
    public void StartGame(){
        Skeleton.Called(this,"StartGame()");
        InitMap();
        Manager.Start();
        Skeleton.Return();
    }

    /**
     * inicializalja a jatekteret, vagyis beallitja a jegtablak es targyak elhelyezkedeset
     */
    public void InitMap(){
        Skeleton.Called(this,"InitMap()");
        Skeleton.Return();
    }

    /**
     * Jatek megnyerese
     */
    public void Win(){
        Skeleton.Called("Win()");
        Skeleton.Return();
    }

    /**
     * Jatek elvesztese
     */
    public void Lose(){
        Skeleton.Called("Lose()");
        Skeleton.Return();
    }
}
