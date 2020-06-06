package model;

import exception.InvalidPositionException;

public abstract class Move {
    protected int nextPosition;

    public Move(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    public int getPosition() {
        return nextPosition;
    }
    abstract public void setNextPosition(int startPosition, int endPosition) throws InvalidPositionException;

    public abstract boolean checkPosition(int cellPosition) throws InvalidPositionException;
}
