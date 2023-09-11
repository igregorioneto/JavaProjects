package com.tic_tac_toe.hardv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DTO {
    @JsonProperty("TicTocToe")
    private TicTocToe ticTocToe;

    @JsonProperty("Player")
    private Player player;


    public DTO() {
    }

    public DTO(TicTocToe ticTocToe, Player player) {
        this.ticTocToe = ticTocToe;
        this.player = player;
    }

    public TicTocToe getTicTocToe() {
        return ticTocToe;
    }

    public void setTicTocToe(TicTocToe ticTocToe) {
        this.ticTocToe = ticTocToe;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
