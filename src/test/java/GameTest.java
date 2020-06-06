import model.Board;
import model.Cell;
import model.Player;
import org.junit.Before;
import org.junit.Test;
import strategy.CrookedDice;
import strategy.DiceStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private Game game;

    @Before
    public void before() {
        List<Player> playerList;
        Board board;
        DiceStrategy diceStrategy;
        playerList = new ArrayList<>();
        playerList.add(new Player(1, "A"));
        playerList.add(new Player(1, "B"));
        board = new Board(getCells(100));
        diceStrategy = new CrookedDice();
        game = new Game(playerList, board, diceStrategy);

    }
    @Test
    public void Test(){
        game.playGame();
    }

    private List<Cell> getCells(int numberOfCells) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 1; i <= numberOfCells; i++) {
            cells.add(new Cell(i));
        }
        return cells;
    }
}
