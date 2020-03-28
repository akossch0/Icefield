package Skeleton;



import Field.*;
import Item.*;
import Player.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Skeleton {
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

    public static boolean Question(){
        String input;

        BufferedReader obj = new BufferedReader(new InputStreamReader((System.in)));
        try{input = obj.readLine();
            switch(input.charAt(0)) {
                case 'y':
                case 'Y':
                    return true;
                case 'n':
                case 'N':
                    return false;
                default:
                    return false;
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
                case (5): System.out.println("Búvárruha használat:");
                    Skeleton.UseSwimsuit();
                    break;
                //... ahány use-case annyi eset lesz

                //ha invalid az ertek
                default:
                    System.out.println("Wrong input given when choosing from numbers!");
                    break;
            }
        }while(numberOfUsecase != 0);
    }

    public static void TestUseRope(){
        Player player = new Eskimo();
        Player target = new Researcher();
        Item rope = new Rope();
        Field mezo = new IceBlock();

        names.put(player,"EskimoPlayer");
        names.put(target,"ResearcherTarget");
        names.put(rope,"RopeItem");

        player.AcceptItem(rope);
        player.Step(mezo);


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
        player.Step(field);

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

        player.Step(field);

        TestStarted = true;

        player.UseAbility(inspected);

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
