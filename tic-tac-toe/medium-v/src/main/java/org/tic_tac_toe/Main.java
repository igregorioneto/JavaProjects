package org.tic_tac_toe;

import org.tic_tac_toe.model.TicTacToe;
import org.tic_tac_toe.view.GameView;

public class Main {
    public static void main(String[] args) {
        GameView gv = new GameView();
        gv.executingGame();
    }
}