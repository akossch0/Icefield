package views;

import Field.*;
import Game.*;
import Item.*;
import Player.*;
import Prototype.Test;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Az jatekmenet kozben megjeleno framert felelos osztaly
 */
public class GameplayFrame {
    private static HashMap<String, Player> players = new HashMap<String, Player>();
    private static ArrayList<Field> fields = new ArrayList<Field>();
    static Field chosenField;
    public volatile static Player currentPlayer;
    volatile static Player chosenPlayer;
    static String chosenPlayerName;
    private Item chosenItem;
    private JPanel mainPanel;
    private JPanel drawPanel;
    private JPanel informationPanel;
    private JPanel info1;
    private JPanel buttons;
    private JPanel info2;
    private JButton bStep;
    private DefaultListModel playerListModel;
    private JList jplayerList;
    private DefaultListModel itemListModel;
    private JList jItemList;
    private JButton bUseAbility;
    private JButton bDig;
    private JButton bUseItem;
    private JButton bPickUpItem;
    private JButton bEndTurn;
    private JLabel lCurrentPlayer;
    private JLabel lNumberOfWorkUnits;
    private JLabel lItems;
    private JLabel lPlayers;
    private JLabel currentPlayerLabel;
    private JLabel numberofWorkUnitsLabel;
    private JLabel numberofActualHealthLabel;
    private JButton bUp;
    private JButton bLeft;
    private JButton bDown;
    private JButton bRight;
    private Timer timer;
    /**
     * konstruktor
     */
    public GameplayFrame() {
        $$$setupUI$$$();
        InitListeners();
    }
    /**
     * random valaszt a directionok kozul
     * @return
     */
    private Direction randomDir() {
        int pick = new Random().nextInt(Direction.values().length);
        return Direction.values()[pick];
    }
    /**
     * frissiti a nezetet
     */
    void UpdateComponents() {
        drawPanel.repaint();
        currentPlayerLabel.setText(Test.getKeyByValue(players, currentPlayer));
        numberofWorkUnitsLabel.setText(String.valueOf(currentPlayer.getActualWorkUnit()));
        numberofActualHealthLabel.setText(String.valueOf(currentPlayer.getActualHealth()));
        refreshItemListModel();
    }
    /**
     * a listenerek inicializalasaert felelos osztaly
     */
    void InitListeners() {
        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateComponents();
            }
        });
        timer.start();

        bUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenField(Direction.UP);
            }
        });
        bLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenField(Direction.LEFT);
            }
        });
        bDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenField(Direction.DOWN);
            }
        });
        bRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenField(Direction.RIGHT);
            }
        });
        bStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chosenField != null) {
                    currentPlayer.Step(chosenField);

                }
                chosenField = null;
                UpdateComponents();
            }
        });
        bUseAbility.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPlayer instanceof Researcher) {
                    if (chosenField != null){
                        currentPlayer.UseAbility(chosenField);
                        chosenField.isInspected = true;
                    }

                } else {
                    currentPlayer.UseAbility(currentPlayer.getField());

                }
                chosenField = null;
                UpdateComponents();
            }
        });
        bDig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.Dig();
                chosenField = null;
                UpdateComponents();
            }
        });
        bUseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(chosenItem instanceof Rope)) {
                    if (chosenItem instanceof Tent)
                        Game.getInstance().getView().AddView(new TentCoverView(currentPlayer.getField()));
                    currentPlayer.UseItem(chosenItem, currentPlayer);
                } else if (chosenItem instanceof Rope) {
                    List<Entity> entities = chosenField.getEntites();
                    int index = 0;
                    while (entities != null && index < entities.size()) {
                        if (entities.get(index) instanceof Player) {
                            chosenPlayer = (Player) entities.get(index);
                            currentPlayer.UseItem(chosenItem, chosenPlayer);
                            break;
                        } else
                            index++;
                    }
                } else {
                    System.out.println("Nem jó a Useitem kiválasztás!");
                }
                chosenField = null;
                UpdateComponents();
            }
        });
        bPickUpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.PickUpItem();
                chosenField = null;
                UpdateComponents();
            }
        });
        bEndTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlayer.setActualWorkUnit(0);
                currentPlayer.EndTurn();
                chosenField = null;
                UpdateComponents();
            }
        });
        jplayerList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                chosenPlayerName = ((String) jplayerList.getSelectedValue()).split(" | ")[0];
                chosenPlayer = players.get(chosenPlayerName);
            }
        });
        jItemList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                chosenItem = (Item) jItemList.getSelectedValue();
                jItemList.setSelectedValue(chosenItem, false);
            }
        });
    }
    /**
     * beallitja a kivalalasztott irany alapjon a kivalasztott fieldet
     * @param dir a kivalasztott irany
     */
    public static void setChosenField(Direction dir) {
        chosenField = currentPlayer.getField().getNeighboursWithDir().get(dir);
    }
    /**
     * visszaadja a soron levo jatekost
     * @return
     */
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    /**
     * visszaadja a kivalasztott fieldet
     * @return
     */
    public static Field getChosenField() {
        return chosenField;
    }
    /**
     * futtatja a jatek frame-jet
     * @param ps
     */
    public static void Run(HashMap<String, String> ps) {
        Game.getInstance().InitMap();
        int i = 0;
        for (String name : ps.keySet()) {
            Player p;
            if (ps.get(name).equals("Eskimo")) {
                p = new Eskimo();
                Game.getInstance().getView().AddView(new EskimoView((Eskimo) p));
            } else {
                p = new Researcher();
                Game.getInstance().getView().AddView(new ResearcherView((Researcher) p));
            }
            fields = Game.getFields();
            while (true) {
                int randField = (new Random()).nextInt(fields.size());
                int polarIndex = fields.get(randField).getEntites().indexOf(PolarBear.getInstance());
                if (fields.get(randField) instanceof IceBlock && polarIndex == -1) {
                    p.setField(fields.get(randField));
                    break;
                }
            }

            players.put(name, p);
            if (i == 0) {
                currentPlayer = p;
            }
            i++;
        }
        JFrame frame = new JFrame("Gameplay");
        frame.setContentPane(new GameplayFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        //opens in the center of the monitor
        frame.setLocationRelativeTo(null);

        Thread thread = new Thread("My Thread") {
            public void run() {
                try {
                    Manager.Start();
                    Thread gamestate = new Thread("gamestate") {
                        public void run() {
                            try {
                                if (Game.getInstance().isGameWon() || Game.getInstance().isGameLost()) {
                                    frame.dispose();
                                    if (Game.getInstance().isGameLost()) {
                                        GameLostFrame.Run();
                                    } else if (Game.getInstance().isGameWon()) {
                                        GameWonFrame.Run();
                                    }
                                }
                            } catch (Exception e) {

                            }
                        }
                    };
                    gamestate.start();
                } catch (Exception e) {

                }
            }
        };
        thread.start();
    }

    /**
     * item listmodel frissiteseert felelos
     */
    public void refreshItemListModel() {
        itemListModel.removeAllElements();
        int i = 0;
        if (currentPlayer != null) {
            for (Item item : currentPlayer.getItems()) {
                itemListModel.add(i, item);
                i++;
            }
            if (chosenItem != null && currentPlayer.getItems().indexOf(chosenItem) == -1)
                chosenItem = null;
            else
                jItemList.setSelectedValue(chosenItem, false);
        }
    }

    /**
     * altalunk custom letrehozott komponensek
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new JPanel();

        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Game.getInstance().getView().setGraphics(g);
                Game.getInstance().getView().Update();
            }
        };
        informationPanel = new JPanel();
        playerListModel = new DefaultListModel();
        int i = 0;
        for (String str : players.keySet()) {
            playerListModel.add(i, str + " | " + players.get(str).toString());
            i++;
        }
        i = 0;
        jplayerList = new JList(playerListModel);

        itemListModel = new DefaultListModel();
        if (currentPlayer != null) {
            for (Item item : currentPlayer.getItems()) {
                itemListModel.add(i, item);
                i++;
            }
        }
        jItemList = new JList(itemListModel);


        mainPanel.setPreferredSize(new Dimension(1200, 900));
        drawPanel.setPreferredSize(new Dimension(900, 900));
        informationPanel.setPreferredSize(new Dimension(300, 900));
        bDown = new JButton();
        bUp = new JButton();
        bLeft = new JButton();
        bRight = new JButton();
        currentPlayerLabel = new JLabel();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setAutoscrolls(false);
        mainPanel.setBackground(new Color(-8541700));
        mainPanel.setEnabled(true);
        mainPanel.setFocusCycleRoot(true);
        mainPanel.setFocusTraversalPolicyProvider(true);
        mainPanel.setInheritsPopupMenu(true);
        mainPanel.setVerifyInputWhenFocusTarget(true);
        mainPanel.setVisible(true);
        informationPanel = new JPanel();
        informationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        informationPanel.setPreferredSize(new Dimension(300, 900));
        mainPanel.add(informationPanel, BorderLayout.EAST);
        info1 = new JPanel();
        info1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        info1.setBackground(new Color(-3941126));
        info1.setPreferredSize(new Dimension(300, 450));
        informationPanel.add(info1);
        lCurrentPlayer = new JLabel();
        Font lCurrentPlayerFont = this.$$$getFont$$$("Consolas", -1, 14, lCurrentPlayer.getFont());
        if (lCurrentPlayerFont != null) lCurrentPlayer.setFont(lCurrentPlayerFont);
        lCurrentPlayer.setPreferredSize(new Dimension(150, 30));
        lCurrentPlayer.setRequestFocusEnabled(true);
        lCurrentPlayer.setText("Current player:");
        info1.add(lCurrentPlayer);
        currentPlayerLabel = new JLabel();
        currentPlayerLabel.setPreferredSize(new Dimension(100, 30));
        currentPlayerLabel.setText("");
        info1.add(currentPlayerLabel);
        lNumberOfWorkUnits = new JLabel();
        Font lNumberOfWorkUnitsFont = this.$$$getFont$$$("Consolas", -1, 14, lNumberOfWorkUnits.getFont());
        if (lNumberOfWorkUnitsFont != null) lNumberOfWorkUnits.setFont(lNumberOfWorkUnitsFont);
        lNumberOfWorkUnits.setPreferredSize(new Dimension(150, 30));
        lNumberOfWorkUnits.setText("Actual work unit:");
        info1.add(lNumberOfWorkUnits);
        numberofWorkUnitsLabel = new JLabel();
        numberofWorkUnitsLabel.setPreferredSize(new Dimension(100, 30));
        numberofWorkUnitsLabel.setText("");
        info1.add(numberofWorkUnitsLabel);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Consolas", -1, 14, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setPreferredSize(new Dimension(150, 30));
        label1.setText("Actual health:");
        info1.add(label1);
        numberofActualHealthLabel = new JLabel();
        numberofActualHealthLabel.setPreferredSize(new Dimension(100, 30));
        numberofActualHealthLabel.setText("");
        info1.add(numberofActualHealthLabel);
        lItems = new JLabel();
        Font lItemsFont = this.$$$getFont$$$("Consolas", -1, 14, lItems.getFont());
        if (lItemsFont != null) lItems.setFont(lItemsFont);
        lItems.setHorizontalAlignment(0);
        lItems.setPreferredSize(new Dimension(250, 30));
        lItems.setText("Items:");
        info1.add(lItems);
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setPreferredSize(new Dimension(300, 130));
        info1.add(scrollPane1);
        jItemList.setPreferredSize(new Dimension(300, 130));
        scrollPane1.setViewportView(jItemList);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.setBackground(new Color(-3941126));
        panel1.setPreferredSize(new Dimension(300, 180));
        info1.add(panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel2.setBackground(new Color(-3941126));
        panel2.setPreferredSize(new Dimension(300, 80));
        panel1.add(panel2);
        bUp.setBackground(new Color(-12828607));
        bUp.setFocusable(false);
        Font bUpFont = this.$$$getFont$$$("Consolas", Font.BOLD, 18, bUp.getFont());
        if (bUpFont != null) bUp.setFont(bUpFont);
        bUp.setForeground(new Color(-131077));
        bUp.setPreferredSize(new Dimension(90, 80));
        bUp.setText("UP");
        panel2.add(bUp);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));
        panel3.setBackground(new Color(-3941126));
        panel3.setPreferredSize(new Dimension(300, 80));
        panel1.add(panel3);
        bLeft.setBackground(new Color(-12828607));
        Font bLeftFont = this.$$$getFont$$$("Consolas", Font.BOLD, 18, bLeft.getFont());
        if (bLeftFont != null) bLeft.setFont(bLeftFont);
        bLeft.setForeground(new Color(-131077));
        bLeft.setPreferredSize(new Dimension(90, 80));
        bLeft.setText("LEFT");
        panel3.add(bLeft);
        bDown.setBackground(new Color(-12828607));
        Font bDownFont = this.$$$getFont$$$("Consolas", Font.BOLD, 18, bDown.getFont());
        if (bDownFont != null) bDown.setFont(bDownFont);
        bDown.setForeground(new Color(-131077));
        bDown.setPreferredSize(new Dimension(90, 80));
        bDown.setText("DOWN");
        panel3.add(bDown);
        bRight.setBackground(new Color(-12828607));
        Font bRightFont = this.$$$getFont$$$("Consolas", Font.BOLD, 18, bRight.getFont());
        if (bRightFont != null) bRight.setFont(bRightFont);
        bRight.setForeground(new Color(-131077));
        bRight.setPreferredSize(new Dimension(90, 80));
        bRight.setText("RIGHT");
        panel3.add(bRight);
        buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        buttons.setBackground(new Color(-3941126));
        buttons.setPreferredSize(new Dimension(300, 280));
        informationPanel.add(buttons);
        bStep = new JButton();
        bStep.setAlignmentX(0.0f);
        bStep.setBackground(new Color(-12828607));
        Font bStepFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 20, bStep.getFont());
        if (bStepFont != null) bStep.setFont(bStepFont);
        bStep.setForeground(new Color(-1));
        bStep.setPreferredSize(new Dimension(220, 40));
        bStep.setText("Step");
        buttons.add(bStep);
        bUseAbility = new JButton();
        bUseAbility.setAlignmentX(0.0f);
        bUseAbility.setBackground(new Color(-12828607));
        Font bUseAbilityFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 20, bUseAbility.getFont());
        if (bUseAbilityFont != null) bUseAbility.setFont(bUseAbilityFont);
        bUseAbility.setForeground(new Color(-1));
        bUseAbility.setPreferredSize(new Dimension(220, 40));
        bUseAbility.setText("Use Ability");
        buttons.add(bUseAbility);
        bDig = new JButton();
        bDig.setAlignmentX(0.0f);
        bDig.setBackground(new Color(-12828607));
        Font bDigFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 20, bDig.getFont());
        if (bDigFont != null) bDig.setFont(bDigFont);
        bDig.setForeground(new Color(-1));
        bDig.setPreferredSize(new Dimension(220, 40));
        bDig.setText("Dig");
        buttons.add(bDig);
        bUseItem = new JButton();
        bUseItem.setAlignmentX(0.0f);
        bUseItem.setBackground(new Color(-12828607));
        Font bUseItemFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 20, bUseItem.getFont());
        if (bUseItemFont != null) bUseItem.setFont(bUseItemFont);
        bUseItem.setForeground(new Color(-1));
        bUseItem.setPreferredSize(new Dimension(220, 40));
        bUseItem.setText("Use Item");
        buttons.add(bUseItem);
        bPickUpItem = new JButton();
        bPickUpItem.setAlignmentX(0.0f);
        bPickUpItem.setBackground(new Color(-12828607));
        Font bPickUpItemFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 20, bPickUpItem.getFont());
        if (bPickUpItemFont != null) bPickUpItem.setFont(bPickUpItemFont);
        bPickUpItem.setForeground(new Color(-1));
        bPickUpItem.setPreferredSize(new Dimension(220, 40));
        bPickUpItem.setText("Pick Up Item");
        buttons.add(bPickUpItem);
        bEndTurn = new JButton();
        bEndTurn.setAlignmentX(0.0f);
        bEndTurn.setBackground(new Color(-12828607));
        Font bEndTurnFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 20, bEndTurn.getFont());
        if (bEndTurnFont != null) bEndTurn.setFont(bEndTurnFont);
        bEndTurn.setForeground(new Color(-1));
        bEndTurn.setPreferredSize(new Dimension(220, 40));
        bEndTurn.setText("End Turn");
        buttons.add(bEndTurn);
        info2 = new JPanel();
        info2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        info2.setAutoscrolls(false);
        info2.setBackground(new Color(-3941126));
        info2.setPreferredSize(new Dimension(300, 190));
        informationPanel.add(info2);
        lPlayers = new JLabel();
        Font lPlayersFont = this.$$$getFont$$$("Consolas", -1, 14, lPlayers.getFont());
        if (lPlayersFont != null) lPlayers.setFont(lPlayersFont);
        lPlayers.setHorizontalAlignment(0);
        lPlayers.setPreferredSize(new Dimension(250, 30));
        lPlayers.setText("Players:");
        info2.add(lPlayers);
        final JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setPreferredSize(new Dimension(300, 140));
        info2.add(scrollPane2);
        jplayerList.setPreferredSize(new Dimension(300, 140));
        scrollPane2.setViewportView(jplayerList);
        drawPanel.setBackground(new Color(-8541700));
        drawPanel.setPreferredSize(new Dimension(900, 900));
        mainPanel.add(drawPanel, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
