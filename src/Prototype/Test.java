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
    private HashMap<String, Object> actors;
    public Test(String n, String con, String outCon){
        name = n;
        content = con;
        outputContent = outCon;
        actors = new HashMap<String,Object>();
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

    public void ExecuteTest(String input, String output) throws Exception {


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
                    newField(command[1], command[2], command[3], command[4], command[5]);
                    break;
                case "neighbours":
                    addNeighbours(command[1], command[2]);
                    break;
                case "player":
                    newPlayer(command[1], command[2], command[3]);
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
                    step( currentPlayer, command[1]);
                    break;
                case "USE_ITEM":
                    use_item(currentPlayer, command[1], command[2]);
                    break;
                case "USE_ABILITY":
                    use_ability(currentPlayer, command[1]);
                    break;
                case "DIG":
                    dig(currentPlayer);
                    break;
                case "PICKUP":
                    pickup(currentPlayer);
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

    private void newField(String id, String type, String limit, String snow, String open){
        if (type.equals("iceblock")){
            IceBlock iceblock = new IceBlock();
            iceblock.setCapacity(Integer.parseInt(limit));
            iceblock.setLayerOfSnow(Integer.parseInt(snow));
            iceblock.setIsOpen(Boolean.parseBoolean(open));
            actors.put(id, iceblock);
        }
        else{
            Hole hole = new Hole();
            actors.put(id, hole);
        }
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
        }
        else{
            Researcher researcher = new Researcher((Field)actors.get(fieldId));
            actors.put(Id, researcher);
        }
    }

    private void placeItem(String itemId, String targetId){
        Object target = actors.get(targetId);
        if (target instanceof Player){
            Player player = (Player)target;
            player.AcceptItem((Item)actors.get(itemId));
        }
        else if (target instanceof Field){
            Field field = (Field)target;
            field.setItem((Item)actors.get(itemId));
        }
    }

    private void newItem(String itemId, String type, String durability){
        switch (type){
            case "spade":
                Spade spade = new Spade();
                if (durability.equals("3")){
                    spade.setDurability(3);
                }
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

    private void step(Player currentPlayer,String targetId){
        Field targetField = (Field)actors.get(targetId);
        currentPlayer.Step(targetField);
    }

    private void use_item( Player currentPlayer, String itemId, String targetId){
        Item item = (Item)actors.get(itemId);
        Player target = (Player)actors.get(targetId);
        item.Use(target);
    }

    private void dig( Player currentPlayer){
        currentPlayer.Dig();
    }

    private void pickup( Player currentPlayer){
        currentPlayer.PickUpItem();
    }

    private void use_ability(Player currentPlayer, String targetId) {
        currentPlayer.UseAbility((Field) actors.get(targetId));
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

    private void polarstep(String direction){
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
                ExecuteTest(res,"");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("The path given does not represent a file.");
        }
    }

    private String save( String[] command){
        String out = "";
        if(command.length == 1){
            for(String str : actors.keySet()){
                out = out + actors.get(str).toString() + "\n\n";
            }
        }else if(command.length == 2){
            if(command[1].equals("GAMESTATE")){
                Game.getInstance();
                if(!Game.isGameWon() && !Game.isGameLost()){
                    out = "GAME IN PROGRESS";
                }else {
                    if(Game.isGameLost()){
                        out = "GAME LOST";
                    }else {
                        out = "GAME WON";
                    }
                }
            }else{
                out = actors.get(command[1]).toString();
            }
        }
        return out;
    }

}