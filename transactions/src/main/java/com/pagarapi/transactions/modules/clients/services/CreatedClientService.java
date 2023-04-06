package com.pagarapi.transactions.modules.clients.services;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.IClientRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class CreatedClientService {
    private IClientRepository repository;

    public CreatedClientService(IClientRepository repository) {
        this.repository = repository;
    }

    public Client execute(Client client) {
        Client clientExisted = repository.findByCpf(client.getCpf());

        if (clientExisted != null)
            throw new Error("Client existed");

        return this.repository.save(client);
    }
}
