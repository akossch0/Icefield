package Game;

import Coverable.*;
import Field.Field;
import Player.Player;
import Skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;


public final class Weather {
    private List<Field> fields = new ArrayList<Field>();

    public void Blizzard() {
        Skeleton.Called(this,"Blizzard");
        for (Field f : fields){
            boolean  b =  f.IsCovered();
            if (!b){
                f.IncrLayerOfSnow();
                List<Player> ps = f.getPlayers();
                for (Player p : ps){
                    p.DecrHp();
                }
            }
            else{
                Coverable ng = new NoGloo();
                f.Gloo(ng);
            }
        }



        Skeleton.Return();
    }
    // Szükséges faszság
    public void add(List<Field> fs){
        fields = fs;
    }
}
