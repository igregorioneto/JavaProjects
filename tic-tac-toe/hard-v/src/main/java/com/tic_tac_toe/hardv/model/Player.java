package com.tic_tac_toe.hardv.model;

public class Player {
    private String representation;

    public Player() {
    }

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}
