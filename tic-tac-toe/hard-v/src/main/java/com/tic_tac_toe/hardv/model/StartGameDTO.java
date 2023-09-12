package com.tic_tac_toe.hardv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StartGameDTO {

    @JsonProperty("startGame")
    private boolean startGame;

    public StartGameDTO() {
    }

    public StartGameDTO(boolean startGame) {
        this.startGame = startGame;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }
}
