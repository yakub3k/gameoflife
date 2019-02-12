package game;

import gameoflife.board.Cell;

import java.util.List;

public interface GameRules {
    boolean LIVE = true;
    boolean[] TRANSFORM_LIVE = new boolean[]
            {false, false, LIVE, LIVE, false, false, false, false, false};
    boolean[] TRANSFORM_DEAD = new boolean[]
            {false, false, false, LIVE, false, false, false, false, false};

    boolean isAliveInNextStep(Cell current, List<Cell> neighbors);

    @SuppressWarnings("Duplicates")
    List<Cell> getNeighbors(Cell[][] matrix, int x, int y, int width, int height);
}
