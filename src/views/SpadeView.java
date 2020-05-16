package views;

import Field.Field;
import Item.Rope;
import Item.Spade;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SpadeView implements IView {
    Spade spade;
    BufferedImage image = null;
    BufferedImage imageO = null;

    public SpadeView(Spade s)  {
        spade = s;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/spade.png"));
            imageO = (BufferedImage) ImageIO.read(new File("src/images/spade_fifty.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a spade rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if (spade.getHolder() == null) {
            Field field = spade.getField();
            if(field.getLayerOfSnow()==0){
                if(field.IsOpen())graphics.drawImage(image, field.X*64, field.Y*64, null );
                else graphics.drawImage(imageO, field.X*64, field.Y*64, null );
            }
        }
    }

    @Override
    public void RefreshData() {

    }
}
