import exception.InvalidPositionException;
import model.Board;
import model.Cell;
import model.Player;
import model.Snake;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import strategy.CrookedDice;
import strategy.DiceStrategy;
import strategy.NormalDice;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private Game game;
    List<Player> playerList;
    Board board;
    DiceStrategy diceStrategy;

    @Before
    public void before() {
        List<Player> playerList;
        Board board;
        DiceStrategy diceStrategy;
        playerList = new ArrayList<>();
        playerList.add(new Player(0, "A"));
        playerList.add(new Player(0, "B"));
        List<Cell> cells = getCells(100);
        board = new Board(cells);
        diceStrategy = new CrookedDice();
        game = new Game(playerList, board, diceStrategy);
    }

    @Test
    public void normalDiceTest() {
        game.setDiceStrategy(new NormalDice());
        game.playGame();
    }

    @Test
    public void crookedDiceTest() {
        game.setDiceStrategy(new CrookedDice());
    }

    @Test(expected = InvalidPositionException.class)
    public void invalidMoveTest() throws InvalidPositionException {
        List<Cell> cells = getCells(100);
        cells.get(2).setMove(new Snake(4));
    }

    @Test
    public void validMoveTest() throws InvalidPositionException {
        List<Cell> cells = getCells(100);
        Snake move = new Snake(0);
        cells.get(2).setMove(move);
        Assert.assertEquals(cells.get(2).getMove(), move);
    }

    private List<Cell> getCells(int numberOfCells) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 1; i <= numberOfCells; i++) {
            cells.add(new Cell(i));
        }
        return cells;
    }
}
