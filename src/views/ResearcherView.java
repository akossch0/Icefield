package views;

import Field.Field;
import Player.Researcher;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ResearcherView implements IView {
    Researcher researcher;
    BufferedImage image;
    ResearcherView(Researcher r){
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/researcher.png"));

        }
        catch(IOException ex) {
            System.out.println("nem jo az Eskimo rajzolas");
        }
        researcher = r;}
    @Override
    public void Draw(Graphics graphics) {

        Field field = researcher.getField();
        float index = field.getEntites().indexOf(researcher);
        float entities = field.getEntites().size();
        int tilt = (int)(-10+index/entities*10 )>20? 20:(int)(-10+index/entities*10);
        // graphics.drawImage(image, (int) (field.X*64)+tilt, field.Y*64, null );
        graphics.drawImage(image, field.X*64, field.Y*64, null );
    }

    @Override
    public void RefreshData() {

    }
}
