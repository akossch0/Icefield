package Game;

import Player.Player;

/**
 * Minden szereplo ezt az interface-t valositja meg, így lesz sajat koruk, ahol ok cselekednek
 */
public interface Actor {
    public abstract void Meet(Actor a);

    public abstract void yourTurn();

    public abstract void InteractWith(Player p);

    public abstract void InteractWith(PolarBear p);
}
