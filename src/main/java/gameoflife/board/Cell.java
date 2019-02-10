package gameoflife.board;

import game.GameCell;
import game.GameRules;

import java.util.List;

public class Cell implements GameCell {
    private boolean alive;
    private int pos_x;
    private int pos_y;
    private GameRules rules;
    private List<Cell> neighbours;

    public Cell(int x, int y, GameRules rules) {
        this.pos_x = x;
        this.pos_y = y;
        this.rules = rules;
        this.alive = false;
    }

    @Override
    public boolean checkNeighbours() {
        return false;//todo
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
