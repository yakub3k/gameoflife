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
        this.border = new Cell(-1, -1, this);
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
        boolean bottomWall = y <= 0;
        boolean topWall = y + 1 >= height;

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

        Cell leftTop = leftWall && topWall ? border : matrix[left][top];
        Cell leftMid = leftWall ? border : matrix[left][y];
        Cell leftBottom = leftWall && bottomWall ? border : matrix[left][bottom];
        Cell centralTop = topWall ? border : matrix[x][top];
        Cell centralBottom = bottomWall ? border : matrix[x][bottom];
        Cell rightTop = rightWall && topWall ? border : matrix[right][top];
        Cell rightMid = rightWall ? border : matrix[right][y];
        Cell rightBottom = rightWall && bottomWall ? border : matrix[right][bottom];

        return Arrays.asList(leftTop, leftMid, leftBottom, centralTop, centralBottom, rightTop, rightMid, rightBottom);
    }
}
