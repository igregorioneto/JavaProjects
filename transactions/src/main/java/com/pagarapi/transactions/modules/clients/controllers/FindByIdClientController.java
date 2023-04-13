package com.pagarapi.transactions.modules.clients.controllers;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class FindByIdClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@RequestParam Long id) {
        return new ResponseEntity<>(this.repository.findById(id), HttpStatus.OK);
    }
}
