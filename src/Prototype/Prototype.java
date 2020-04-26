package Prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prototype {
    private String gameMode;
    private TestCases test = new TestCases();

    public TestCases getTest() {
        return test;
    }

    public void Run() {
        String answer;

        while(true){
            try {
                System.out.println("\tPROTOTYPE\n<question> Do you want to test or to play?(test/play)");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                answer = br.readLine();
                if (answer.equals("test") || answer.equals("play")) {
                    gameMode = answer;
                    break;
                } else {
                    System.out.println("Wrong command!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String description;

        switch(gameMode){
            case "test":
                System.out.println("You chose the testing mode!");
                //itt lesz a tesztesetek kilistazasa, es a menuvezerles
                test.Test();
                break;
            case "play":
                System.out.println("You chose the playing mode!");
                test.Game();
                break;
        }
    }
}
