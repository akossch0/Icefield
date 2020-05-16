package Prototype;

import ClothesEquipped.*;
import Coverable.*;
import Field.*;
import Game.*;
import Item.*;
import Player.*;

import java.io.*;
import java.util.*;

import static Game.Manager.TurnPassed;

/**
 * A tesztelest vegrehajto osztaly
 */
public class Test {
    private String content;
    private String expectedOutput;
    private String name;
    private HashMap<String, Object> actors;
    private List<String> keys = new ArrayList<>();
    private HashMap<String, String> objects = new HashMap<>();
    private Player currentPlayer;
    private String outputOfSave = "";
    private boolean testing;
    private boolean all = false;
    private int ID = 0;
    public Test(String n, String con, String outCon, boolean t){
        name = n;
        content = con;
        expectedOutput = outCon;
        actors = new HashMap<String,Object>();
        testing = t;
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public String getName(){
        return name;
    }

    /**
     * Ertelmezi a kapott stringet es utasitast keszit belole, meghivja a megfelelo utasitast vegzo fuggvenyt
     */
    public void interpretLine(String line) throws Exception {
        try
        {
            String[] command = line.split("\\s+");
            if (command.length == 0)
                throw new Exception("Valami igencsak rossz:((");
            String first = command[0];
            switch (first) {
                case "field":
                    if(command[2].equals("iceblock"))
                        newField(command[1], command[3], command[4], command[5]);
                    else
                        newField(command[1]);
                    break;
                case "neighbours":
                    // addNeighbours(command[1], command[2]);
                    break;
                case "player":
                    newPlayer(command[1], command[2], command[3]);
                    break;
                case "polarbear":
                    createPolarBear(command[1]);
                    break;
                case "placeitem":
                    placeItem(command[1], command[2]);
                    break;
                case "item":
                    if (command.length == 4)
                        newItem(command[1], command[2], command[3]);
                    else
                        newItem(command[1], command[2], "-1");
                    break;
                case "build":
                    build(command[1], command[2]);
                    break;
                case "wear":
                    wear( command[1], command[2]);
                    break;
                case "STEP":
                    step(command[1]);
                    break;
                case "USE_ITEM":
                    use_item(command[1], command[2]);
                    break;
                case "USE_ABILITY":
                    use_ability(command[1]);
                    break;
                case "DIG":
                    dig();
                    break;
                case "PICKUP":
                    pickup();
                    break;
                case "BLIZZARD":
                    if (command.length > 1) {
                        List<String> fieldList = new ArrayList<String>();
                        for (int i = 1; i < command.length; i++) {
                            fieldList.add(command[i]);
                        }
                        blizzard(fieldList);
                    }
                    else
                        blizzard(null);
                    break;
                case "POLARSTEP":
                    if (command.length > 1) {
                        polarstep(command[1]);
                    }
                    else
                        polarstep(null);
                    break;
                case "BEGIN":
                    TurnPassed();
                    currentPlayer = (Player)actors.get(command[1]);
                    if(currentPlayer.getActualWorkUnit() != 4)
                        currentPlayer.setActualWorkUnit(4);
                    break;
                case "END":
                    currentPlayer = null;
                    break;
                case "LOAD":
                    if(command.length == 1){
                        List<Object> newObjects = Game.getInstance().InitMap();
                        for(Object o: newObjects){
                            actors.put(o.toString()+"_"+String.valueOf(ID),o);
                            keys.add(o.toString()+"_"+ String.valueOf(ID));
                            ID = ID+1;
                        }
                    }else if(command.length == 2){
                    load(command[1]);
                }else{
                    System.out.println("Wrong arguments given!");
                }
                    break;
                case "SAVE":
                    save(command);
                    if(!testing && !all)
                        if(command.length == 1)
                            printOutput();
                        else
                            System.out.println(objects.get(command[1]));
                    break;
                case "exit":
                    break;
                default:
                    if(!testing)
                        System.out.println("'" + command[0] + "' parancs nem volt ertelmezheto!");
                    break;
                }
        }catch(Exception e){System.out.println("Rossz volt a parancs parameterezes.");}

    }

    /**
     * Jegesmedvet hoz letre
     * @param field a mezo, ahol a jegesmedve tartozkodni fog
     */
    public void createPolarBear(String field){
        PolarBear.getInstance().setField((Field)actors.get(field));
        actors.putIfAbsent("PolarBear",PolarBear.getInstance());
        if(!keys.contains("PolarBear"))
            keys.add("PolarBear");
    }

    /**
     * Prancsertelmezo
     * A paracsokat soronkent ertelmzi
     */
    public boolean ExecuteTest() throws Exception {
        Manager.getInstance().Reset();
        Game.getInstance().Reset();
        Weather.getInstance().Reset();
        actors = new HashMap<>();
        keys = new ArrayList<>();
        currentPlayer = null;
        outputOfSave = "";
        String[] lines = this.content.split("\n");
        for (String line : lines) {
            try{
            interpretLine(line);}
            catch (Exception e){
                System.out.println("Rossz volt a parancs.");
            }
        }
        if(testing)
            return compareOutputs(expectedOutput,outputOfSave);
        else
            return true;
    }

    /**
     * Uj mezot keszit, ami egy jegtabla
     * @param id a jegtabla azonositoja lesz
     * @param limit a jegtabla kapacitasat adja meg
     * @param snow a jegtablan levo horetegek szamat adja
     * @param open megadja hogy nyitott e a jegtabla
     */
    private void newField(String id, String limit, String snow, String open) {
            IceBlock iceblock = new IceBlock();
            iceblock.setCapacity(Integer.parseInt(limit));
            iceblock.setLayerOfSnow(Integer.parseInt(snow));
            iceblock.setIsOpen(open.equals("i"));
            actors.put(id, iceblock);
            if (!keys.contains(id))
                keys.add(id);

    }

    /**
     * Uj mezot keszit, ami eredendoen egy lyuk,
     * @param id ez fogja azonositani a mezot
     */
    private void newField(String id){
            Hole hole = new Hole();
            actors.put(id, hole);
            if(!keys.contains(id))
                keys.add(id);
    }

    /**
     * Szomszedokat ad hozza a mezokhoz
     * @param field1 ennek a mezonek a field2 lesz a szomszedja
     * @param field2 ennek a mezonek a field1 lesz a szomszedja
     */
    /**private void addNeighbours(String field1, String field2){
        Field f1 = (Field)actors.get(field1);
        Field f2 = (Field)actors.get(field2);
        f1.AddNeighbour(f2);
        f2.AddNeighbour(f1);
    }*/

    /**
     * Uj jatekost ad hozza
     * @param Id ez lesz a jatekos azonositoja
     * @param type a tipusa
     * @param fieldId erre a mezore fog a jatekos kerulni
     */
    private void newPlayer( String Id, String type, String fieldId){

        if (type.equals("eskimo")){
            Eskimo eskimo = new Eskimo((Field)actors.get(fieldId));

            actors.put(Id, eskimo);
            if(!keys.contains(Id))
                keys.add(Id);
        }
        else{
            Researcher researcher = new Researcher((Field)actors.get(fieldId));
            actors.put(Id, researcher);
            if(!keys.contains(Id))
                keys.add(Id);
        }
    }

    /**
     * Elhelyez egy targyat valahol vagy valakinel
     * @param itemId a targy amit el fog helyezni
     * @param targetId ide helyezi el
     */
    private void placeItem(String itemId, String targetId){
        Object target = actors.get(targetId);
        Item item = (Item)actors.get(itemId);
        if (target instanceof Player){
            Player player = (Player)target;
            player.AcceptItem(item);
        }
        else if (target instanceof Field){
            Field field = (Field)target;
            field.setItem(item);
        }
    }

    /**
     * Uj targyat hoz letre
     * @param itemId ez lesz a targy azonositoja
     * @param type ilyen fajta lesz a targy
     * @param durability maradek hasznalhatósag
     */
    private void newItem(String itemId, String type, String durability){
        type = type.toLowerCase();
        if(!keys.contains(itemId))
            keys.add(itemId);
        switch (type){
            case "spade":
                Spade spade = new Spade(3);
                actors.put(itemId, spade);
                break;
            case "food":
                actors.put(itemId, new Food());
                break;
            case "winningitem":
                actors.put(itemId, new WinningItem(1));
                break;
            case "tent":
                actors.put(itemId, new Tent());
                break;
            case "swimsuit":
                actors.put(itemId, new Swimsuit());
                break;
            case "rope":
                actors.put(itemId, new Rope());
                break;
        }
    }

    /**
     * Iglut epit vagy satra vagy uresse teszi a mezot
     * @param fieldId a mezo azonositoja
     * @param type az epitendo iglu vagy sator vagy ures mezo fajtaja
     */
    private void build(String fieldId, String type){
        switch (type) {
            case "tentcover":
                ((Field) actors.get(fieldId)).Cover(new TentCover());
                break;
            case "igloocover":
                ((Field) actors.get(fieldId)).Cover(new IglooCover());
                break;
            case "nocover":
                ((Field) actors.get(fieldId)).Cover(new NoCover());
                break;
        }
    }

    /**
     * Jatekost tud felruhazni buvarruhaval vagy levetkoztetni
     * @param playerId a jatekos azonositoja
     * @param type vagy buvarruha vagy az hogy ne legyen a jatekoson ruha
     */
    private void wear(String playerId, String type){
        if (type.equals("swimsuitequipped")){
            ((Player)actors.get(playerId)).setClothes(new SwimsuitEquipped());
        }
        else if (type.equals("noclothesequipped")){
            ((Player)actors.get(playerId)).setClothes(new NoClothesEquipped());
        }
    }

    /**
     * A jelenlegi jatekos lepese
     * @param targetId ide fog lepni a jatekos
     */
    private void step(String targetId){
        Field targetField = (Field)actors.get(targetId);
        currentPlayer.Step(targetField);
    }

    /**
     * Targy hasznalat
     * @param itemId a targy amit hasznalva lesz
     * @param targetId o a celpont akire hasznalva lesz
     */
    private void use_item(String itemId, String targetId){
        Item item = (Item)actors.get(itemId);
        Player target = (Player)actors.get(targetId);
        item.Use(target);
    }

    /**
     * A jelenlegi jatekos asasa
     */
    private void dig(){
        currentPlayer.Dig();
    }

    /**
     * A jelenlegi jatekos felvesz egy targyat
     */
    private void pickup(){
        currentPlayer.PickUpItem();
    }

    /**
     * A jelenlegei jatekos kepessegenek hasznalata
     * @param targetId a velpont amire hasznalni fogja
     */
    private void use_ability(String targetId) {
        currentPlayer.UseAbility((Field)actors.get(targetId));
    }

    /**
     * Hovihat valosit meg
     * @param fieldIds ezeken a mezokon lesz a hovihar
     */
    private void blizzard( List<String> fieldIds){
        if (fieldIds == null)
           Weather.getInstance().yourTurn();
        else{
            List<Field> list = new ArrayList<>();

            for (String s: fieldIds){
                list.add((Field)actors.get(s));
            }
            Weather.getInstance().Blizzard(list);
        }
    }

    /**
     * A jegesmedve lepese
     * @param direction ebbe az iranyba
     */
    private void polarstep(String direction) {
        if (direction == null)
            PolarBear.getInstance().yourTurn();
        else
            PolarBear.getInstance().Step((Field)actors.get(direction));
    }

    /**
     * Fajbol olvas be sorokat es vegrehajtaja oket
     * @param path a fajt eleresi utvonala
     */
    private void load(String path){
        File in = new File(path);
        if(in.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(in));

                String line;
                StringBuilder res = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    res.append(line).append("\n");
                }
                br.close();
                content = res.toString();
                expectedOutput = "";
                ExecuteTest();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("The path given does not represent a file.");
        }
    }

    /**
     * Elmenti az utasitast a megfelelo helyre
     * @param command ezt az utasitast kell elmenteni
     */
    private void save(String[] command){
        if(command.length == 1){
            for(String str : keys){
                objects.put(str, ((OutputToString)actors.get(str)).toString(actors));
                outputOfSave = outputOfSave + ((OutputToString)actors.get(str)).toString(actors) + "\n";
            }
        }else if(command.length == 2){
            if(command[1].equals("GAMESTATE")){
                Game.getInstance();
                if(!Game.isGameWon() && !Game.isGameLost()){
                    if(outputOfSave.equals(""))
                        outputOfSave = outputOfSave + "GAME IN PROGRESS";
                    else
                        outputOfSave = outputOfSave + "\nGAME IN PROGRESS";
                    objects.put("progress","GAME IN PROGRESS");
                }else {
                    if(Game.isGameLost()){
                        if(outputOfSave.equals(""))
                            outputOfSave = outputOfSave + "GAME LOST";
                        else
                            outputOfSave = outputOfSave + "\nGAME LOST";
                        objects.put("lost","GAME LOST");
                    }else {
                        if(outputOfSave.equals(""))
                            outputOfSave = outputOfSave + "GAME WON";
                        else
                            outputOfSave = outputOfSave + "\nGAME WON";
                        objects.put("won","GAME WON");
                    }
                }
            }else{
                if(outputOfSave.equals(""))
                    outputOfSave = outputOfSave + ((OutputToString)actors.get(command[1])).toString(actors);
                else
                    outputOfSave = outputOfSave + "\n" + ((OutputToString)actors.get(command[1])).toString(actors);
                objects.put(command[1],((OutputToString)actors.get(command[1])).toString(actors));
            }
        }
    }

    /**
     * A teszt kimenetet listazza ki a konzolra
     */
    public void printOutput(){
        for(String o : objects.keySet())
            System.out.println(objects.get(o));
    }

    /**
     * Ertek alapja kulcsot ad vissza
     * @param map itt fog keresni
     * @param value ez alapjan az ertek alapjan
     * @return a kulcs
     */
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Osszehasonlitja a megadott kimeneteket
     * @param expected elvart kimenet
     * @param actual valodi kimenet
     * @return igazzal vagy hamissal ter vissza
     */
    public boolean compareOutputs(String expected, String actual){
        String[] exp = expected.split("\n");
        String[] act = actual.split("\n");
        boolean res = true;
        for(int i = 0; i < act.length; i++){
            act[i] = act[i].replaceAll("\\s","");
            exp[i] = exp[i].replaceAll("\\s","");
            if(!act[i].equals(exp[i])){
                System.out.println("ERROR:\nactual:\n\t" + act[i] + "\nexpected:\n\t" + exp[i]);
                res = false;
            }
        }
        if(testing && !all && res)
            System.out.println("Test succeeded!");
        if(testing && !all && !res)
            System.out.println("Test failed!");
        return res;
    }
}