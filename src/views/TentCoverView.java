package views;

import Coverable.TentCover;
import Field.Field;
import Game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TentCoverView implements IView{

    Field field;
    BufferedImage image;
    TentCoverView( Field f){
        field = f;
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/tentCover.png"));

        }
        catch(IOException e) {
            System.out.println("nem jo a tencover rajzolas");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if(!(field.getCover() instanceof TentCover))
            synchronized (Game.getInstance().getView()){
            Game.getInstance().getView().RemoveView(this);
            }
        else graphics.drawImage(image, field.X*64, field.Y*64, null );
    }


}
