package gameoflife.rules;

import game.GameRules;
import gameoflife.board.Cell;

import java.util.Arrays;
import java.util.List;


public class ConwayRulesWall implements GameRules {
    private final Cell border;

    private final boolean[] transformLive;
    private final boolean[] transformDead;

    public ConwayRulesWall() {
        this(TRANSFORM_LIVE, TRANSFORM_DEAD);
    }

    public ConwayRulesWall(boolean[] transformLive, boolean[] transformDead) {
        this.border = new Cell(this);
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
        boolean leftWall = x <= 0;
        boolean rightWall = x + 1 >= width;
        boolean topWall = y <= 0;
        boolean bottomWall = y + 1 >= height;

        Cell leftTop = leftWall || topWall ? border : matrix[x - 1][y - 1];
        Cell leftMid = leftWall ? border : matrix[x - 1][y];
        Cell leftBottom = leftWall || bottomWall ? border : matrix[x - 1][y + 1];
        Cell centralTop = topWall ? border : matrix[x][y - 1];
        Cell centralBottom = bottomWall ? border : matrix[x][y + 1];
        Cell rightTop = rightWall || topWall ? border : matrix[x + 1][y - 1];
        Cell rightMid = rightWall ? border : matrix[x + 1][y];
        Cell rightBottom = rightWall || bottomWall ? border : matrix[x + 1][y + 1];

        return Arrays.asList(leftTop, leftMid, leftBottom, centralTop, centralBottom, rightTop, rightMid, rightBottom);
    }
}
