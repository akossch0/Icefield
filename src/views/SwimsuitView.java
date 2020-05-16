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
    public SwimsuitView(Swimsuit s) {
        swimsuit = s;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/swimsuit.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a swimsuit rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if (swimsuit.getHolder() == null) {
            Field field = swimsuit.getField();
            if(field.getLayerOfSnow()==0)graphics.drawImage(image, field.X*64, field.Y*64, null );
        }
    }

    @Override
    public void RefreshData() {

    }
}
