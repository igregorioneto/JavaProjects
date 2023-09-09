package org.tic_tac_toe.controller;

import org.tic_tac_toe.model.TicTacToe;

public class GameController {
    private TicTacToe ticTacToe;

    public GameController() {
        ticTacToe = new TicTacToe();
    }

    public String board() {
        return ticTacToe.toString();
    }
}
