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
                File myObj = new File("src\\inputs and outputs\\test" + i.toString() + "_input");
                if(myObj.exists()){
                    BufferedReader br = new BufferedReader(new FileReader(myObj));
                    String res = "";
                    String line;
                    String nameOfTestCase = "";
                    int n = 0;
                    while ((line = br.readLine()) != null) {
                        if(n == 0){
                            nameOfTestCase = line;
                        }else {
                            res = res + line;
                        }
                        n++;
                    }
                    tests.put(i, new Test(nameOfTestCase,res));
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

                        break;
                    case (4):

                        break;
                    case (5):

                        break;
                    case (6):

                        break;
                    case (7):

                        break;
                    case (8):

                        break;
                    case (9):

                        break;
                    case (10):

                        break;
                    case (11):

                        break;
                    case (12):

                        break;
                    case (13):

                        break;
                    case (14):

                        break;
                    case (15):

                        break;
                    case (16):

                        break;
                    case (17):

                        break;
                    case (18):

                        break;
                    case (19):

                        break;
                    case (20):

                        break;
                    case (21):

                        break;
                    case (22):

                        break;
                    case (23):

                        break;
                    case (24):

                        break;
                    case (25):

                        break;
                    case (26):

                        break;
                    case (27):

                        break;
                    case (28):

                        break;
                    case (29):

                        break;
                    case (30):

                        break;
                    case (31):

                        break;
                    case (32):

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
