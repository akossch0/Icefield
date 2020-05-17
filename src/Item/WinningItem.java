package Item;

import Game.Manager;
import Player.*;


/**
 * A jelzoraketa alkatreszeit reprezentalja a jatekban.
 * A jatekosok celja a jelzoraketa osszes alkatreszet osszegyujteni és egy jegtablara vinni, ott osszeszerelni és elsutni, ezzel a jatekot megnyerni.
 */
public class WinningItem extends Item {
    /**
     *
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    @Override
    public void Use(Player p){

         if (Manager.getInstance().WinningItemUsed()) {
             p.EndTurn();
             p.decreaseWorkUnits();
         }
    }
    public int id;
    /**
     * A nyerotargy letrehozaskor regisztralodik a managerben
     */
    public WinningItem(int _id){
        id = _id;
        Manager.getInstance().register(this);
    }

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "winningitem";
    }
}
