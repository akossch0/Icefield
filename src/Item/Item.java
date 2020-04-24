package Item;

import Player.*;

/**
 * Absztrakt alaposztaly, a konkret peldanyai az Aso (Spade), Etel (Food),
 * Buvarruha (Swimsuit), Kotel (Rope), Nyero targy(WinningItem).
 * A targyakat reprezentalja a jatekban.
 */
public abstract class Item {
    /**
     * A birtokosa az itemnek
     */
    private Player holder = null;

    /**
     * Az itemek kepesseget ezen a metoduson keresztul lehete hasznalni
     * @param p a player akin az item hasznalva lesz (megegyezhet a haszan,lojaval is)
     */
    public abstract void Use(Player p);

    /**
     * A tulajdonost allitja be
     * @param p az uj tulajdonosa az itemnek
     */
    public void setHolder(Player p){
        holder = p;
    }

    public Player getHolder(){
        return holder;
    }

    /*public String toString(){
        String result;
        if(this.getClass().toString().equals("Spade")){
            result = "item\n" +
                    "ID:" + "\n" +
                    "TYPE:" + this.getClass().toString() + "\n" +
                    "holder:" + this +
                    "durability:" + this;
        }else {
            result = "item\n" +
                    "ID:" + "\n" +
                    "TYPE:" + this.getClass().toString() + "\n" +
                    "holder:" + this;
        }
    }*/
}
