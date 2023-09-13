package com.tic_tac_toe.hardv.services;

import com.tic_tac_toe.hardv.model.Player;
import com.tic_tac_toe.hardv.model.TicTacToe;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    private String[][] arrayPlayers;
    private boolean startPlayer;
    private String win;

    public GameLogic() {
        win = "";
        startPlayer = false;
        arrayPlayers = new String[3][3];
        loadingBoard();
    }

    public void makePlayer(TicTacToe t, Player p) {
        if (arrayPlayers[t.getX()][t.getY()].equals("?") && win == "" && startPlayer){
            arrayPlayers[t.getX()][t.getY()] = p.getRepresentation();
            loadingBoard();
            if (isPlayerWin(p.getRepresentation())) {
                setWin(p.getRepresentation());
                System.out.println("Win: " + getWin());
                setStartPlayer(false);
            }
        }
    }

    private boolean isPlayerWin(String representation) {
        if (arrayPlayers[0][0].equals(representation) &&
                arrayPlayers[1][1].equals(representation) &&
                arrayPlayers[2][2].equals(representation) ||
                arrayPlayers[0][0].equals(representation) &&
                arrayPlayers[0][1].equals(representation) &&
                arrayPlayers[0][2].equals(representation) ||
                arrayPlayers[1][0].equals(representation) &&
                arrayPlayers[1][1].equals(representation) &&
                arrayPlayers[1][2].equals(representation) ||
                arrayPlayers[2][0].equals(representation) &&
                arrayPlayers[2][1].equals(representation) &&
                arrayPlayers[2][2].equals(representation) ||
                arrayPlayers[0][0].equals(representation) &&
                arrayPlayers[1][0].equals(representation) &&
                arrayPlayers[2][0].equals(representation) ||
                arrayPlayers[0][1].equals(representation) &&
                arrayPlayers[1][1].equals(representation) &&
                arrayPlayers[2][1].equals(representation) ||
                arrayPlayers[0][2].equals(representation) &&
                arrayPlayers[1][2].equals(representation) &&
                arrayPlayers[2][2].equals(representation) ||
                arrayPlayers[0][2].equals(representation) &&
                arrayPlayers[1][1].equals(representation) &&
                arrayPlayers[2][0].equals(representation)
) {
            return true;
        }
        return false;
    }

    public void loadingBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n");
            for (int j = 0; j < 3; j++) {
                if (arrayPlayers[i][j] == null)
                    arrayPlayers[i][j] = "?";
                System.out.print(arrayPlayers[i][j] + "  ");
            }
        }
        System.out.print("\n");
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public boolean isStartPlayer() {
        return startPlayer;
    }

    public void setStartPlayer(boolean startPlayer) {
        this.startPlayer = startPlayer;
    }
}
