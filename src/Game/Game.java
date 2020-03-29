package Game;

import Field.Field;

import java.util.*;
import Skeleton.*;

public final class Game {

    private static boolean isGameover = false;
    /**
     * A jatekteren talalhato osszes mezo
      */
    private List<Field> fields = new ArrayList<>();

    /**
     * a statikus valtozo amin hivjuk a fuggvenyeket
     */
    private static Game INSTANCE;

    /**
     * Vege a jateknak ha ez a fuggveny megvivodik trueval
     * @param b
     */
    public static void setGameOver(boolean b){
        isGameover = b;
    }

    /**
     * isGameover gettere
     * @return isGameover
     */
    public static boolean getGameOver(){
        return isGameover;
    }

    /**
     * @return visszakuldi a statikus valtozot ha nem ures, amugy pedig peldanyosit
     */
    public static Game getInstance(){
        // Ha meg egyszer sem keszitettunk el Game objektumot akkor most lesz elkeszitve
        if(INSTANCE == null)
            INSTANCE = new Game();

        return INSTANCE;
    }

    /**
     * Ha privat a konstruktor senki sem tudja osszekeverni a dolgokat
     * es mindenki helyesen a getInstance fuggvenyt fogja hasznali
     */
    private Game(){};
    /**
     * elinditja a jatekot
     */
    public void StartGame(){
        Skeleton.Called(this,"StartGame");
        InitMap();
        Manager.Start();
        Skeleton.Return();
    }

    /**
     * inicializalja a jatekteret, vagyis beallitja a jegtablak es targyak elhelyezkedeset
     */
    public void InitMap(){
        Skeleton.Called(this,"InitMap");
        Skeleton.Return();
    }

    /**
     * Jatek megnyerese
     */
    public void Win(){
        Skeleton.Called(this,"Win");
        Skeleton.Return();
    }

    /**
     * Jatek elvesztese
     */
    public void Lose(){
        Skeleton.Called(this,"Lose");
        setGameOver(true);
        Skeleton.Return();
    }
}
