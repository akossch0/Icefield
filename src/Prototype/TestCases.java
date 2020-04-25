package Prototype;


import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class TestCases {
    private HashMap<Integer,Test> tests = new HashMap<Integer, Test>();

    public void LoadTests(){
        for(Integer i = 1; i < 33; i++) {
            try {
                File input = new File("src\\inputs and outputs\\test" + Integer.toString(i) + "_input");
                File output = new File("src\\inputs and outputs\\test" + Integer.toString(i) + "_output");
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
                    }
                    tests.put(i, new Test(nameOfTestCase, resContent.toString(), resContentOutput.toString()));
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
        System.out.println(tests);
    }

    public void ListOutTests(){
        for(Integer i : tests.keySet()){
            System.out.println(i.toString() + ": " + tests.get(i).getName());
        }
    }

    public void Test(){
        LoadTests();
        ListOutTests();
        int numberOfTestCase = -1;
        do{
            try{
                System.out.print("Give the number of a test-case you want to see. To quit press 0!");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                numberOfTestCase = Integer.parseInt(s);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            try {
                switch (numberOfTestCase) {
                    case (0): /*kilepunk a programbol*/
                        System.out.println("Bye!");
                        break;
                    case (1):
                        tests.get(1).ExecuteTest();
                        break;
                    case (2):
                        tests.get(2).ExecuteTest();
                        break;
                    case (3):
                        tests.get(3).ExecuteTest();
                        break;
                    case (4):
                        tests.get(4).ExecuteTest();
                        break;
                    case (5):
                        tests.get(5).ExecuteTest();
                    break;
                    case (6):
                        tests.get(6).ExecuteTest();
                        break;
                    case (7):
                        tests.get(7).ExecuteTest();
                        break;
                    case (8):
                        tests.get(8).ExecuteTest();
                        break;
                    case (9):
                        tests.get(9).ExecuteTest();
                        break;
                    case (10):
                        tests.get(10).ExecuteTest();
                        break;
                    case (11):
                        tests.get(11).ExecuteTest();
                        break;
                    case (12):
                        tests.get(12).ExecuteTest();
                        break;
                    case (13):
                        tests.get(13).ExecuteTest();
                        break;
                    case (14):
                        tests.get(14).ExecuteTest();
                        break;
                    case (15):
                        tests.get(15).ExecuteTest();
                        break;
                    case (16):
                        tests.get(16).ExecuteTest();
                        break;
                    case (17):
                        tests.get(17).ExecuteTest();
                        break;
                    case (18):
                        tests.get(18).ExecuteTest();
                        break;
                    case (19):
                        tests.get(19).ExecuteTest();
                        break;
                    case (20):
                        tests.get(20).ExecuteTest();
                        break;
                    case (21):
                        tests.get(21).ExecuteTest();
                        break;
                    case (22):
                        tests.get(22).ExecuteTest();
                        break;
                    case (23):
                        tests.get(23).ExecuteTest();
                        break;
                    case (24):
                        tests.get(24).ExecuteTest();
                        break;
                    case (25):
                        tests.get(25).ExecuteTest();
                        break;
                    case (26):
                        tests.get(26).ExecuteTest();
                        break;
                    case (27):
                        tests.get(27).ExecuteTest();
                        break;
                    case (28):
                        tests.get(28).ExecuteTest();
                        break;
                    case (29):
                        tests.get(29).ExecuteTest();
                        break;
                    case (30):
                        tests.get(30).ExecuteTest();
                        break;
                    case (31):
                        tests.get(31).ExecuteTest();
                        break;
                    case (32):
                        tests.get(32).ExecuteTest();
                        break;
                    default:
                        System.out.println("Wrong input given!");
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }while(numberOfTestCase != 0);
    }

    public void Game() {
        try{
            boolean twoEnters = false;
            String before = null;
            ArrayList<String> strings = new ArrayList<>();
            System.out.println("Write commands here:");
            while(!twoEnters){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                if(s.equals("") && before.equals("")){
                    twoEnters = true;
                }
                strings.add(s);
                before = s;
            };
            StringBuilder commandsString = new StringBuilder();
            for(String s : strings){
                commandsString.append(s);
            }
            Test test = new Test("game",commandsString.toString(),"");

            test.ExecuteTest();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
