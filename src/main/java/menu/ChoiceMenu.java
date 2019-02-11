package menu;

import gameoflife.rules.ConwayRulesInfinity;
import gameoflife.rules.ConwayRulesWall;

import javax.swing.*;
import java.awt.*;

public class ChoiceMenu extends JFrame {
    private final JButton conwayInfinite;
    private final JButton conwayWall;
    private final GameStarter starter = new GameStarter();

    public ChoiceMenu() throws HeadlessException {
        this.conwayInfinite = new JButton("Conway Infinite");
        this.conwayWall = new JButton("Conway Wall");

        Container content = getContentPane();
        Box box = Box.createHorizontalBox();
        box.add("conway 1", conwayInfinite);
        box.add("conway 2", conwayWall);

        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));


        this.add(conwayInfinite, 0);
        this.add(conwayWall, 1);

        initButtons();
        setMinimumSize(new Dimension(100, 100));
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void initButtons(){
        conwayInfinite.addActionListener(c ->
                starter.startGame(new ConwayRulesInfinity()));
        conwayWall.addActionListener(c ->
                starter.startGame(new ConwayRulesWall()));
    }
}