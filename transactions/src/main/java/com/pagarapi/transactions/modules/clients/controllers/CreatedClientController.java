package com.pagarapi.transactions.modules.clients.controllers;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientRepository;
import com.pagarapi.transactions.modules.clients.services.CreatedClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class CreatedClientController {
    @Autowired
    private ClientRepository repository;

    @PostMapping("/")
    public Client createdClient(@RequestBody Client client) {
        CreatedClientService service = new CreatedClientService(this.repository);
        return service.execute(client);
    }
}
