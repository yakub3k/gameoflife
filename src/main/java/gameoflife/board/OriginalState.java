package gameoflife.board;

import game.GameRules;
import game.GameState;

public class OriginalState implements GameState {
    private final Cell[][] original;
    private final Cell[][] mirror;
    private GameRules rules;
    private int width;
    private int height;
    private GameState nextState;
    private String insertModel;

    OriginalState(Cell[][] original, Cell[][] mirror, GameRules rules) {
        this.original = original;
        this.mirror = mirror;
        this.rules = rules;
    }

    @Override
    public void switchCell(int x, int y) {
        if (x < width && y < height)
            this.original[x][y].setOpposite();
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (x < width && y < height && x >= 0 && y >= 0) {
            return original[x][y].isAlive();
        } else {
            return false;
        }
    }

    @Override
    public void setAlive(int x, int y) {
        if (x < width && y < height)
            this.original[x][y].setAlive();
    }

    @Override
    public void setDead(int x, int y) {
        if (x < width && y < height)
            this.original[x][y].setInactive();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void blackAll() {
        blackAll(original);
    }

    @Override
    public void clearAll() {
        clearAll(original);
    }

    @Override
    public void randomAll() {
        randomAll(original);
    }


    @Override
    public void chessAll() {
        chessAll(original);
    }

    @Override
    public void step() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                mirror[x][y].setAlive(original[x][y].isAliveInNextStep());
            }
        }
    }

    @Override
    public GameState nextStep() {
        return this.nextState;
    }

    @Override
    public GameRules getRules() {
        return rules;
    }

    @Override
    public void setNextState(GameState next) {
        this.nextState = next;
    }

    @Override
    public void setDimens(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
