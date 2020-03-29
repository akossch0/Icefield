package Skeleton;

import Coverable.*;
import Field.*;
import Game.Game;
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
    /**  Mutatja hogy mennyi indentalas kell kijelzesnel ami fontos mert ez jelzi a függvenyhivasok egymasbol valo torteneset **/
    static int n = 0;
    /** Nem akarjuk kiirni az initet szoval minden test elott ki es be kell kapcsolni **/
    static boolean TestStarted = false;
    /** Ebben taroljuk a testben reszt vevo objektumokat, minden test elott kitisztitjuk **/
    static HashMap<Object,String> names = new HashMap<>();


    /**
     * Minden test elejen erdemes meghivni
     * Biztositja hogy mindig jol legyenek regisztralva a manager meg a game
     */
    private static void initTest(){
        names.put(Manager.getInstance(), "Manager");

        names.put(Game.getInstance(), "Game");
    }

    /**
     * Az objektumok es nevek parositasa a megjeleniteshez
     * @param o az objektum, amihez a nevet tarsitjuk
     * @param str a nev amit tarsitunk az objektumhoz
     */
    public static void addNames(Object o, String str){
        names.put(o,str);
    }

    /**
     * ha egy fuggveny hivodik ez gondoskodik az indentalasrol
     * @param object amin a fuggveny hivodik
     * @param FuncHeader a fuggveny neve
     */
    public static void Called(Object object,String FuncHeader){
        if (TestStarted) {
            for (int i = 0; i < n; i++) System.out.print("\t");
            System.out.println(names.get(object) + "." + FuncHeader + "()");
            n++;
        }
    }

    /**
     * fuggveny visszateresekor, indentalas miatt kell
     */
    public static void Return(){
        if(TestStarted)
            n--;
    }

    /**
     * eldontendo kerdesek feltevese
     * @param str a kerdes
     * @return igazsagerteke a valasznak
     */
    public static boolean Question(String str){
        String input;

        System.out.print(str);

        BufferedReader obj = new BufferedReader(new InputStreamReader((System.in)));
        try{input = obj.readLine();
            switch(input.charAt(0)) {
                case 'i':
                    return true;
                case 'I':
                    return true;
                case 'n':
                    return false;
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

    /**
     * A szkeleton program
     */
    public static void Run(){

        int numberOfUsecase = -1;

        String description = "\t\t\t Skeleton program\n" +
                "\tAdott use-case választásához gépelje be a hozzá tartozó sorszámot!\n" +
                "Use-case-ek:\n" +
                "1. Kötél használat\t\t\t\t" +
                "2. Ásó használat\n" +
                "3. Étel evés\t\t\t\t\t" +
                "4. Kutató kutat\n" +
                "5. Búvárruha használat\t\t\t\t" +
                "6. Hóvihar mezőt sújt\n" +
                "7. Játékos lyukra lép\t\t\t\t" +
                "8. Játékos kézzel ás havat\n" +
                "9. Játékos jégtáblára lép\t\t\t" +
                "10. Eszkimo iglut épít\n" +
                "11. Játékosnak elfogy a testhője\t\t" +
                "12. Játékos vízbe fullad\n" +
                "13. Játékos tárgyat vesz fel\t\t\t" +
                "14. Játékos WinningItem-et használ\n" +
                "\tKilépéshez gépelje be a '0' karaktert!\n";
        System.out.print(description);

        do{
            // kitisztitjuk minden teszt elott a hashmapot, hogy ne legyen teleszemetelve memoria
            names.clear();
            numberOfUsecase = -1;
            try{
                System.out.print("Adjon meg egy számot, amivel megegyező use-case-t szeretne látni: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                numberOfUsecase = Integer.parseInt(s);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            // initeli a testre a managert es a gamet, mivel singleton statikus osztalyok
            // minden teszt elott meg kell tenni mivel minden teszt elott tisztitjuk a hashmapet
            initTest();
            Game.setGameOver(false);
            switch (numberOfUsecase) {
                case (0): /*kilepunk a programbol*/ System.out.println("Viszlát!");
                    break;
                case (1): System.out.println("Kötél használat:");
                    Skeleton.UseRope();
                    break;
                case (2): System.out.println("Ásó használat:");
                    Skeleton.UseSpade();
                    break;
                case (3): System.out.println("Étel evés:");
                    Skeleton.EatFood();
                    break;
                case (4): System.out.println("Kutató kutat:");
                    Skeleton.ResearcherUseAbility();
                    break;
                case (5): System.out.println("Búvárruha használat:");
                    Skeleton.UseSwimsuit();
                    break;
                case (6): System.out.println("Hóvihar mezőt sújt:");
                    Skeleton.Blizzard();
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
                case (10): System.out.println("Eszkimo iglut épít:");
                    Skeleton.EskimoUseAbility();
                    break;
                case (11): System.out.println("Játékosnak elfogy a testhője:");
                    Skeleton.PlayerOutOfHealth();
                    break;
                case (12): System.out.println("Játékos vízbe fullad:");
                    Skeleton.PlayerDrown();
                    break;
                case (13): System.out.println("Játékos tárgyat vesz fel:");
                    Skeleton.PlayerPickUpItem();
                    break;
                case (14): System.out.println("Játékos WinningItem-et használ:");
                    Skeleton.PlayerUseWinningItem();
                    break;

                default:
                    System.out.println("Rossz inputot adott meg!");
                    break;
            }

        }while(numberOfUsecase != 0);
    }

    /**
     * Játékos WinningItem-et használ
     */
    public static void PlayerUseWinningItem(){
        Player player = new Eskimo();
        Item i = new WinningItem();

        names.put(player, "EskimoPlayer");
        names.put(i, "WinningItem");

        player.AcceptItem(i);

        TestStarted = true;

        player.UseItem(i, player);

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     * Játékos vízbe fullad
     */
    public static void PlayerDrown(){
        Player player = new Eskimo();

        names.put(player,"EskimoPlayer");

        TestStarted = true;

        player.yourTurn();

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Osszes eletpont elvesztese
     */
    public static void PlayerOutOfHealth(){
        Player player = new Eskimo();

        names.put(player,"EskimoPlayer");

        TestStarted = true;

        player.DecrHp();

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Targy felvetele
     */
    public static void PlayerPickUpItem(){
        Player player = new Eskimo();
        IceBlock field = new IceBlock();
        Item item = new Rope();

        names.put(player, "EskimoPlayer");
        names.put(field, "IceBlockField");
        names.put(item, "RopeItem");

        field.setItem(item);
        player.setField(field);

        TestStarted = true;

        if(Question("<<A mezőn nincs egy hóréteg sem és nyitott a mező?(Igen/Nem)>> ")){
            player.PickUpItem();
        }

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Kotellel kimentes
     */
    public static void UseRope(){
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
        field.getPlayers().add(player);
        player.AcceptItem(rope);

        TestStarted = true;

        player.UseItem(rope,target);

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Etel eves
     */
    public static void EatFood(){
        Player player = new Eskimo();
        Item food = new Food();

        names.put(player,"EskimoPlayer");
        names.put(food, "FoodItem");

        TestStarted = true;

        player.UseItem(food, player);

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Lapat hasznalata
     */
    public static void UseSpade(){
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
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Kutato kutat
     */
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
    }

    /**
     *Eszkimo iglut epit
     */
    public static void EskimoUseAbility(){
        Player player = new Eskimo();
        Field field = new IceBlock();

        names.put(player,"Eskimo");
        names.put(field,"IceBlock");

        player.setField(field);

        TestStarted = true;

        player.UseAbility(field);

        TestStarted = false;
    }

    /**
     *Hovihar mezot sujt
     */
    public static void Blizzard(){
        Weather w = new Weather();
        List<Field> fields = new ArrayList<Field>();
        for (int i = 0; i < 3; i++){
            Field f = new IceBlock();
            Player p = new Eskimo();
            Player pp = new Researcher();
            p.setField(f);
            pp.setField(f);
            f.getPlayers().add(p);
            f.getPlayers().add(pp);
            Coverable cov = new NoGloo();
            f.Gloo(cov);
            names.put(pp, "Researcher" + ((Integer)i).toString());
            names.put(p, "Eskimop" + ((Integer)i).toString());
            names.put(f, "Iceblock" + ((Integer)i).toString());
            names.put(cov, "NoGloo");

            fields.add(f);
        }

        w.add(fields);
        names.put(w, "Weather");

        TestStarted = true;
        // Hovihar lesujt

        w.Blizzard();

        TestStarted = false;
    }

    /**
     *Lyukba lep a jatekos
     */
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
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Jegtablara lep a jatekos
     */
    public static void PlayerStepsOnIceblock(){
        Player eskimo = new Eskimo();
        Field currentfield = new IceBlock();
        Field nextField  = new IceBlock();

        Player p1 = new Researcher();
        Player p2 = new Eskimo();

        p1.setField(nextField);
        p2.setField(nextField);
        nextField.getPlayers().add(p1);
        nextField.getPlayers().add(p2);

        eskimo.setField(currentfield);


        names.put(eskimo, "EskimoPlayer");
        names.put(currentfield, "CurrentIceblock");
        names.put(nextField, "NeighbourIceblock");

        names.put(p1,"PlayerOnIceblock1");
        names.put(p2,"PlayerOnIceblock2");

        TestStarted = true;

        eskimo.Step(nextField);

        TestStarted = false;
        names.clear();
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     *Kezzel as havat a jatekos
     */
    public static void PlayerShovelsSnowWithHand(){
        Player eskimo = new Eskimo();
        Field currentfield = new IceBlock();

        names.put(eskimo, "EskimoPlayer");
        names.put(currentfield, "CurrentFiled");

        eskimo.setField(currentfield);

        TestStarted = true;

        eskimo.Dig();

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

    /**
     * Buvarruha hasznalata
     */
    public static void UseSwimsuit(){
        Player player = new Eskimo();
        Item sw = new Swimsuit();

        names.put(player, "EskimoPlayer");
        names.put(sw, "Swimsuit");

        TestStarted = true;

        player.UseItem(sw,player);

        TestStarted = false;
        System.out.println("\nA működést Eszkimóra mutattuk be, de ugyan ez fog történni Sarkkutató esetén is.\n");
    }

}
