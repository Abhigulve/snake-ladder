package model;

import exception.InvalidPositionException;

public class Snake extends Move {
    public Snake(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public void setNextPosition(int startPosition, int endPosition) throws InvalidPositionException {
        if (startPosition > endPosition)
            this.nextPosition = endPosition;
        else throw new InvalidPositionException("cell current Position should always greater next position");
    }

    @Override
    public boolean checkPosition(int cellPosition) throws InvalidPositionException {
        if (cellPosition > nextPosition)
            return true;
        else throw new InvalidPositionException("cell position always greater that next position");
    }
}
