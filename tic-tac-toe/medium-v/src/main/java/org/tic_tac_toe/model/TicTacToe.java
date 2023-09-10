package org.tic_tac_toe.model;

public class TicTacToe {
    private GameBoard gb;
    public TicTacToe() {
        gb = new GameBoard();
    }

    public GameBoard getGb() {
        return gb;
    }

    @Override
    public String toString() {
        return "Tic Tac Toe" + gb.toString();
    }
}
