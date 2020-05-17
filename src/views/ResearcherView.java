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
    BufferedImage blueimage;
    ResearcherView(Researcher r){
        try {
            image = (BufferedImage) ImageIO.read(new File("src/images/researcher.png"));
            blueimage = (BufferedImage) ImageIO.read(new File("src/images/researcher_blue.png"));

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
        if (researcher.isInWater())
            graphics.drawImage(blueimage, (int) (field.X*64)+tilt, field.Y*64, null );
        else
            graphics.drawImage(image, (int) (field.X*64)+tilt, field.Y*64, null );
        if (GameplayFrame.getCurrentPlayer().equals(researcher)){
            Graphics2D g2D = (Graphics2D) graphics;
            g2D.setColor(Color.red);
            g2D.setStroke(new BasicStroke(4));
            g2D.drawRect(field.X*64,field.Y*64, 64,64);
        }
    }
}
