package game;

import gameoflife.board.Cell;

import java.util.List;

public interface GameRules {
    boolean isAliveInNextStep(Cell current, List<Cell> neighbors);

    @SuppressWarnings("Duplicates")
    List<Cell> getNeighbors(Cell[][] matrix, int x, int y, int width, int height);
}
