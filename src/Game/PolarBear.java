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

    /**
     *
     * Nem csinal semmit, csak az oroklodes miatt szukseges
     */
    @Override
    public void setInWater(boolean b) {
        return;
    }

    /**
     * Polarbear talalkozik  aktorral
     * @param a aktor
     */
    @Override
    public void Meet(Actor a) {

        a.InteractWith(this);
    }

    /**
     * manager megmondja a macinak hogy o a soros
     */
    @Override
    public void yourTurn() {
        List<Field> neighbours = field.getNeighbours();
        Random rand = new Random();
        Field target = neighbours.get(rand.nextInt(neighbours.size()));
        Step(target);
    }

    /**
     * maci - player interakcio
     * @param p a player akivel az aktor interakcioba lep
     */
    @Override
    public void InteractWith(Player p) {

        if(!p.getField().IsBearProof())
            Manager.Lose();
    }

    /**
     * maci maci interakcio, nem tortenik semmi
     * @param p a jegesmedve akivel interaktol az aktor
     */
    @Override
    public void InteractWith(PolarBear p) {
        return;
    }

    /**
     * kimeneti nyelv: maci
     * @param objects a hashmap ami tarolja az objektum-id-kat es a hozza tartozo objektumokat
     * @return
     */
    public String toString(HashMap<String,Object> objects){
        String result = "polarbear:\n" +
                "\tfield: " + Test.getKeyByValue(objects,this.getField());
        return result;
    }
}
