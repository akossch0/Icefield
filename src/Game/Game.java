package Game;

import Field.Field;

import java.util.*;

import Item.*;
import java.lang.Math;
import Field.*;
/**
 * Inicializalja a jegtablakat. Inicializalja a jatekot, majd szamontartja, hogy eppen melyik jatekos lep.
 * Hoviharokat general a jatekosok lepesei kozott.
 */
public final class Game {

    private static boolean gameWon = false;
    private static boolean gameLost = false;
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
        // Ha meg egyszer sem keszitettunk el Game objektumot akkor most lesz elkeszitve
        if(INSTANCE == null)
            INSTANCE = new Game();

        return INSTANCE;
    }

    /**
     * Megnyert-e a jatek
     * @return
     */
    public static boolean isGameWon(){ return gameWon; }

    /**
     * Elvesztett-e a jatek
     * @return
     */
    public static boolean isGameLost(){ return gameLost; }

    /**
     * Ha privat a konstruktor senki sem tudja osszekeverni a dolgokat
     * es mindenki helyesen a getInstance fuggvenyt fogja hasznali
     */
    private Game(){};
    /**
     * elinditja a jatekot
     */
    public void StartGame(){
        InitMap();
        Manager.Start();
    }

    /**
     * inicializalja a jatekteret, vagyis beallitja a jegtablak es targyak elhelyezkedeset
     */
    public void InitMap(){
        Random random = new Random(1);
        double P_IceField = 0.80;
        int Snow_Thickness = 4;
        int Number_Of_Fields = 20;
        int Max_Capacity = 4;
        double P_Hole = 0.20;
        int Width = 600;
        int Height = 600;
        int Min_Dist = 20;
        int Max_Dist = 40;
        while(fields.size() != Number_Of_Fields){
            int randomX = random.nextInt(Width);
            int randomY = random.nextInt(Height);
            for (Field f : fields){
                int X_Dist = randomX- f.X;
                int Y_Dist = randomY- f.Y;

                int dist = (int)Math.sqrt(X_Dist*X_Dist+Y_Dist*Y_Dist);
                if (dist > Min_Dist){
                    double prob = random.nextDouble();
                    if (prob > P_IceField){
                        fields.add( new Hole());
                    }
                    else{
                        IceBlock iceblock = new IceBlock();
                        int thickness = random.nextInt(Snow_Thickness);
                        int capacity = random.nextInt(Max_Capacity+1);
                        if (capacity>=Max_Capacity ){
                           iceblock.setCapacity(Integer.MAX_VALUE);
                        }
                        else{
                            iceblock.setCapacity(capacity+1);
                        }
                        iceblock.setLayerOfSnow(thickness);
                        fields.add(iceblock);
                    }
                }
            }

        }
        for (Field i: fields){
            for(Field j: fields){
                int X_Dist = i.X- j.X;
                int Y_Dist = i.Y- j.Y;

                int dist = (int)Math.sqrt(X_Dist*X_Dist+Y_Dist*Y_Dist);
                if (dist < Max_Dist){
                    i.AddNeighbour(j);
                }
            }
        }
        ArrayList<Item> items = new ArrayList<Item>();
        fields.get(0).setItem(new WinningItem());
        fields.get(1).setItem(new WinningItem());
        fields.get(2).setItem(new WinningItem());
        // Tent
        for (int i = 0; i < Number_Of_Fields /10; i++ )
            items.add(new Tent());
        // Swimsuit
        for (int i = 0; i < Number_Of_Fields /15; i++ )
            items.add(new Swimsuit());
        // Spade
        for (int i = 0; i < Number_Of_Fields /5; i++ )
            items.add(new Spade());
        // Rope
        for (int i = 0; i < Number_Of_Fields /8; i++ )
            items.add(new Rope());
        // Food
        for (int i = 0; i < Number_Of_Fields /4; i++ )
            items.add(new Food());
        for (Item i : items){
            int randomField = random.nextInt(fields.size());
            fields.get(randomField).setItem(i);
        }
    }

    /**
     * Jatek megnyerese
     */
    public void Win(){ gameWon = true; }

    /**
     * Jatek elvesztese
     */
    public void Lose(){ gameLost = true; }
}
