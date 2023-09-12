package com.tic_tac_toe.hardv.controllers;

import com.tic_tac_toe.hardv.model.DTO;
import com.tic_tac_toe.hardv.model.Player;
import com.tic_tac_toe.hardv.model.StartGameDTO;
import com.tic_tac_toe.hardv.services.GameLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TicTacToeController {

    @Autowired
    private GameLogic gl;

    @MessageMapping("/makePlayer")
    @SendTo("/tictactoe")
    public String makePlayer(DTO dto) {
        if (gl.isStartPlayer()) {
            gl.makePlayer(dto.getTicTacToe(), dto.getPlayer());
        } else {
            System.out.println("Iniciar o jogo");
        }
        System.out.println("Win: " + gl.getWin());
        return gl.getWin();
    }

    @MessageMapping("/startGame")
    @SendTo("/start")
    public boolean startGame(StartGameDTO dto) {
        gl.setStartPlayer(dto.isStartGame());
        return gl.isStartPlayer();
    }

}
