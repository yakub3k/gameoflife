package menu;

import game.Artifact;
import game.ArtifactGame;
import game.Game;
import game.GameRules;
import gameoflife.GameOfLife;
import gameoflife.artefact.Artifactory;
import gameoflife.artefact.models.*;
import view.Window;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class GameStarter implements Serializable {
    private static final long serialVersionUID = 1L;


    void startGame(GameRules gameRules) {
        Artifactory artifactory = new Artifactory();
        List<Artifact> artifacts = Arrays.asList(new Dot(), new Glider(), new Loaf(), new Pentadecathlon(), new Pentomino(), new Tub());
        artifactory.addArtifacts(artifacts);
        ArtifactGame game = new GameOfLife(120, 60, gameRules, artifactory);
        Window win = new Window(game);
        win.setVisible(true);
    }
}
