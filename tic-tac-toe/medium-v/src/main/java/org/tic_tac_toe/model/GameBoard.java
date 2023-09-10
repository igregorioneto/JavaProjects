package org.tic_tac_toe.model;

public class GameBoard {
    private Player[][] arrayBoard;
    private boolean startGame;
    private Player win;
    private boolean draw;

    public GameBoard() {
        arrayBoard = new Player[3][3];
        startGame = true;
    }

    private String board() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arrayBoard.length; i++) {
            s.append("\n");
            for (int j = 0; j < arrayBoard.length; j++) {
                if (arrayBoard[i][j] != null) {
                    s.append(arrayBoard[i][j] + "  ");
                } else {
                    s.append("__ ");
                }
            }
        }

        return s.toString();
    }

    public void makePlayerBoard(int x, int y,Player p) {
        if (p != null && arrayBoard[x][y] == null) {
            arrayBoard[x][y] = p;
            verifyStatusGame(p);
        }
    }

    private void verifyStatusGame(Player p) {
        if (arrayBoard[0][0] == p && arrayBoard[0][1] == p && arrayBoard[0][2] == p ||
                arrayBoard[1][0] == p && arrayBoard[1][1] == p && arrayBoard[1][2] == p ||
                arrayBoard[2][0] == p && arrayBoard[2][1] == p && arrayBoard[2][2] == p ||
                arrayBoard[0][0] == p && arrayBoard[1][0] == p && arrayBoard[2][0] == p ||
                arrayBoard[0][1] == p && arrayBoard[1][1] == p && arrayBoard[2][1] == p ||
                arrayBoard[0][2] == p && arrayBoard[1][2] == p && arrayBoard[2][2] == p ||
                arrayBoard[0][0] == p && arrayBoard[1][1] == p && arrayBoard[2][2] == p ||
                arrayBoard[0][2] == p && arrayBoard[1][1] == p && arrayBoard[2][0] == p
        ) {
            startGame = false;
            win = p;
        }
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    @Override
    public String toString() {
        return board() + "\nStart Game: " + startGame + "\nPlayer Win: " + ((win != null) ? win : "");
    }
}
