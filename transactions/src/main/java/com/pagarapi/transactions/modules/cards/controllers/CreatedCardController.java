package com.pagarapi.transactions.modules.cards.controllers;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.CardRepository;
import com.pagarapi.transactions.modules.cards.services.CreatedCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CreatedCardController {
    @Autowired
    private CardRepository repository;

    @PostMapping("/")
    public ResponseEntity<Card> createdCard(@RequestBody Card card) {
        CreatedCardService service = new CreatedCardService(repository);
        return new ResponseEntity<>(service.execute(card), HttpStatus.CREATED);
    }
}
