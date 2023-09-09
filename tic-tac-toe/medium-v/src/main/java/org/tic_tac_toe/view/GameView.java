package org.tic_tac_toe.view;

import org.tic_tac_toe.controller.GameController;

public class GameView {
    GameController gameController;
    public GameView() {
        gameController = new GameController();
    }

    public String executingGame() {
        return gameController.board();
    }

    @Override
    public String toString() {
        return gameController.toString();
    }
}
