package gameoflife.rules;

import game.GameRules;
import gameoflife.board.Cell;

import java.util.Arrays;
import java.util.List;


public class ConwayRulesInfinity implements GameRules {

    private final boolean[] transformLive;
    private final boolean[] transformDead;

    public ConwayRulesInfinity() {
        transformLive = TRANSFORM_LIVE;
        transformDead = TRANSFORM_DEAD;
    }

    public ConwayRulesInfinity(boolean[] transformLive, boolean[] transformDead) {
        this.transformLive = transformLive;
        this.transformDead = transformDead;
    }

    @Override
    public boolean isAliveInNextStep(Cell current, List<Cell> neighbors) {
        int livedNeighbors = getLivedNeighbors(neighbors);
        return current.isAlive()
                ? transformLive[livedNeighbors]
                : transformDead[livedNeighbors];
    }

    private int getLivedNeighbors(List<Cell> neighbors) {
        return (int) neighbors.stream()
                .filter(Cell::isAlive)
                .count();
    }

    @Override
    @SuppressWarnings("Duplicates")
    public List<Cell> getNeighbors(Cell[][] matrix, int x, int y, int width, int height) {
        int left = x > 0
                ? x - 1
                : width - 1;
        int right = (x + 1) < width
                ? x + 1
                : 0;
        int top = y > 0
                ? y - 1
                : height - 1;
        int bottom = (y + 1) < height
                ? y + 1
                : 0;

        Cell leftTop = matrix[left][top];
        Cell leftMid = matrix[left][y];
        Cell leftBottom = matrix[left][bottom];
        Cell centralTop = matrix[x][top];
        Cell centralBottom = matrix[x][bottom];
        Cell rightTop = matrix[right][top];
        Cell rightMid = matrix[right][y];
        Cell rightBottom = matrix[right][bottom];

        return Arrays.asList(leftTop, leftMid, leftBottom, centralTop, centralBottom, rightTop, rightMid, rightBottom);
    }
}
