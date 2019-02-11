package menu;

import game.Game;
import game.GameRules;
import gameoflife.GameOfLife;
import view.Window;

import java.io.Serializable;

class GameStarter implements Serializable {
    private static final long serialVersionUID = 1L;


    void startGame(GameRules gameRules) {
        Game game = new GameOfLife(120, 60, gameRules);
        Window win = new Window(game);
        win.setVisible(true);
    }
}
