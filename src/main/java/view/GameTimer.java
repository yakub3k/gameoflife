package view;

import game.Game;

import java.util.TimerTask;


public class GameTimer extends TimerTask {

    private Game game;

    public GameTimer(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.step();
    }
}
