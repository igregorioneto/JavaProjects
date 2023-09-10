package org.tic_tac_toe.controller;

import org.tic_tac_toe.model.Player;
import org.tic_tac_toe.model.TicTacToe;

public class GameController {
    private TicTacToe ticTacToe;

    public GameController() {
        ticTacToe = new TicTacToe();
    }

    public String board() {
        return ticTacToe.toString();
    }

    public void makePlay(int x, int y, Player p) {
        ticTacToe.getGb().makePlayerBoard(x, y, p);
    }

    public boolean startGame() {
        return ticTacToe.getGb().isStartGame();
    }

    public void setIsStartGame(boolean value) {
        ticTacToe.getGb().setStartGame(value);
    }
}
