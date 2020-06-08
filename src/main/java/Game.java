import model.Board;
import model.Player;

import strategy.DiceStrategy;

import java.util.*;

public class Game {
    private List<Player> playerList;
    private Board board;

    public DiceStrategy getDiceStrategy() {
        return diceStrategy;
    }

    public void setDiceStrategy(DiceStrategy diceStrategy) {
        this.diceStrategy = diceStrategy;
    }

    private DiceStrategy diceStrategy;

    public Game(List<Player> playerList, Board board, DiceStrategy diceStrategy) {
        this.playerList = playerList;
        this.board = board;
        this.diceStrategy = diceStrategy;
    }

    void play(Player player) {
        int score = diceStrategy.rollDice();
        int nextPosition = board.getNextPosition(player.getPosition(), score);
        player.setPosition(nextPosition);
    }

    void playGame() {
        int i = 0;
        Map<Integer, Player> res = new HashMap<>();
        Queue<Player> queue = new ArrayDeque<>(playerList);
        while (queue.size() != 1) {
            Player player = queue.poll();
            play(player);
            if (!checkReachToEnd(player)) {
                queue.add(player);
            } else {
                i = i + 1;
                res.put(i, player);
            }
        }
        res.put(++i, queue.peek());
        declareResult(res);
    }

    private void declareResult(Map<Integer, Player> res) {
        res.forEach((k, v) -> System.out.println(v + " ranks " + k));
    }

    private boolean checkReachToEnd(Player player) {
        return player.getPosition() == 100;
    }
}
