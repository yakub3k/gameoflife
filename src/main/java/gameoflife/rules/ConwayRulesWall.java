package gameoflife.rules;

import game.GameRules;
import gameoflife.board.Cell;

import java.util.Arrays;
import java.util.List;


public class ConwayRulesWall implements GameRules {
    private static final boolean LIVE = true;
    private static final boolean[] TRANSFORM_LIVE = new boolean[]
            {false, false, LIVE, LIVE, false, false, false, false, false};
    private static final boolean[] TRANSFORM_DEAD = new boolean[]
            {false, false, false, LIVE, false, false, false, false, false};
    private final Cell border;

    public ConwayRulesWall() {
        this.border = new Cell(this);
    }

    @Override
    public boolean isAliveInNextStep(Cell current, List<Cell> neighbors) {
        int livedNeighbors = getLivedNeighbors(neighbors);
        return current.isAlive()
                ? TRANSFORM_LIVE[livedNeighbors]
                : TRANSFORM_DEAD[livedNeighbors];
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
