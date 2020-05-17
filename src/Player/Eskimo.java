package Player;

import Coverable.IglooCover;
import Field.*;
import Game.Game;
import views.IglooCoverView;

/**
 * Egy jatekos altal iranyitott karaktert reprezental, aki iglu epitesere kepes, annak
 * erdekeben, hogy a jatekosok at tudjak veszelni a hovihart.
 */
public class Eskimo extends Player {
    final static int maxHealt = 5;
    final static int maxWorkUnit = 4;
    public Eskimo(Field _field) {
        super(maxHealt, maxWorkUnit, maxHealt, _field);
    }
    public Eskimo(){
        super(maxHealt, maxWorkUnit, maxHealt);
    }

    /**
     * @param f A mezo amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater nullaval
     */
    @Override
    public int UseAbility(Field f){
        if (getActualWorkUnit()>0)
            if (!isInWater()){
                getField().Cover(new IglooCover());
                setActualWorkUnit(getActualWorkUnit() - 1);
                Game.getInstance().getView().AddView(new IglooCoverView(this.getField()));
            }
        return -1;
    }

    @Override
    public String getType() {return "eskimo";}

    /**
     * toString hivasra az osztaly nevevel ter vissza
     *
     */
    @Override
    public String toString(){
        return "eskimo";
    }
}
