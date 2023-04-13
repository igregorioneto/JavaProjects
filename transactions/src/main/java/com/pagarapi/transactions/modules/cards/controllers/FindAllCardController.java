package com.pagarapi.transactions.modules.cards.controllers;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.CardRepository;
import com.pagarapi.transactions.modules.cards.services.FindAllCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cards")
public class FindAllCardController {
    @Autowired
    private CardRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Card>> findAll() {
        FindAllCardService service = new FindAllCardService(repository);
        return new ResponseEntity<>(service.execute(), HttpStatus.OK);
    }
}
