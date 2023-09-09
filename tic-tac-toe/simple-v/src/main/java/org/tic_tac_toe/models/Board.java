package org.tic_tac_toe.models;

public class Board {
    private Player p1;
    private Player p2;
    private boolean finishGame;
    private boolean playerGame;

    private Player[][] arrayBoard;

    public  Board() {}

    public Board(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.arrayBoard = new Player[3][3];
        this.finishGame = false;
        this.playerGame = true;
    }

    public String board() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arrayBoard.length; i++) {
            s.append("\n");
            for (int j = 0; j < arrayBoard.length; j++) {
                if (arrayBoard[i][j] == null) {
                    s.append("__ ");
                } else {
                    s.append(arrayBoard[i][j] + "  ");
                }
            }
        }
        return s.toString();
    }

    public void boardMakePlay(int x, int y, Player p) {
        if (arrayBoard[x][y] == null)
            arrayBoard[x][y] = p;
            logicResultGame(p);
    }

    private void logicResultGame(Player p) {
        if (arrayBoard[0][0] == p
                && arrayBoard[0][1] == p
                && arrayBoard[0][2] == p
                ||
                arrayBoard[1][0] == p
                        && arrayBoard[1][1] == p
                        && arrayBoard[1][2] == p
                ||
                arrayBoard[2][0] == p
                        && arrayBoard[2][1] == p
                        && arrayBoard[2][2] == p
                ||
                arrayBoard[0][0] == p
                        && arrayBoard[1][0] == p
                        && arrayBoard[2][0] == p
                ||
                arrayBoard[0][1] == p
                        && arrayBoard[1][1] == p
                        && arrayBoard[2][1] == p
                ||
                arrayBoard[0][2] == p
                        && arrayBoard[1][2] == p
                        && arrayBoard[2][2] == p
                ||
                arrayBoard[0][0] == p
                        && arrayBoard[1][1] == p
                        && arrayBoard[2][2] == p
                ||
                arrayBoard[0][2] == p
                        && arrayBoard[1][1] == p
                        && arrayBoard[2][0] == p
        ) {
            finishGame = true;
            playerGame = false;
        } else {
            finishGame = false;
            playerGame = true;
        }
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public boolean isPlayerGame() {
        return playerGame;
    }

    @Override
    public String toString() {
        return board() + "\n\nFinish: " + finishGame + "\n\nPlayer Game: " + playerGame;
    }
}
