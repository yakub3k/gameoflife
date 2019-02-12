package gameoflife;

import game.Game;
import game.GameRules;
import gameoflife.board.GameBoardCreator;
import game.GameState;
import util.Log;

public class GameOfLife implements Game {

    private final int height;
    private final int width;
    private final GameRules rules;
    private GameState currentGame;

    public GameOfLife(int fieldsWidth, int fieldsHeight, GameRules rules) {
        this.height = fieldsHeight; // y
        this.width = fieldsWidth;   // x
        this.rules = rules;
        this.currentGame = new GameBoardCreator(width, height, rules).createBaseGame();
        Log.log("create game width:" + width + " height:" + height);
    }

    @Override
    public void switchCell(int x, int y) {
        this.currentGame.switchCell(x, y);
    }

    @Override
    public boolean isAlive(int x, int y) {
        return currentGame.isAlive(x,y);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void blackAll() {
        currentGame.blackAll();
    }

    @Override
    public void step() {
        currentGame.step();
        currentGame = currentGame.nextStep();
    }

    @Override
    public GameState nextStep() {
        return currentGame.nextStep();
    }

    @Override
    public GameRules getRules() {
        return rules;
    }

    @Override
    public void clearAll() {
        currentGame.clearAll();
    }

    @Override
    public void randomAll() {
        currentGame.randomAll();
    }

    @Override
    public void chessAll() {
        currentGame.chessAll();
    }
}
