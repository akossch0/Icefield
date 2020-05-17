package views;

import Field.Field;
import Game.Actor;
import Player.Eskimo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class EskimoView implements IView {
    Eskimo eskimo;
    BufferedImage image;
    BufferedImage blueimage;

    EskimoView(Eskimo e){
        eskimo = e;
        try {
            image = ImageIO.read(new File("src/images/eskimo.png"));
            blueimage = ImageIO.read(new File("src/images/eskimo_blue.png"));

        }
        catch(IOException ex) {
            System.out.println("nem jo az Eskimo rajzolas");
        }
    };
    @Override
    public void Draw(Graphics graphics) {
        Field field = eskimo.getField();
        float index = field.getEntites().indexOf(eskimo);
        float entities = field.getEntites().size();
        int tilt = (int)(-10+index/entities*10 )>20? 20:(int)(-10+index/entities*10);
        if (eskimo.isInWater())
            graphics.drawImage(blueimage, (int) (field.X*64)+tilt, field.Y*64, null );
        else
            graphics.drawImage(image, (int) (field.X*64)+tilt, field.Y*64, null );
        if (GameplayFrame.getCurrentPlayer().equals(eskimo)){
            Graphics2D g2D = (Graphics2D) graphics;
            g2D.setColor(Color.red);
            g2D.setStroke(new BasicStroke(4));
            g2D.drawRect(field.X*64,field.Y*64, 64,64);
        }
    }
}
