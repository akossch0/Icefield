package views;

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
            image = (BufferedImage) ImageIO.read(new File("src/images/food.png")).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        }
        catch(IOException e) {
            System.out.println("nem jo a food rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, food.getField().X * 64, food.getField().Y * 64, null);
    }

    @Override
    public void RefreshData() {

    }
}
