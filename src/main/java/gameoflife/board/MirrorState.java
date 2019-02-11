package gameoflife.board;

import game.GameRules;
import game.GameState;

public class MirrorState implements GameState {
    private final Cell[][] original;
    private final Cell[][] mirror;
    private GameRules rules;
    private int width;
    private int height;
    private GameState nextState;

    MirrorState(Cell[][] original, Cell[][] mirror, GameRules rules) {
        this.original = original;
        this.mirror = mirror;
        this.rules = rules;
    }

    @Override
    public void switchCell(int x, int y) {
        this.mirror[x][y].setOpposite();
    }

    @Override
    public boolean isAlive(int x, int y) {
        return mirror[x][y].isAlive();
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
        blackAll(mirror);
    }

    @Override
    public void clearAll() {
        clearAll(mirror);
    }

    @Override
    public void randomAll() {
        randomAll(mirror);
    }

    @Override
    public void step() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                original[x][y].setAlive(mirror[x][y].isAliveInNextStep());
            }
        }
    }

    @Override
    public GameState nextStep() {
        return nextState;
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
