package views;

import Coverable.IglooCover;
import Field.Field;
import Game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * igloocover nezet
 */
public class IglooCoverView implements IView {
    Field field;
    BufferedImage image;
    public IglooCoverView(Field f){
        field = f;
        try {
            image = ImageIO.read(new File("src/images/igloo.png"));

        }
        catch(IOException e) {
            System.out.println("nem jo a igloo rajzolas");
        }
    }

    /**
     * igloo kirajzolas
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        if(!(field.getCover() instanceof IglooCover))
            synchronized (Game.getInstance().getView()){
                Game.getInstance().getView().RemoveView(this);
            }
        else graphics.drawImage(image, field.X*64, field.Y*64, null );

    }
}
