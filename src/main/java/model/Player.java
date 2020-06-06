package model;

public class Player {
    private int position;
    private String playerName;

    public int getPosition() {
        return position;
    }

    public Player(int position, String playerName) {
        this.position = position;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
