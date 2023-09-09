package org.tic_tac_toe;

import org.tic_tac_toe.models.Board;
import org.tic_tac_toe.models.P1;
import org.tic_tac_toe.models.P2;
import org.tic_tac_toe.models.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entry;

        Player p1 = new P1();
        Player p2 = new P1();
        Board board = new Board();

        boolean valueEntry = true;

        while (valueEntry) {
            System.out.print("Qual você deseja jogar: X/O: ");
            entry = sc.next();

            if (entry.trim().equalsIgnoreCase("x")) {
                p1 = new P1();
                p2 = new P2();
                board = new Board(p1, p2);
                valueEntry = false;
            } else if (entry.trim().equalsIgnoreCase("o")) {
                p1 = new P2();
                p2 = new P1();
                board = new Board(p1, p2);
                valueEntry = false;
            } else {
                System.out.println("Valor diferente dos atributos informados...");
            }
        }

        valueEntry = true;
        String[] values;
        int x, y;
        while (valueEntry) {
            System.out.println(board);
            if (!board.isFinishGame() && board.isPlayerGame()) {
                System.out.print("Digite a posição da sua jogada (x,y): ");
                entry = sc.next();
                values = entry.split(",");
                x = Integer.parseInt(values[0]);
                y = Integer.parseInt(values[1]);

                board.boardMakePlay(x,y, p1);
                System.out.println(board);
            } else {
                break;
            }

            if (!board.isFinishGame() && board.isPlayerGame()) {
                System.out.print("Digite a jogada do segundo jogador (x,y): ");
                entry = sc.next();
                values = entry.split(",");
                x = Integer.parseInt(values[0]);
                y = Integer.parseInt(values[1]);
                board.boardMakePlay(x,y, p2);
                System.out.println(board);
            } else {
                break;
            }

        }
        sc.close();
    }
}