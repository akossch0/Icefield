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
                System.out.println("<question> Do you want to test or to play?(test/play)");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                answer = br.readLine();
                if (answer.equals("test") || answer.equals("play")) {
                    gameMode = answer;
                    break;
                } else {
                    System.out.println("Wrong answer!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String description;

        switch(gameMode){
            case "test":
                description = "You chose the testing mode!\n" +
                        "You can use the command\n\tfile <path to the file of the test-cases>\n" +
                        "to read test-cases from a .txt file\n" +
                        "Yo can also test manually, choosing the number of the test-case written below.";

                System.out.println(description);
                //itt lesz a tesztesetek kilistazasa, es a menuvezerles
                test.Test();
                break;
            case "play":
                description = "You chose the playing mode!\n" +
                        "\n" +
                        "\n" +
                        "";

                System.out.println(description);
                test.Game();
                break;
        }
    }
}
