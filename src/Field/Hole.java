package Field;


import Coverable.Coverable;
import Skeleton.Skeleton;

public class Hole extends Field {

    /**
     * A strategia setter-e, de nem csinal semmit,
     * mivel alapertelmezesben a Hole objektumnak a strategiaja NoGloo.
     * @param c
     */
    public void Gloo(Coverable c){
        Skeleton.Called(this,"Gloo");
        Skeleton.Return();
    }

}
