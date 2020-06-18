package model;

import exception.InvalidPositionException;
import model.Board;
import model.Cell;
import model.Snake;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        List<Cell> cells = getCells(100);
        board = new Board(cells);
    }

    @Test
    public void getNextPositionTest() {
        int nextPosition = board.getNextPosition(2, 5);
        Assert.assertEquals(nextPosition, 7);
    }

    @Test
    public void testGetNextPositionWhenCurrentPositionIsAtEnd() {
        int nextPosition = board.getNextPosition(100, 5);
        Assert.assertEquals(100, nextPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPositionWhenCurrentPositionIsLessThanZero() {
        board.getNextPosition(-1, 5);
    }


    @Test
    public void testGetPositionWhenMoveIsNull() {
        int nextPosition = board.getNextPosition(12, 5);
        Assert.assertEquals(17, nextPosition);
    }

    @Test
    public void testGetPositionWhenMoveIsNotNull() throws InvalidPositionException {
        board.getCells().get(10).setMove(new Snake(1));
        int nextPosition = board.getNextPosition(10, 1);
        Assert.assertEquals(1, nextPosition);
    }

    public static List<Cell> getCells(int numberOfCells) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 1; i <= numberOfCells; i++) {
            cells.add(new Cell(i));
        }
        return cells;
    }
}
