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

    public static void Called(Object object,String FuncHeader){
        if (TestStarted) {
            for (int i = 0; i < n; i++) System.out.print("\t");
            System.out.println(names.get(object) + ":" + FuncHeader + "()");
            n++;
        }
    }

    public static void Return(){
        if(TestStarted)
            n--;
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
                case (1): /*A skeleton 1-es usecase-re vonatkozo metodusa*/ System.out.println("1st use-case: ...");
                    Skeleton.TestUseRope();
                    break;
                case (2): System.out.println("2nd use-case: ...");
                    Skeleton.TestUseSpade();
                    break;
                case (3): System.out.println("3rd use-case: ...");
                    break;
                //... ahány use-case annyi eset lesz

                //ha invalid az ertek
                default:
                    System.out.println("Wrong input given when choosing from numbers!");
                    break;
            }
        }while(numberOfUsecase != 0);
    }

    public static void EatFood(){
        Player player = new Eskimo();
        Item food = new Food();

        names.put(player,"EskimoPlayer");
        names.put(food, "FoodItem");

        TestStarted = true;

        food.Use(player);

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



}
