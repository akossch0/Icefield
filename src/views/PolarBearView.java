package views;

import Game.PolarBear;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * jegesmedve nezet
 */
public class PolarBearView implements IView {
    PolarBear polarBear;
    BufferedImage image = null;
    public PolarBearView(PolarBear p){
        polarBear = p;
        try {
            image = ImageIO.read(new File("src/images/polarbear.png"));
        }
        catch(IOException e) {
            System.out.println("nem jo a polarbear rajzolas");
        }
    }

    /**
     * jegesmedve kirajzolas
     * @param graphics
     */
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, polarBear.getField().X * 64, polarBear.getField().Y * 64, null);
    }
}
