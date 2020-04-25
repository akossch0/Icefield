package Item;

import Game.Game;
import Game.Manager;
import Player.*;

import java.util.List;

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
        Manager manager = Manager.getInstance();
        p.RemoveItem(this);
        List<Item> items  = p.getItems();
        for (Item i : items){
            if(i instanceof WinningItem){
                p.RemoveItem(i);
                manager.giveItem(i);
            }
        }
        manager.addItem(this);
    }
}
