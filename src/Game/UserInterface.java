package Game;

import Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
    public void CommandListen(Player p){
        boolean ok = false;
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        String name = null;
        try {
            while(!ok){
            name = reader.readLine();









            }
            /*
            * Még implementálni kell mit csináljon
            * lényeg hogy a megadott p playerre visszahívja a parancsot pl ha endet kap akkor player.endturn valami
            * */
            System.out.println( "Még nincs implementálva a parancsértelmező");





        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private  void Info(Player p){

    }
}
