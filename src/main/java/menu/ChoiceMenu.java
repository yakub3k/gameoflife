package menu;

import gameoflife.rules.ConwayRulesInfinity;
import gameoflife.rules.ConwayRulesMirror;
import gameoflife.rules.ConwayRulesWall;

import javax.swing.*;
import java.awt.*;

public class ChoiceMenu extends JFrame {
    private final JButton conwayInfinite;
    private final JButton conwayWall;
    private final JButton conwayMirror;
    private final JButton genericGame;
    private final GameStarter starter = new GameStarter();

    public ChoiceMenu() throws HeadlessException {
        this.conwayInfinite = new JButton("Conway Infinite");
        this.conwayWall = new JButton("Conway Wall");
        this.conwayMirror = new JButton("Conway Mirrror");
        this.genericGame = new JButton("Generic Game");

        Container content = getContentPane();
        Box box = Box.createHorizontalBox();
        box.add("conway 1", conwayInfinite);
        box.add("conway 2", conwayWall);
        box.add("conway 3", conwayMirror);
        box.add("conway 4", genericGame);

        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        this.add(conwayInfinite, 0);
        this.add(conwayWall, 1);
        this.add(conwayMirror, 2);
        this.add(genericGame, 3);

        initButtons();
        setPreferredSize(new Dimension(100, 200));
        setMinimumSize(new Dimension(100, 100));
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void initButtons() {
        conwayInfinite.addActionListener(c -> starter.startGame(new ConwayRulesInfinity()));
        conwayWall.addActionListener(c -> starter.startGame(new ConwayRulesWall()));
        conwayMirror.addActionListener(c -> starter.startGame(new ConwayRulesMirror()));
        genericGame.addActionListener(c -> GenericGame.showWindow());
    }
}
