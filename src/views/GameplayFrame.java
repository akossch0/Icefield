package views;

import javax.swing.*;
import java.awt.*;

public class GameplayFrame {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel informationPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel.setPreferredSize(new Dimension(1200, 900));
        centerPanel.setPreferredSize(new Dimension(900, 900));
        informationPanel.setPreferredSize(new Dimension(300, 900));
    }
}
