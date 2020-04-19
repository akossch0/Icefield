package Game;

import Field.Field;
import Player.Player;

import java.util.List;
import java.util.Random;

public final class PolarBear extends Entity{
    private static PolarBear INSTANCE;

    /**
     * Ha szuksegunk van a weather osztaly peldanyara ezt a fuggvenyt kell meghivni
     * @return
     */
    public static PolarBear getInstance(){
        if(INSTANCE == null)
            INSTANCE = new PolarBear();

        return INSTANCE;
    }
    @Override
    public void setInWater(boolean b) {
        return;
    }

    @Override
    public void Meet(Actor a) {
        a.InteractWith(this);
    }

    @Override
    public void yourTurn() {
        List<Field> neighbours = field.getNeighbours();
        Random rand = new Random();
        Field target = neighbours.get(rand.nextInt(neighbours.size()));
        Step(target);
    }

    @Override
    public void InteractWith(Player p) {
        if(!p.getField().IsBearProof())
            Manager.Lose();
    }

    @Override
    public void InteractWith(PolarBear p) {
        return;
    }
}
