package gameoflife.board;

import game.GameRules;
import game.GameState;

import java.util.List;

public class GameBoardCreator {

    private final Cell[][] cells;
    private final Cell[][] mirror;
    private int width;
    private int height;
    private GameRules rules;

    public GameBoardCreator(int width, int height, GameRules rules) {
        this.width = width;
        this.height = height;
        this.rules = rules;
        this.cells = setupCells(width, height);
        this.mirror = setupCells(width, height);
    }

    public GameState createBaseGame() {
        GameState originalState = new OriginalState(cells, mirror, this.rules);
        GameState mirrorState = new MirrorState(cells, mirror, this.rules);
        originalState.setDimens(width, height);
        mirrorState.setDimens(width, height);

        originalState.setNextState(mirrorState);
        mirrorState.setNextState(originalState);

        return originalState;
    }


    private Cell[][] setupCells(int x, int y) {
        Cell[][] result = new Cell[width][height];

        // Create cells
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = new Cell(i, j, rules);
            }
        }

        // Set neighbors in cells
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                List<Cell> neighbors = getNeighbors(result, i, j);
                result[i][j].setNeighbours(neighbors);
            }
        }

        return result;
    }

    @SuppressWarnings("Duplicates")
    private List<Cell> getNeighbors(Cell[][] matrix, int x, int y) {
        return rules.getNeighbors(matrix, x, y, width, height);
    }
}
