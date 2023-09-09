package org.tic_tac_toe.models;

public class Player {
    private String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation.toUpperCase();
    }
}
