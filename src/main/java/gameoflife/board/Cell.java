package gameoflife.board;

import game.GameCell;
import game.GameRules;

import java.util.List;

public class Cell implements GameCell {
    private boolean alive;
    private GameRules rules;
    private List<Cell> neighbours;

    public Cell(GameRules rules) {
        this.rules = rules;
        this.alive = false;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void setAlive() {
        this.alive = true;
    }

    @Override
    public void setInactive() {
        this.alive = false;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public boolean isAliveInNextStep() {
        return rules.isAliveInNextStep(this, neighbours);
    }

    @Override
    public void setOpposite() {
        this.alive = !alive;
    }

    void setNeighbours(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }
}
