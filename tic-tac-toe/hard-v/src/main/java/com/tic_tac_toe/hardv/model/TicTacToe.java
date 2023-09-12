package com.tic_tac_toe.hardv.model;

public class TicTacToe {
    private int x;
    private int y;

    public TicTacToe() {
    }

    public TicTacToe(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
