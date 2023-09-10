package org.tic_tac_toe.view;

import org.tic_tac_toe.controller.GameController;
import org.tic_tac_toe.model.P1;
import org.tic_tac_toe.model.P2;
import org.tic_tac_toe.model.Player;

import java.util.Scanner;

public class GameView {
    GameController gameController;
    public GameView() {
        gameController = new GameController();
    }

    public void executingGame() {
        System.out.println(gameController.board());
        Scanner sc = new Scanner(System.in);

        Player p1 = null, p2 = null;

        boolean verify = true;
        String entry;

        while (verify) {
            System.out.print("Deseja jogar com X/O: ");
            entry = sc.next();
            if (entry.trim().equalsIgnoreCase("x")) {
                p1 = new P1("X", 0);
                p2 = new P2("O", 0);
                verify = false;
            } else if (entry.trim().equalsIgnoreCase("o")) {
                p1 = new P1("O", 0);
                p2 = new P2("X", 0);
                verify = false;
            } else {
                System.out.println("Valor informado errado...");
                verify = true;
            }
        }

        String[] make;
        int x,y;
        while (gameController.startGame()) {
            System.out.println(gameController.board());
            System.out.print("Player 1 - Realize uma jogada [x,y]: ");
            entry = sc.next();
            make = entry.split(",");
            x = Integer.parseInt(make[0]);
            y = Integer.parseInt(make[1]);

            gameController.makePlay(x, y, p1);

            System.out.println(gameController.board());
            if (!gameController.startGame()) break;

            System.out.print("Player 2 - Realize uma jogada [x,y]: ");
            entry = sc.next();
            make = entry.split(",");
            x = Integer.parseInt(make[0]);
            y = Integer.parseInt(make[1]);

            gameController.makePlay(x, y, p2);
        }
        System.out.println(gameController.board());
    }

    @Override
    public String toString() {
        return gameController.toString();
    }
}
