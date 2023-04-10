package com.pagarapi.transactions.modules.clients.controllers;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientRepository;
import com.pagarapi.transactions.modules.clients.services.FindAllClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class FindAllClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Client>> findAllClient() {
        FindAllClientService service = new FindAllClientService(this.repository);
        return new ResponseEntity<>(service.execute(), HttpStatus.OK);
    }
}
