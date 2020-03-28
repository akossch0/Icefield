package Skeleton;



import Coverable.*;
import Field.*;
import Game.Manager;
import Game.Weather;
import Item.*;
import Player.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Skeleton {

    private static boolean questionResult;

    public static boolean getQuestionresult(){
        return questionResult;
    }

    static int n = 0;
    static HashMap<Object,String> names = new HashMap<>();
    static boolean TestStarted = false;

    public static void addNames(Object o, String str){
        names.put(o,str);
    }

    public static void Called(Object object,String FuncHeader){
        if (TestStarted) {
            for (int i = 0; i < n; i++) System.out.print("\t");
            System.out.println(names.get(object) + "." + FuncHeader + "()");
            n++;
        }
    }

    public static void Return(){
        if(TestStarted)
            n--;
    }

    public static boolean Question(String str){
        String input;

        System.out.println(str);

        BufferedReader obj = new BufferedReader(new InputStreamReader((System.in)));
        try{input = obj.readLine();
            switch(input.charAt(0)) {
                case 'y':
                    questionResult = true;
                case 'Y':
                    questionResult = true;
                case 'n':
                    questionResult = false;
                case 'N':
                    questionResult = false;
                default:
                    questionResult = false;
            }
        }catch (Exception e){
            System.out.print("Input Failed");

        }
        return false;
    }

    public static void Run(){

        int numberOfUsecase = -1;

        do{
            try{
                System.out.print("Give the number of the use-case you'd like to see: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                numberOfUsecase = Integer.parseInt(s);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            switch (numberOfUsecase) {
                case (0): /*kilepunk a programbol*/ System.out.println("Bye!");
                    break;
                case (1): System.out.println("Kötél használata:");
                    Skeleton.TestUseRope();
                    break;
                case (2): System.out.println("Ásó használat:");
                    Skeleton.TestUseSpade();
                    break;
                case (3): System.out.println("Étel evése:");
                    Skeleton.EatFood();
                    break;
                case (4): System.out.println("Kutató kutatása:");
                    Skeleton.ResearcherUseAbility();
                    break;
                case (5): System.out.println("Búvárruha használata:");
                    Skeleton.UseSwimsuit();
                    break;
                case (6): System.out.println("Hóvihar mezőt sújt:");
                    Skeleton.TestBlizzard();
                    break;
                case (7): System.out.println("Játékos lyukra lép:");
                    Skeleton.PlayerStepsOnHole();
                    break;
                case (8): System.out.println("Játékos kézzel ás havat:");
                    Skeleton.PlayerShovelsSnowWithHand();
                    break;
                case (9): System.out.println("Játékos jégtáblára lép:");
                    Skeleton.PlayerStepsOnIceblock();
                    break;
                //... ahány use-case annyi eset lesz

                //ha invalid az ertek
                default:
                    System.out.println("Wrong input given when choosing from numbers!");
                    break;
            }
        }while(numberOfUsecase != 0);
    }


    //Új függvény létrehozáshoz ezt másoljátok és írjátok át így nem felejtetek el valamit
    public void Temp(){
        //Inicializálás
        //Ide a szükséges objektumok
        Player player = new Eskimo();
        Player target = new Researcher();
        Item rope = new Rope();
        Field field = new IceBlock();
        Field hole = new Hole();

        //Hash feltöltése
        names.put(player,"EskimoPlayer");
        names.put(target,"ResearcherTarget");
        names.put(rope,"RopeItem");
        names.put(field,"IceblockField");
        names.put(hole,"HoleField");


        //Objektumok beállítása
        target.setField(hole);
        player.setField(field);
        player.AcceptItem(rope);
        //Test indítása
        TestStarted = true;

        //szekvencia kezdőfüggvény függvény elindítása
        player.UseItem(rope,target);
        //Test leállítása
        TestStarted = false;

        //Hash ürítése
        names.clear();
    }



    public static void TestUseRope(){
        Player player = new Eskimo();
        Player target = new Researcher();
        Item rope = new Rope();
        Field field = new IceBlock();
        Field hole = new Hole();

        names.put(player,"EskimoPlayer");
        names.put(target,"ResearcherTarget");
        names.put(rope,"RopeItem");
        names.put(field,"IceblockField");
        names.put(hole,"HoleField");

        target.setField(hole);
        player.setField(field);
        player.AcceptItem(rope);

        TestStarted = true;

        player.UseItem(rope,target);

        TestStarted = false;
        names.clear();
    }

    public static void EatFood(){
        Player player = new Eskimo();
        Item food = new Food();

        names.put(player,"EskimoPlayer");
        names.put(food, "FoodItem");

        TestStarted = true;

        player.UseItem(food, player);

        TestStarted = false;
        names.clear();
    }

    public static void TestUseSpade(){
        Player player = new Eskimo();
        Item spade = new Spade();
        Field field = new IceBlock();

        names.put(player,"SpadeUserEskimo");
        names.put(spade,"Spade");
        names.put(field,"Field");

        player.AcceptItem(spade);
        player.setField(field);

        TestStarted = true;

        player.UseItem(spade, player);

        TestStarted = false;
        names.clear();
    }

    public static void ResearcherUseAbility(){
        Player player = new Researcher();
        Field field = new IceBlock();
        Field inspected = new IceBlock();

        names.put(player,"Researcher");
        names.put(field,"IceBlock");
        names.put(inspected,"InspectedIceBlock");

        player.setField(field);

        TestStarted = true;

        player.UseAbility(inspected);

        TestStarted = false;
        names.clear();
    }

    public static void TestBlizzard(){
        Manager m = new Manager();
        Weather w = new Weather();
        List<Field> fields = new ArrayList<Field>();
        for (int i = 0; i < 3; i++){
            Field f = new IceBlock();
            Player p = new Eskimo();
            Player pp = new Researcher();
            p.setField(f);
            pp.setField(f);
            Coverable cov = new NoGloo();
            f.Gloo(cov);
            names.put(pp,"Researcher" + ((Integer)i).toString());
            names.put(p,"Eskimop" + ((Integer)i).toString());
            names.put(f,"Iceblock" + ((Integer)i).toString());
            names.put(cov, "NoGloo");

            fields.add(f);
        }
        w.add(fields);
        names.put(m, "Manager");
        names.put(w, "Weather");

        TestStarted = true;

        w.Blizzard();

        TestStarted = false;
        names.clear();


    }

    public static void PlayerStepsOnHole(){
        Player eskimo = new Eskimo();
        Field currentfield = new IceBlock();
        Field hole  = new Hole();

        names.put(eskimo, "EskimoPlayer");
        names.put(currentfield, "CurrentFiled");
        names.put(hole, "Hole");

        eskimo.setField(currentfield);

        TestStarted = true;

        eskimo.Step(hole);

        TestStarted = false;
        names.clear();
    }
    public static void PlayerStepsOnIceblock(){
        Player eskimo = new Eskimo();
        Field currentfield = new IceBlock();
        Field nextField  = new IceBlock();

        eskimo.setField(currentfield);


        names.put(eskimo, "EskimoPlayer");
        names.put(currentfield, "CurrentIceblock");
        names.put(nextField, "NeighbourIceblock");

        TestStarted = true;

        Question("Átforduljon a jégtábla a rálépéssel?(Y/N)");

        eskimo.Step(nextField);

        TestStarted = false;
        names.clear();
    }

    public static void PlayerShovelsSnowWithHand(){
        Player eskimo = new Eskimo();
        Field currentfield = new IceBlock();

        names.put(eskimo, "EskimoPlayer");
        names.put(currentfield, "CurrentFiled");

        eskimo.setField(currentfield);

        TestStarted = true;

        eskimo.Dig();

        TestStarted = false;
        names.clear();
    }

    public static void UseSwimsuit(){
        Player player = new Eskimo();
        Item sw = new Swimsuit();

        names.put(player, "EskimoPlayer");
        names.put(sw,"Swimsuit");

        TestStarted = true;

        player.UseItem(sw,player);

        TestStarted = false;
        names.clear();
    }

}
