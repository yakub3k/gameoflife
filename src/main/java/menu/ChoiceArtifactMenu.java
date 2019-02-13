package menu;

import game.ArtifactGame;
import game.Game;
import gameoflife.artefact.Artifactory;
import util.Log;

import javax.swing.*;
import java.awt.*;

public class ChoiceArtifactMenu extends JFrame {

    public ChoiceArtifactMenu(ArtifactGame game) throws HeadlessException {

        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        Box box = Box.createVerticalBox();
        Artifactory gameArtifactory = game.getArtifactory();
        for (String model : gameArtifactory.getArtifacts()) {
            JButton button = new JButton(model);
            button.addActionListener(c -> {
                String selectModel = c.getActionCommand();
                Log.log("Select model: " + selectModel);
                game.setInsertModel(selectModel);
            });
            box.add(button);
        }
        add(box);

        setPreferredSize(new Dimension(200, 260));
        setMinimumSize(new Dimension(100, 100));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}
