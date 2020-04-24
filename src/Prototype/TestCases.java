package Prototype;

//import Skeleton.Skeleton;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class TestCases {
    private HashMap<Integer,Test> tests = new HashMap<Integer, Test>();

    public void LoadTests(){
        for(Integer i = 1; i < 33; i++) {
            try {
                File input = new File("src\\inputs and outputs\\test" + i.toString() + "_input");
                File output = new File("src\\inputs and outputs\\test" + i.toString() + "_output");
                if(input.exists() && output.exists()){
                    BufferedReader br1 = new BufferedReader(new FileReader(input));
                    BufferedReader br2 = new BufferedReader(new FileReader(output));
                    String resContent = "";
                    String resContentOutput = "";
                    String line;
                    String nameOfTestCase = "";
                    int n = 0;
                    while ((line = br1.readLine()) != null) {
                        if(n == 0){
                            nameOfTestCase = line;
                        }else {
                            resContent = resContent + line;
                        }
                        n++;
                    }
                    while ((line = br2.readLine()) != null) {
                        nameOfTestCase = line;
                        resContentOutput = resContentOutput + line;
                    }
                    tests.put(i, new Test(nameOfTestCase,resContent,resContentOutput));
                    br1.close();
                    br2.close();
                }else {
                    System.out.println("Either the input or the output file doesn't exist.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        System.out.println(tests);
    }

    public void LoadInputs(){
        for(Integer i = 1; i < 33; i++) {
            try {
                File myObj = new File("src\\inputs and outputs\\test" + i.toString() + "_output");
                if(myObj.exists()){
                    BufferedReader br = new BufferedReader(new FileReader(myObj));
                    String res = "";
                    String line;
                    while ((line = br.readLine()) != null) {
                        res = res + line;
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
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
                        tests.get(1).ExecuteTest(tests.get(1).getContent(), tests.get(1).getOutputContent());
                        break;
                    case (2):
                        tests.get(2).ExecuteTest(tests.get(2).getContent(), tests.get(2).getOutputContent());
                        break;
                    case (3):
                        tests.get(3).ExecuteTest(tests.get(3).getContent(), tests.get(3).getOutputContent());
                        break;
                    case (4):
                        tests.get(4).ExecuteTest(tests.get(4).getContent(), tests.get(4).getOutputContent());
                        break;
                    case (5):
                        tests.get(5).ExecuteTest(tests.get(5).getContent(), tests.get(5).getOutputContent());
                        break;
                    case (6):
                        tests.get(6).ExecuteTest(tests.get(6).getContent(), tests.get(6).getOutputContent());
                        break;
                    case (7):
                        tests.get(7).ExecuteTest(tests.get(7).getContent(), tests.get(7).getOutputContent());
                        break;
                    case (8):
                        tests.get(8).ExecuteTest(tests.get(8).getContent(), tests.get(8).getOutputContent());
                        break;
                    case (9):
                        tests.get(9).ExecuteTest(tests.get(9).getContent(), tests.get(9).getOutputContent());
                        break;
                    case (10):
                        tests.get(10).ExecuteTest(tests.get(10).getContent(), tests.get(10).getOutputContent());
                        break;
                    case (11):
                        tests.get(11).ExecuteTest(tests.get(11).getContent(), tests.get(11).getOutputContent());
                        break;
                    case (12):
                        tests.get(12).ExecuteTest(tests.get(12).getContent(), tests.get(12).getOutputContent());
                        break;
                    case (13):
                        tests.get(13).ExecuteTest(tests.get(13).getContent(), tests.get(13).getOutputContent());
                        break;
                    case (14):
                        tests.get(14).ExecuteTest(tests.get(14).getContent(), tests.get(14).getOutputContent());
                        break;
                    case (15):
                        tests.get(15).ExecuteTest(tests.get(15).getContent(), tests.get(15).getOutputContent());
                        break;
                    case (16):
                        tests.get(16).ExecuteTest(tests.get(16).getContent(), tests.get(16).getOutputContent());
                        break;
                    case (17):
                        tests.get(17).ExecuteTest(tests.get(17).getContent(), tests.get(17).getOutputContent());
                        break;
                    case (18):
                        tests.get(18).ExecuteTest(tests.get(18).getContent(), tests.get(18).getOutputContent());
                        break;
                    case (19):
                        tests.get(19).ExecuteTest(tests.get(19).getContent(), tests.get(19).getOutputContent());
                        break;
                    case (20):
                        tests.get(20).ExecuteTest(tests.get(20).getContent(), tests.get(20).getOutputContent());
                        break;
                    case (21):
                        tests.get(21).ExecuteTest(tests.get(21).getContent(), tests.get(21).getOutputContent());
                        break;
                    case (22):
                        tests.get(22).ExecuteTest(tests.get(22).getContent(), tests.get(22).getOutputContent());
                        break;
                    case (23):
                        tests.get(23).ExecuteTest(tests.get(23).getContent(), tests.get(23).getOutputContent());
                        break;
                    case (24):
                        tests.get(24).ExecuteTest(tests.get(24).getContent(), tests.get(24).getOutputContent());
                        break;
                    case (25):
                        tests.get(25).ExecuteTest(tests.get(25).getContent(), tests.get(25).getOutputContent());
                        break;
                    case (26):
                        tests.get(26).ExecuteTest(tests.get(26).getContent(), tests.get(26).getOutputContent());
                        break;
                    case (27):
                        tests.get(27).ExecuteTest(tests.get(27).getContent(), tests.get(27).getOutputContent());
                        break;
                    case (28):
                        tests.get(28).ExecuteTest(tests.get(28).getContent(), tests.get(28).getOutputContent());
                        break;
                    case (29):
                        tests.get(29).ExecuteTest(tests.get(29).getContent(), tests.get(29).getOutputContent());
                        break;
                    case (30):
                        tests.get(30).ExecuteTest(tests.get(30).getContent(), tests.get(30).getOutputContent());
                        break;
                    case (31):
                        tests.get(31).ExecuteTest(tests.get(31).getContent(), tests.get(31).getOutputContent());
                        break;
                    case (32):
                        tests.get(32).ExecuteTest(tests.get(32).getContent(), tests.get(32).getOutputContent());
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

    public void Game(){

    }
}
