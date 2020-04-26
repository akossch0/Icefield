package Prototype;


import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * A programmodok iranyitasat vegzo osztaly
 * Teszteket tarolo osztaly, melynek feladata teszt jatemod eseten a tesztek betoltese, helyes ertelmezese.
 * Jatek nevu jatekmod eseten a felhasznalo utasitasainak ertelmezese
 */
public class TestCases {
    private HashMap<Integer,Test> tests = new HashMap<Integer, Test>();

    /**
     * Fajlbol beolvassa a teszteket a tests nevu valtozoba, jelzi ha problemat eszlel
     */
    public void LoadTests(){
        for(Integer i = 1; i < 33; i++) {
            try {
                File input = new File("src/inputs_and_outputs/test" + Integer.toString(i) + "_input");
                File output = new File("src/inputs_and_outputs/test" + Integer.toString(i) + "_output");
                if(input.exists() && output.exists()){
                    BufferedReader br1 = new BufferedReader(new FileReader(input));
                    BufferedReader br2 = new BufferedReader(new FileReader(output));
                    StringBuilder resContent = new StringBuilder();
                    StringBuilder resContentOutput = new StringBuilder();
                    String line;
                    String nameOfTestCase = "";
                    int n = 0;
                    while ((line = br1.readLine()) != null) {
                        if(n == 0){
                            nameOfTestCase = line;
                        }else {
                            resContent.append(line);
                            resContent.append("\n");
                        }
                        n++;
                    }
                    while ((line = br2.readLine()) != null) {
                        resContentOutput.append(line);
                        resContentOutput.append("\n");
                    }
                    tests.put(i, new Test(nameOfTestCase, resContent.toString(), resContentOutput.toString(),true));
                    br1.close();
                    br2.close();
                }else {
                    System.out.println("Either the input or the output file doesn't exist.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    /**
     * @param path fajl utvonal ahonnna be lesz olvasva a teszt
     * @return visszaadja a beolvasasra kerult tesztet
     */
    public String LoadTest(String path){
        File in = new File(path);
        StringBuilder res = new StringBuilder();
        if(in.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    res.append(line).append("\n");
                }
                br.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("The path given does not represent a file.");
        }
        return res.toString();
    }

    /**
     * Tesztek kilistazasa a konzolra
     */
    public void ListOutTests(){
        for(Integer i : tests.keySet()){
            System.out.println(i.toString() + ": " + tests.get(i).getName());
        }
    }

    /**
     * Beolvass fajlbol teszteket, kilistazza q konzolra, majd felhasznaloi utasitas szerint lefutattja a valasztott teszteket
     */
    public void Test(){
        LoadTests();
        ListOutTests();
        String[] command = {"-1"};
        do{
            try{
                System.out.println("---------------------------------------");
                System.out.print(
                        "To execute all of the tests use command 'all'.\n"+
                        "You can use the command\n\tfile <path to the file of the test-cases>\n" +
                        "to read test-cases from a .txt file.\n" +
                        "Yo can also test manually, choosing the number of the test-input written up.\nTo quit press '0'!\n" +
                        "The command: ");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                command = s.split("\\s");

                switch (command[0]) {
                    case ("0"): /*kilepunk a programbol*/
                        System.out.println("Bye!");
                        break;
                    case ("1"):
                        tests.get(1).ExecuteTest();
                        break;
                    case ("2"):
                        tests.get(2).ExecuteTest();
                        break;
                    case ("3"):
                        tests.get(3).ExecuteTest();
                        break;
                    case ("4"):
                        tests.get(4).ExecuteTest();
                        break;
                    case ("5"):
                        tests.get(5).ExecuteTest();
                    break;
                    case ("6"):
                        tests.get(6).ExecuteTest();
                        break;
                    case ("7"):
                        tests.get(7).ExecuteTest();
                        break;
                    case ("8"):
                        tests.get(8).ExecuteTest();
                        break;
                    case ("9"):
                        tests.get(9).ExecuteTest();
                        break;
                    case ("10"):
                        tests.get(10).ExecuteTest();
                        break;
                    case ("11"):
                        tests.get(11).ExecuteTest();
                        break;
                    case ("12"):
                        tests.get(12).ExecuteTest();
                        break;
                    case ("13"):
                        tests.get(13).ExecuteTest();
                        break;
                    case ("14"):
                        tests.get(14).ExecuteTest();
                        break;
                    case ("15"):
                        tests.get(15).ExecuteTest();
                        break;
                    case ("16"):
                        tests.get(16).ExecuteTest();
                        break;
                    case ("17"):
                        tests.get(17).ExecuteTest();
                        break;
                    case ("18"):
                        tests.get(18).ExecuteTest();
                        break;
                    case ("19"):
                        tests.get(19).ExecuteTest();
                        break;
                    case ("20"):
                        tests.get(20).ExecuteTest();
                        break;
                    case ("21"):
                        tests.get(21).ExecuteTest();
                        break;
                    case ("22"):
                        tests.get(22).ExecuteTest();
                        break;
                    case ("23"):
                        tests.get(23).ExecuteTest();
                        break;
                    case ("24"):
                        tests.get(24).ExecuteTest();
                        break;
                    case ("25"):
                        tests.get(25).ExecuteTest();
                        break;
                    case ("26"):
                        tests.get(26).ExecuteTest();
                        break;
                    case ("27"):
                        tests.get(27).ExecuteTest();
                        break;
                    case ("28"):
                        tests.get(28).ExecuteTest();
                        break;
                    case ("29"):
                        tests.get(29).ExecuteTest();
                        break;
                    case ("30"):
                        tests.get(30).ExecuteTest();
                        break;
                    case ("31"):
                        tests.get(31).ExecuteTest();
                        break;
                    case ("32"):
                        tests.get(32).ExecuteTest();
                        break;
                    case ("all"):
                        //kiiratasi okok miatt
                       for(int i : tests.keySet())
                           tests.get(i).setAll(true);

                        int testsSucceeded = 0;
                        for(int i : tests.keySet()){
                            if(tests.get(i).ExecuteTest()){
                                testsSucceeded++;
                            }else{
                                System.out.println(Integer.toString(i) + ". test failed!");
                            }
                        }
                        System.out.println("Tests run/succeeded: " + tests.keySet().size() + "/" + testsSucceeded );

                        //parancs lefutasa utan visszaallitani
                        for(int i : tests.keySet())
                            tests.get(i).setAll(false);

                        break;
                    case ("file"):
                        Test t = new Test("reading from a file",LoadTest(command[1]),"",false);
                        t.ExecuteTest();
                        break;
                    default:
                        System.out.println("Wrong input given!");
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }while(!command[0].equals("0"));
    }

    /**
     * A felhasznalotol varja a parancsokat, azokat ertelmezi es vegrahajta oket
     */
    public void Game() {
        try{
            Test test = new Test("game","","",false);
            System.out.println("---------------------------------------");
            System.out.print(
                    "You should check the input language for commands to use.\n"+
                            "To quit press 'exit'!\n" +
                            "The command: ");
            String s;
            do{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                s = br.readLine();
                test.interpretLine(s);
                String commands[] = s.split("\\s");
            }while(!s.equals("exit"));
            System.out.println("Bye!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
