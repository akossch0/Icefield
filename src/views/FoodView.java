package views;

import Field.Field;
import Item.Food;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * etel nezete
 */
public class FoodView implements IView {
    Food food;
    BufferedImage image = null;
    BufferedImage imageO = null;
    public FoodView(Food f){
        food = f;
        try {
            image = ImageIO.read(new File("src/images/food.png"));
            imageO = ImageIO.read(new File("src/images/food_fifty.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a food rajzolas");
        }
    }

    /**
     * etel kirajzolasa
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        if (food.getHolder() == null) {
            Field field = food.getField();
            if(field.getLayerOfSnow()==0){
                if(field.IsOpen())graphics.drawImage(image, field.X*64, field.Y*64, null );
                else graphics.drawImage(imageO, field.X*64, field.Y*64, null );
            }
        }
    }
}
