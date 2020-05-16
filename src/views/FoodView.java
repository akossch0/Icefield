package views;

import Field.Field;
import Item.Food;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FoodView implements IView {
    Food food;
    BufferedImage image = null;
    public FoodView(Food f){
        food = f;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/food.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a food rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if (food.getHolder() == null) {
            Field field = food.getField();
            if(field.getLayerOfSnow()==0)graphics.drawImage(image, field.X*64, field.Y*64, null );
        }
    }

    @Override
    public void RefreshData() {

    }
}
