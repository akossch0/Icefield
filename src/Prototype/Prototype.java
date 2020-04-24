package Prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prototype {
    private String gameMode;

    public void Run() {

        try{
            System.out.println("<question> Do you want to test or to play?(test/play)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
