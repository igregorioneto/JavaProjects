package com.tictactoe.entities;

public class Cell {
    private Player player;

    public Cell() {
        player = Player.EMPTY;
    }

    public boolean isEmpty() {
        return player == Player.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
