package gameoflife.rules;


import gameoflife.board.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConwayRulesWallTest {
    private Cell[][] matrix = new Cell[10][10];

    @Test
    public void border() {
        ConwayRulesWall wall = new ConwayRulesWall();

        List<Cell> neighbors = wall.getNeighbors(matrix, 9, 9, 10, 10);

        Assert.assertEquals(8, neighbors.size());
    }
}