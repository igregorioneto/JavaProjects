package com.pagarapi.transactions.modules.clients.controllers;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientRepository;
import com.pagarapi.transactions.modules.clients.services.CreatedClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/clients")
public class CreatedClientController {
    @Autowired
    private ClientRepository repository;

    @PostMapping("/")
    public ResponseEntity<Client> createdClient(@RequestBody Client client) {
        try {
            CreatedClientService service = new CreatedClientService(this.repository);
            return new ResponseEntity<>(service.execute(client), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
