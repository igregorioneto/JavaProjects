package org.tic_tac_toe.model;

public class TicTacToe {
    GameBoard gb;
    public TicTacToe() {
        Player p1 = new Player();
        gb = new GameBoard();
    }

    @Override
    public String toString() {
        return "Tic Tac Toe" + gb.toString();
    }
}
