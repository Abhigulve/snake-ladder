package model;

import java.util.List;
import java.util.Optional;

public class Board {
    List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public Board(List<Cell> cells) {
        this.cells = cells;
    }

    public int getNextPosition(int currentPosition, int score) {
        if (currentPosition < 0) {
            throw new IllegalArgumentException("Position should be greater than zero");
        }
        Optional<Cell> nextCellByPosition = getNextCellByPosition(currentPosition + score);
        if (!nextCellByPosition.isPresent()) {
            return currentPosition;
        }
        Move move = nextCellByPosition.get().getMove();
        if (move != null) {
            return move.getNextPosition();
        }
        return nextCellByPosition.get().getPosition();
    }


    private Optional<Cell> getNextCellByPosition(int position) {
        return cells.stream().filter(cell -> cell.getPosition() == position)
                .findFirst();
    }
}
