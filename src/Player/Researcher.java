package Player;

import Field.Field;
import Skeleton.Skeleton;

public class Researcher extends Player {
    /**
     * @param f A mező amire a kepesseget hasznalja majd a player (Oda epit Iglut vagy deriti fel)
     * @return visszater a mezo teherbiro kepessegevel
     */
    @Override
    public int UseAbility(Field f){
        Skeleton.Called("Researcher-UseAbility");
        Skeleton.Return();
        return 0;}

}
