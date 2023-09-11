package com.tic_tac_toe.hardv.controllers;

import com.tic_tac_toe.hardv.model.DTO;
import com.tic_tac_toe.hardv.model.Player;
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
    public Player makePlayer(DTO dto) {
        gl.makePlayer(dto.getTicTocToe(), dto.getPlayer());
        return gl.playerWin();
    }

}
