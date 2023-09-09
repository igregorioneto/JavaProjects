package org.tic_tac_toe.model;

public class Player {
    private String representation;
    private int points;

    public Player() {
    }

    public Player(String representation, int points) {
        this.representation = representation;
        this.points = points;
    }

    public String getRepresentation() {
        return representation;
    }

    public int getPoints() {
        return points;
    }
}
