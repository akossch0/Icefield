package views;

import Field.Field;
import Item.Swimsuit;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SwimsuitView implements IView {
    Swimsuit swimsuit;
    BufferedImage image = null;
    BufferedImage imageO = null;
    public SwimsuitView(Swimsuit s) {
        swimsuit = s;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/swimsuit.png"));
            imageO = (BufferedImage) ImageIO.read(new File("src/images/swimsuit_fifty.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a swimsuit rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if (swimsuit.getHolder() == null) {
            Field field = swimsuit.getField();
            if(field.getLayerOfSnow()==0){
                if(field.IsOpen())graphics.drawImage(image, field.X*64, field.Y*64, null );
                else graphics.drawImage(imageO, field.X*64, field.Y*64, null );
            }
        }
    }
}
