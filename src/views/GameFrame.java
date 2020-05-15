package views;

import Field.Field;
import Game.Game;
import Item.Item;
import Player.Player;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    static Field chosenField;
    static Player currentPlayer;
    static Player chosenPlayer;
    static Item chosenItem;
    private JPanel panel1;
    private JButton startButton;
    private JButton exitButton;

    public GameFrame() {
        super("Icefield");
        this.setPreferredSize(new Dimension(1000, 800));
        this.setResizable(false);
        InitComponents();
    }

    public static void Run(String[] args) {
        JFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //opens in the center of the monitor
        frame.setLocationRelativeTo(null);
    }

    public void initListeners() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().StartGame();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void InitComponents() {

    }

    public static void setChosenField(Direction dir) {

    }

    public static void setChosenPlayer(Player p) {
        chosenPlayer = p;
    }

    public static void setChosenItem(Item i) {
        chosenItem = i;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
    }

}
