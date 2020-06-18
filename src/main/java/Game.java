import exception.InvalidPlayerException;
import model.Board;
import model.Player;

import strategy.Dice;

import java.util.*;

public class Game {
    private List<Player> playerList;
    private Board board;
    private Dice dice;
    private Map<Integer, Player> res;
    private int winnerCount;

    public Map<Integer, Player> getRes() {
        return res;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Game(List<Player> playerList, Board board, Dice dice) {
        this.playerList = playerList;
        this.board = board;
        this.dice = dice;
        this.res = new HashMap<>();
    }

    void play(Player player) throws InvalidPlayerException {
        if (!checkReachToEnd(player)) {
            int score = dice.rollDice();
            int nextPosition = board.getNextPosition(player.getPosition(), score);
            player.setPosition(nextPosition);
            if (checkReachToEnd(player))
                res.put(++winnerCount, player);
        } else throw new InvalidPlayerException("player already reach end of game");
    }

    void playGame() throws InvalidPlayerException {
        int i = 0;
        Queue<Player> queue = new ArrayDeque<>(playerList);
        while (queue.size() != 1) {
            Player player = queue.poll();
            play(player);
            if (!checkReachToEnd(player)) {
                queue.add(player);
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
