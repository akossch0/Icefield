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

public class Test {
    private String content;
    private String outputContent;
    private String name;

    public Test(String n, String con, String outCon){
        name = n;
        content = con;
        outputContent = outCon;
    }

    public String getOutputContent() {
        return outputContent;
    }

    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public static void ExecuteTest(String input, String output) throws Exception {

        HashMap<String, Object> actors = new HashMap<>();
        Player currentPlayer = null;
        // haha cocaine lines
        String[] lines = input.split("\n");
        for (String s : lines) {
            // Minden whitespacet ki akarunk venni hogy lehessen tabolni a tesztekben
            String[] command = s.split("\\s+");
            if (command.length == 0)
                throw new Exception("Valami igencsak rossz:((");
            String first = command[0];
            switch (first) {
                case "field":
                    newField(actors, command[1], command[2], command[3], command[4], command[5]);
                    break;
                case "neighbours":
                    addNeighbours(actors, command[1], command[2]);
                    break;
                case "player":
                    newPlayer(actors, command[1], command[2], command[3]);
                    break;
                case "placeitem":
                    placeItem(actors, command[1], command[2]);
                    break;
                case "item":
                    if (command.length == 4)
                        newItem(actors, command[1], command[2], command[3]);
                    else
                        newItem(actors, command[1], command[2], "-1");
                    break;
                case "build":
                    build(actors, command[1], command[2]);
                    break;
                case "wear":
                    wear(actors, command[1], command[2]);
                    break; // Eddig nagyjából fasza
                case "STEP":
                    step(actors, currentPlayer, command[1]);
                    break;
                case "USE_ITEM":
                    use_item(actors,currentPlayer, command[1], command[2]);
                    break;
                case "USE_ABILITY":
                    use_ability(actors,currentPlayer, command[1]);
                    break;
                case "DIG":
                    dig(actors,currentPlayer);
                    break;
                case "PICKUP":
                    pickup(actors, currentPlayer);
                    break;
                case "BLIZZARD":
                    if (command.length > 1) {
                        List<String> fieldList = new ArrayList();
                        for (int i = 1; i < command.length; i++) {
                            fieldList.add(command[i]);
                        }
                        blizzard(actors, fieldList);
                    }
                    else
                        blizzard(actors, null);
                    break;
                case "POLARSTEP":
                    if (command.length > 1) {
                        polarstep(actors, command[1]);
                    }
                    else
                        polarstep(actors, null);
                    break;
                case "BEGIN":
                    currentPlayer = (Player)actors.get(command[1]);
                    break;
                case "END":
                    currentPlayer = null;
                    break;
                case "LOAD":
                    //??
                    if(command.length == 1){
                        Game.getInstance().InitMap();
                    }else if(command.length == 2){
                        load(actors,command[1]);
                    }else{
                        System.out.println("Wrong arguments given!");
                    }
                    break;
                case "SAVE":
                    //??
                    String outputOfSave = save(actors,command);
                    break;
            }
        }
    }

    private static void newField(HashMap map, String id, String type, String limit, String snow, String open){
        if (type.equals("iceblock")){
            IceBlock iceblock = new IceBlock();
            iceblock.setCapacity(Integer.parseInt(limit));
            iceblock.setLayerOfSnow(Integer.parseInt(snow));
            iceblock.setIsOpen(Boolean.parseBoolean(open));
            map.put(id, iceblock);
        }
        else{
            Hole hole = new Hole();
            map.put(id, hole);
        }
    }

    private static void addNeighbours(HashMap map, String field1, String field2){
        Field f1 = (Field)map.get(field1);
        Field f2 = (Field)map.get(field2);
        f1.AddNeighbour(f2);
        f2.AddNeighbour(f1);
    }

    private static void newPlayer(HashMap map, String Id, String type, String fieldId){
        if (type.equals("eskimo")){
            Eskimo eskimo = new Eskimo((Field)map.get(fieldId));
            map.put(Id, eskimo);
        }
        else{
            Researcher researcher = new Researcher((Field)map.get(fieldId));
            map.put(Id, researcher);
        }
    }

    private static void placeItem(HashMap map, String itemId, String targetId){
        Object target = map.get(targetId);
        if (target instanceof Player){
            Player player = (Player)target;
            player.AcceptItem((Item)map.get(itemId));
        }
        else if (target instanceof Field){
            Field field = (Field)target;
            field.setItem((Item)map.get(itemId));
        }
    }

    private static void newItem(HashMap map, String itemId, String type, String durability){
        switch (type){
            case "spade":
                Spade spade = new Spade();
                if (durability.equals("3")){
                    spade.setDurability(3);
                }
                map.put(itemId, spade);
                break;
            case "food":
                map.put(itemId, new Food());
                break;
            case "winningitem":
                map.put(itemId, new WinningItem());
                break;
            case "tent":
                map.put(itemId, new Tent());
                break;
            case "swimsuit":
                map.put(itemId, new Swimsuit());
                break;
            case "rope":
                map.put(itemId, new Rope());
                break;
        }
    }

    private static void build(HashMap map, String fieldId, String type){
        if (type.equals("tentcover")){
            ((Field)map.get(fieldId)).Cover(new TentCover());
        }
        else if (type.equals("igloocover")){
            ((Field)map.get(fieldId)).Cover(new IglooCover());
        }
        else if (type.equals("nocover")){
            ((Field)map.get(fieldId)).Cover(new NoCover());
        }
    }

    private static void wear(HashMap map, String playerId, String type){
        if (type.equals("swimsuitequipped")){
            ((Player)map.get(playerId)).setClothes(new SwimsuitEquipped());
        }
        else if (type.equals("noclothesequipped")){
            ((Player)map.get(playerId)).setClothes(new NoClothesEquipped());
        }
    }

    private static void step(HashMap map, Player currentPlayer,String targetId){
        Field targetField = (Field)map.get(targetId);
        currentPlayer.Step(targetField);
    }

    private static void use_item(HashMap map, Player currentPlayer, String itemId, String targetId){
        Item item = (Item)map.get(itemId);
        Player target = (Player)map.get(targetId);
        item.Use(target);
    }

    private static void dig(HashMap map, Player currentPlayer){
        currentPlayer.Dig();
    }

    private static void pickup(HashMap map, Player currentPlayer){
        currentPlayer.PickUpItem();
    }

    private static void use_ability(HashMap map, Player currentPlayer, String targetId) {
        currentPlayer.UseAbility((Field) map.get(targetId));
    }

    // Ez it kicsit nagyon rossz
    private static void blizzard(HashMap map, List<String> fieldIds) throws Exception {
        if (fieldIds == null){
            
            throw new Exception("Lécci ilyet ne csinálj:((");
        }
        else{
            List<Field> list = new ArrayList<>();

            for (String s: fieldIds){
                list.add((Field)map.get(s));
            }
            Weather.getInstance().Blizzard(list);
        }
    }

    private static void polarstep(HashMap map, String direction){
        if (direction == null){
            // ??
            PolarBear.getInstance().yourTurn();
        }
        else {
            PolarBear.getInstance().setField((Field)map.get(direction));
        }
    }

    private static void load(HashMap map, String path){
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
                ExecuteTest(res,"");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("The path given does not represent a file.");
        }
    }

    private static String save(HashMap<String, Object> map, String[] command){
        String out = "";
        if(command.length == 1){
            for(String str : map.keySet()){
                out = out + map.get(str).toString() + "\n\n";
            }
        }else if(command.length == 2){
            if(command[1].equals("GAMESTATE")){
                if(!Game.getInstance().isGameWon() && !Game.getInstance().isGameLost()){
                    out = "GAME IN PROGRESS";
                }else if(Game.getInstance().isGameLost()){
                    out = "GAME WON";
                }else if(Game.getInstance().isGameWon()){
                    out = "GAME LOST";
                }
            }else{
                out = map.get(command[1]).toString();
            }
        }
        return out;
    }

}