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
        Skeleton.Called(this,"UseAbility");
        f.getCapacity();
        Skeleton.Return();
        return 0;}

}
