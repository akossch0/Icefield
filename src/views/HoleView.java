package views;

import Field.Hole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HoleView implements IView{
    Hole hole;
    BufferedImage imagewithsnow;
    BufferedImage imagewithoutsnow;
    HoleView(Hole h){hole = h;

        try{
            imagewithoutsnow  = (BufferedImage) ImageIO.read(new File("valami")).getScaledInstance(64,64,Image.SCALE_DEFAULT);
            imagewithsnow= (BufferedImage) ImageIO.read(new File("valami")).getScaledInstance(64,64,Image.SCALE_DEFAULT);

        }catch(IOException e){
            System.out.println("Baj van - HoleView betoltese");
        }
    }
    @Override
    public void Draw(Graphics graphics) {
        if(hole.getLayerOfSnow()==0)
            graphics.drawImage(imagewithoutsnow,hole.X*64,hole.Y*64,null);
        else
            graphics.drawImage(imagewithsnow,hole.X*64,hole.Y*64,null);
    }

    @Override
    public void RefreshData() {

    }
}
