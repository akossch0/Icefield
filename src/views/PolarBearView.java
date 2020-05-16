package views;

import Game.PolarBear;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PolarBearView implements IView {
    PolarBear polarBear;
    BufferedImage image = null;
    PolarBearView(PolarBear p){
        polarBear = p;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/polarbear.png")).getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        }
        catch(IOException e) {
            System.out.println("nem jo a polarbear rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(image, polarBear.getField().X * 64, polarBear.getField().Y * 64, null);
    }

    @Override
    public void RefreshData() {

    }
}
