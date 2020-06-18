package model;

import exception.InvalidPositionException;

public class Cell {
    private int position;
    private Move move;

    public Cell(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    
    public Move getMove() {
        return move;
    }

    public void setMove(Move move) throws InvalidPositionException {
        if (move.isValidPosition(position)) {
            this.move = move;
        }
    }
}
