package views;

import Item.Food;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FoodView implements IView {
    Food food;
    FoodView(Food f){
        food = f;
    }
    @Override
    public void Draw() {
        throw new NotImplementedException();
    }

    @Override
    public void RefreshData() {
        throw new NotImplementedException();
    }
}
