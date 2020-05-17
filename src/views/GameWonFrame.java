package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWonFrame {
    private static JFrame gameWonFrame;
    private JPanel mainPanel;
    private JPanel jTextPanel;
    private JLabel lGameWon;
    private JPanel jButtonsPanel;
    private JPanel jTryPanel;
    private JButton bPlayAgain;
    private JPanel jExitPanel;
    private JButton bExit;

    public GameWonFrame(){
        InitListeners();
    }

    void InitListeners(){
        bPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] args = new String[0];
                GameFrame.Run(args);
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWonFrame.setVisible(false);
                gameWonFrame.dispose();
            }
        });
    }


    public static void Run() {
        JFrame frame = new JFrame("Game Won");
        frame.setContentPane(new GameWonFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        //opens in the center of the monitor
        frame.setLocationRelativeTo(null);
        gameWonFrame = frame;
    }
}
