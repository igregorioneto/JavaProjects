package com.tic_tac_toe.hardv.services;

import com.tic_tac_toe.hardv.model.Player;
import com.tic_tac_toe.hardv.model.TicTocToe;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    private Player[][] arrayPlayers;
    private boolean startPlayer = true;
    private Player win = null;

    public GameLogic() {
        arrayPlayers = new Player[3][3];
    }

    public void makePlayer(TicTocToe t, Player p) {
        if (arrayPlayers[t.getX()][t.getY()] == null && win == null)
            arrayPlayers[t.getX()][t.getY()] = p;
            checkedPlayerWin(p);
    }

    private void checkedPlayerWin(Player p) {
        if (arrayPlayers[0][0] == p && arrayPlayers[0][1] == p && arrayPlayers[0][2] == p ||
                arrayPlayers[1][0] == p && arrayPlayers[1][1] == p && arrayPlayers[1][2] == p ||
                arrayPlayers[2][0] == p && arrayPlayers[2][1] == p && arrayPlayers[2][2] == p ||
                arrayPlayers[0][0] == p && arrayPlayers[1][0] == p && arrayPlayers[2][0] == p ||
                arrayPlayers[0][1] == p && arrayPlayers[1][1] == p && arrayPlayers[2][1] == p ||
                arrayPlayers[0][2] == p && arrayPlayers[1][2] == p && arrayPlayers[2][2] == p ||
                arrayPlayers[0][0] == p && arrayPlayers[1][1] == p && arrayPlayers[2][2] == p ||
                arrayPlayers[0][2] == p && arrayPlayers[1][1] == p && arrayPlayers[2][0] == p
        ) {
            win = p;
            startPlayer = false;
        }
    }

    public Player playerWin() {
        if (win != null)
            return win;
        return null;
    }

}
