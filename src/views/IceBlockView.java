package views;


import Field.Field;
import Field.IceBlock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * jegtabla nezet
 */
public class IceBlockView implements IView {
    IceBlock iceBlock;

    BufferedImage imagewithsnow;
    BufferedImage imagewithoutsnow;
    BufferedImage tentcoverimage;
    BufferedImage igloocoverimage;

    public IceBlockView(IceBlock i){
        iceBlock = i;
        try {
            imagewithoutsnow =  ImageIO.read(new File("src/images/iceblock.png"));
            imagewithsnow = ImageIO.read(new File("src/images/snow.png"));
            tentcoverimage = ImageIO.read(new File("src/images/tentCover.png"));
            igloocoverimage = ImageIO.read(new File("src/images/igloo.png"));
        } catch (IOException e) {
            System.out.println("Baj van - IceBlockView betoltese");
        }
    }

    /**
     * jegtabla kirajzolasa
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        if(iceBlock.getLayerOfSnow()==0)
            graphics.drawImage(imagewithoutsnow,iceBlock.X*64,iceBlock.Y*64,null);
        else
            graphics.drawImage(imagewithsnow,iceBlock.X*64,iceBlock.Y*64,null);
        Field chosenField = GameplayFrame.getChosenField();
        if (chosenField != null && chosenField.equals(iceBlock)){
            Graphics2D g2D = (Graphics2D) graphics;
            g2D.setColor(Color.green);
            g2D.setStroke(new BasicStroke(4));
            g2D.drawRect(iceBlock.X*64,iceBlock.Y*64, 64,64);
        }
        if(iceBlock.isInspected){
            String string = iceBlock.getCapacity()==-1? "i" : Integer.toString(iceBlock.getCapacity());
            Graphics2D g2D = (Graphics2D) graphics;
            g2D.setColor(Color.black);
            graphics.drawString(string, iceBlock.X*64 + 50,iceBlock.Y*64+20 );
        }
    }
}
