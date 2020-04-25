package Game;

import Player.Player;

/**
 * Minden szereplo ezt az interface-t valositja meg, így lesz sajat koruk, ahol ok cselekednek
 */
public interface Actor {
    /**
     * actor actor talalkozas
     * @param a
     */
    public abstract void Meet(Actor a);

    /**
     * megmondja egy aktornak hogy o a soros
     */
    public abstract void yourTurn();

    /**
     * acror interakcioja playerrel
     * @param p a player akivel az aktor interakcioba lep
     */
    public abstract void InteractWith(Player p);

    /**
     * actor interakcioja jegesmedvevel
     * @param p a jegesmedve akivel interaktol az aktor
     */
    public abstract void InteractWith(PolarBear p);
}
