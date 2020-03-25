package Skeleton;



import Item.*;
import Player.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Skeleton {
    static int n = 0;
    static HashMap<Object,String> names;
    public static void Initialise(){
        names = new HashMap<>();
        names.put(Rope.class,"Rope");
        names.put(Item.class,"Item");
    }
    public static void Called(Object object,String FuncHeader){
        for (int i = 0;i<n;i++) System.out.print("\t");
        System.out.println(names.get(object)+" "+FuncHeader);
        n++;
    }

    public static void Return(){
        n--;
    }

    public static void Test1(){
        Player player = new Eskimo();
        Player target = new Researcher();
        Item rope = new Rope();
        player.AcceptItem(rope);
        try {
            Runtime.getRuntime().exec("cls");
        }catch(Exception e){ }

        player.UseItem(rope,target);
    }
    public static void Question(){
        String input;

        BufferedReader obj = new BufferedReader(new InputStreamReader((System.in)));
        /*    Majd még ki kell egészíteni*/

    }

}
