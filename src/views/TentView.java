package views;

import Field.Field;
import Item.Tent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * sator item nezet
 */
public class TentView implements IView {
    Tent tent;
    BufferedImage image;
    BufferedImage imageO;
    public TentView(Tent t){
        tent = t;
        try{
            image = (BufferedImage) ImageIO.read(new File("src/images/tent.png"));
            imageO = (BufferedImage) ImageIO.read(new File("src/images/tent_fifty.png"));
        }
        catch(IOException e){
            System.out.println("Valami baj van a sátor i/o-val");
        }
    }

    /**
     * sator item rajzolas
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        if (tent.getHolder() == null) {
            Field field = tent.getField();
            if(field.getLayerOfSnow()==0){
                if(field.IsOpen())graphics.drawImage(image, field.X*64, field.Y*64, null );
                else graphics.drawImage(imageO, field.X*64, field.Y*64, null );
            }
        }
    }

}
