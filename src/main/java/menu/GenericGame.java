package menu;

import gameoflife.rules.ConwayRulesInfinity;
import gameoflife.rules.ConwayRulesMirror;
import gameoflife.rules.ConwayRulesWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class GenericGame extends JPanel {

    private final JButton startButton;
    private final JTextField textField;
    private final CheckBoxPanel livePanel;
    private final CheckBoxPanel deadPanel;
    private JList list;

    static void showWindow() {
        JFrame frame = new JFrame("Generic Game");
        JComponent newContentPane = new GenericGame();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    private GenericGame() throws HeadlessException {
        super(new BorderLayout());

        textField = new JTextField(10);
        textField.setText("Start game");
        textField.setEditable(false);

        livePanel = new CheckBoxPanel("live");
        livePanel.selectDead();
        deadPanel = new CheckBoxPanel("dead");
        deadPanel.selectLive();

        startButton = new JButton("Game");
        startButton.addActionListener(startGameAction());

        add(createGameList(), BorderLayout.PAGE_START);
        JPanel checkBoxes = new JPanel();
        checkBoxes.add(deadPanel, 0);
        checkBoxes.add(livePanel, 1);
        add(checkBoxes, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.PAGE_END);
        setPreferredSize(new Dimension(400, 400));
        setLocation(600, 600);
    }

    private ActionListener startGameAction() {
        return c -> {
            boolean[] live = livePanel.getValue();
            boolean[] dead = deadPanel.getValue();
            int selectedGame = list.getSelectedIndex();
            GameStarter starter = new GameStarter();
            switch (selectedGame) {
                case 0:
                    starter.startGame(new ConwayRulesInfinity(live, dead));
                    break;
                case 1:
                    starter.startGame(new ConwayRulesMirror(live, dead));
                    break;
                case 2:
                    starter.startGame(new ConwayRulesWall(live, dead));
                    break;
            }
        };
    }

    private JScrollPane createGameList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Infinity");
        listModel.addElement("Mirror");
        listModel.addElement("Wall");

        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(3);
        return new JScrollPane(list);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(startButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(textField);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return buttonPane;
    }
}
