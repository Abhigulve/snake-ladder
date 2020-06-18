package model;

import exception.InvalidPositionException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class CellTest {

    @Test(expected = InvalidPositionException.class)
    public void testInvalidMove() throws InvalidPositionException {
        new Cell(2).setMove(new Snake(4));
    }

    @Test
    public void testValidMove() throws InvalidPositionException {
        Cell cell = new Cell(12);
        Snake move = new Snake(4);
        cell.setMove(move);
        Assert.assertEquals(move, cell.getMove());
    }
}