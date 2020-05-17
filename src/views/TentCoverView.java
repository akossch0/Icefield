package views;

import Coverable.TentCover;
import Field.Field;
import Game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * sator cover nezet
 */
public class TentCoverView implements IView{

    Field field;
    BufferedImage image;
    TentCoverView( Field f){
        field = f;
        try {
            image = ImageIO.read(new File("src/images/tentCover.png"));

        }
        catch(IOException e) {
            System.out.println("nem jo a tencover rajzolas");
        }
    }

    /**
     * sator nezet kirajzolas
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        if((field.getCover() instanceof TentCover))
            graphics.drawImage(image, field.X*64, field.Y*64, null );

    }


}
