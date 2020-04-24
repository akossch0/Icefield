package Prototype;

import Player.Player;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    private String content;
    private String name;

    public Test(String n, String con){
        name = n;
        content = content;
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
                    placeItem(actors, command[1]);
                    break;
                case "item":
                    if (command.length == 4)
                        newItem(actors, command[1], command[2], command[3]);
                    else
                        newItem(actors, command[1], command[2]);
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
                    use_item(actors,currentPlayer, command[1]);
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
                        ArrayList<Object> fieldList = new ArrayList();
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
                    break;
                case "SAVE":
                    //??
                    break;
            }
        }
    }

}