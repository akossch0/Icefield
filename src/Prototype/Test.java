package Prototype;

import ClothesEquipped.NoClothesEquipped;
import ClothesEquipped.SwimsuitEquipped;
import Coverable.IglooCover;
import Coverable.NoCover;
import Coverable.TentCover;
import Field.*;

import Game.*;
import Item.*;
import Player.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

import static Game.Manager.playerInWaterAndNotFirstTurn;

public class Test {
    private String content;
    private String expectedOutput;
    private String name;
    private HashMap<String, Object> actors;
    private List<String> keys = new ArrayList<>();
    private Player currentPlayer;
    private String outputOfSave = "";
    public Test(String n, String con, String outCon){
        name = n;
        content = con;
        expectedOutput = outCon;
        actors = new HashMap<String,Object>();
    }

    public HashMap<String, Object> getActors() {
        return actors;
    }

    public String getName(){
        return name;
    }

    public void interpretLine(String line) throws Exception {
        // Minden whitespacet ki akarunk venni hogy lehessen tabolni a tesztekben
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
                addNeighbours(command[1], command[2]);
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
                break; // Eddig nagyjából fasza
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
                    List<String> fieldList = new ArrayList();
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
                playerInWaterAndNotFirstTurn();
                currentPlayer = (Player)actors.get(command[1]);
                if(currentPlayer.getActualWorkUnit() != 4)
                    currentPlayer.setActualWorkUnit(4);
                break;
            case "END":
                currentPlayer = null;
                break;
            case "LOAD":
                //??
                if(command.length == 1){
                    Game.getInstance().InitMap();
                }else if(command.length == 2){
                    load(command[1]);
                }else{
                    System.out.println("Wrong arguments given!");
                }
                break;
            case "SAVE":
                //??
                save(command);
                //System.out.println(outputOfSave);
                break;
        }
    }

    public void createPolarBear(String field){
        PolarBear.getInstance().setField((Field)actors.get(field));
        actors.putIfAbsent("PolarBear",PolarBear.getInstance());
        if(!keys.contains("PolarBear"))
            keys.add("PolarBear");
    }
    public void ExecuteTest() throws Exception {
        Manager.getInstance().Reset();
        Game.getInstance().Reset();
        Weather.getInstance().Reset();
        actors = new HashMap<>();
        keys = new ArrayList<>();
        currentPlayer = null;
        outputOfSave = "";
        System.out.println(content);
        Player currentPlayer = null;
        // haha cocaine lines
        String[] lines = this.content.split("\n");
        for (String line : lines) {
            //System.out.println(line);
            interpretLine(line);
        }
        compareOutputs(expectedOutput,outputOfSave);
    }

    private void newField(String id, String limit, String snow, String open) {
            IceBlock iceblock = new IceBlock();
            iceblock.setCapacity(Integer.parseInt(limit));
            iceblock.setLayerOfSnow(Integer.parseInt(snow));
            iceblock.setIsOpen(open.equals("i"));
            actors.put(id, iceblock);
            if (!keys.contains(id))
                keys.add(id);

    }
    private void newField(String id){
            Hole hole = new Hole();
            actors.put(id, hole);
            if(!keys.contains(id))
                keys.add(id);
    }

    private void addNeighbours(String field1, String field2){
        Field f1 = (Field)actors.get(field1);
        Field f2 = (Field)actors.get(field2);
        f1.AddNeighbour(f2);
        f2.AddNeighbour(f1);
    }

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
                actors.put(itemId, new WinningItem());
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

    private void build(String fieldId, String type){
        if (type.equals("tentcover")){
            ((Field)actors.get(fieldId)).Cover(new TentCover());
        }
        else if (type.equals("igloocover")){
            ((Field)actors.get(fieldId)).Cover(new IglooCover());
        }
        else if (type.equals("nocover")){
            ((Field)actors.get(fieldId)).Cover(new NoCover());
        }
    }

    private void wear(String playerId, String type){
        if (type.equals("swimsuitequipped")){
            ((Player)actors.get(playerId)).setClothes(new SwimsuitEquipped());
        }
        else if (type.equals("noclothesequipped")){
            ((Player)actors.get(playerId)).setClothes(new NoClothesEquipped());
        }
    }

    private void step(String targetId){
        //System.out.println(targetId);
        Field targetField = (Field)actors.get(targetId);
        currentPlayer.Step(targetField);
    }

    private void use_item(String itemId, String targetId){
        Item item = (Item)actors.get(itemId);
        Player target = (Player)actors.get(targetId);
        item.Use(target);
    }

    private void dig(){
        currentPlayer.Dig();
    }

    private void pickup(){
        currentPlayer.PickUpItem();
    }

    private void use_ability(String targetId) {
        currentPlayer.UseAbility((Field)actors.get(targetId));
    }

    // Ez it kicsit nagyon rossz
    private void blizzard( List<String> fieldIds){
        if (fieldIds == null){
           Weather.getInstance().yourTurn();
        }
        else{
            List<Field> list = new ArrayList<>();

            for (String s: fieldIds){
                list.add((Field)actors.get(s));
            }
            Weather.getInstance().Blizzard(list);
        }
    }

    private void polarstep(String direction) {
        if (direction == null){
            // ??
            PolarBear.getInstance().yourTurn();
        }
        else {

            PolarBear.getInstance().Step((Field)actors.get(direction));
        }
    }

    private  void load(String path){
        File in = new File(path);
        if(in.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(in));

                String line;
                String res = "";
                while ((line = br.readLine()) != null) {
                    res = res + line;
                }
                //mi legyen az output?
                content = res;
                expectedOutput = "";
                ExecuteTest();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("The path given does not represent a file.");
        }
    }

    private void save(String[] command){
        if(command.length == 1){
            for(String str : keys){
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
                }else {
                    if(Game.isGameLost()){
                        if(outputOfSave.equals(""))
                            outputOfSave = outputOfSave + "GAME LOST";
                        else
                            outputOfSave = outputOfSave + "\nGAME LOST";
                    }else {
                        if(outputOfSave.equals(""))
                            outputOfSave = outputOfSave + "GAME WON";
                        else
                            outputOfSave = outputOfSave + "\nGAME WON";
                    }
                }
            }else{
                if(outputOfSave.equals(""))
                    outputOfSave = outputOfSave + ((OutputToString)actors.get(command[1])).toString(actors);
                else
                    outputOfSave = outputOfSave + "\n" + ((OutputToString)actors.get(command[1])).toString(actors);
            }
        }
    }

    public static String getKeyByValue(HashMap<String, Object> map, Object value) {
        for (HashMap.Entry<String, Object> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean compareOutputs(String expected, String actual){
        String[] exp = expected.split("\n");
        String[] act = actual.split("\n");
        System.out.println("EXPECTED:\n" + expected);
        System.out.println("ACTUAL:\n" + actual);
        for(int i = 0; i < act.length; i++){
            act[i] = act[i].replaceAll("\\s","");
            exp[i] = exp[i].replaceAll("\\s","");
            if(!act[i].equals(exp[i])){
                System.out.println("ERROR:\nactual:\n" + act[i] + "\nexpected:\n" + exp[i]);
                return false;
            }
        }
        System.out.println("NICE JOB GAYLORD!");
        return true;
    }
}