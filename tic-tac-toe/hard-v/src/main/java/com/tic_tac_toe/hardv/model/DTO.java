package com.tic_tac_toe.hardv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DTO {
    @JsonProperty("TicTacToe")
    private TicTacToe ticTacToe;

    @JsonProperty("Player")
    private Player player;

    public DTO() {
    }

    public DTO(TicTacToe ticTacToe, Player player, boolean startGame) {
        this.ticTacToe = ticTacToe;
        this.player = player;
    }

    public TicTacToe getTicTacToe() {
        return ticTacToe;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTicTacToe(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }
}
