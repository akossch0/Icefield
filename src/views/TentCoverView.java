package views;

import Coverable.TentCover;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TentCoverView implements IView{
    TentCover tentCover;

    TentCoverView(TentCover t){
        tentCover = t;

    }
    @Override
    public void Draw(Graphics graphics) {

    }

    @Override
    public void RefreshData() {

    }
}
