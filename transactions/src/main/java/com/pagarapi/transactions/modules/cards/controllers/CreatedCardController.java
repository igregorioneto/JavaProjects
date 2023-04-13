package com.pagarapi.transactions.modules.cards.controllers;

import com.pagarapi.transactions.modules.cards.CardDTO.CardDTO;
import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.CardRepository;
import com.pagarapi.transactions.modules.cards.services.CreatedCardService;
import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/cards")
public class CreatedCardController {
    @Autowired
    private CardRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/")
    public ResponseEntity<Card> createdCard(@RequestBody CardDTO cardDTO)  {
        CreatedCardService service = new CreatedCardService(repository);
        Client client = this.clientRepository.findByCpf(cardDTO.getClientCPF());
        Card card = new Card(cardDTO.getNumbering(), cardDTO.getValidity(), client);
        return new ResponseEntity<>(service.execute(card), HttpStatus.CREATED);
    }
}
