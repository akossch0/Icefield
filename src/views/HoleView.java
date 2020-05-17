package views;

import Field.Field;
import Field.Hole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * lyuk nezet
 */
public class HoleView implements IView{
    Hole hole;
    BufferedImage imagewithsnow;
    BufferedImage imagewithoutsnow;
    public HoleView(Hole h){
        hole = h;
        try{
            imagewithoutsnow  = ImageIO.read(new File("src/images/hole.png"));
            imagewithsnow = ImageIO.read(new File("src/images/snow.png"));


        }catch(IOException e){
            System.out.println("Baj van - HoleView betoltese");
        }
    }

    /**
     * lyuk kirajzolasaert felelos
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        if(hole.getLayerOfSnow()==0)
            graphics.drawImage(imagewithoutsnow,hole.X*64,hole.Y*64,null);
        else
            graphics.drawImage(imagewithsnow,hole.X*64,hole.Y*64,null);
        Field chosenField = GameplayFrame.getChosenField();
        if (chosenField != null && chosenField.equals(hole)){
            Graphics2D g2D = (Graphics2D) graphics;
            g2D.setColor(Color.green);
            g2D.setStroke(new BasicStroke(4));
            g2D.drawRect(hole.X*64,hole.Y*64, 64,64);
        }
        if(hole.isInspected){
            String string = hole.getCapacity()==-1? "i" : Integer.toString(hole.getCapacity());
            Graphics2D g2D = (Graphics2D) graphics;
            g2D.setColor(Color.black);
            graphics.drawString(string, hole.X*64 + 50,hole.Y*64+20 );
        }
    }
}
