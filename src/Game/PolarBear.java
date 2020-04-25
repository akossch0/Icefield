package Game;

import Field.Field;
import Player.Player;
import Prototype.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Felelossege a jatekban levo jegesmedvet felugyelni
 * ami veletlenszeruen jarja  a palyat és megtamadja a jatekosokat ha vele egy mezon vannak.
 */
public final class PolarBear extends Entity implements OutputToString{
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

    public String toString(HashMap<String,Object> objects){
        String result = "polarbear\n" +
                "\tID: " + Test.getKeyByValue(objects,this) + "\n";
        return result;
    }
}
