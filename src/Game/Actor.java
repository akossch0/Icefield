package Game;

import Player.Player;

public interface Actor {
    public abstract void Meet(Actor a);

    public abstract void yourTurn();

    public abstract void InteractWith(Player p);

    public abstract void InteractWith(PolarBear p);
}
