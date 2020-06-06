package model;

import java.util.List;

public class Board {
    List<Cell> cells;

    public Board(List<Cell> cells) {
        this.cells = cells;
    }

    public int getNextPosition(int currentPosition, int score) {
        Cell nextCellByPosition = getNextCellByPosition(currentPosition + score);
        Move move = nextCellByPosition.getMove();
        if (move != null) {
            return move.getPosition();
        }
        return nextCellByPosition.getPosition();
    }


    private Cell getNextCellByPosition(int position) {
        return cells.stream().filter(cell -> cell.getPosition() == position)
                .findFirst()
                .orElse(null);
    }
}
