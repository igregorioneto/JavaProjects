package com.pagarapi.transactions.modules.clients.services;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllClientService {
    private IClientRepository repository;

    public FindAllClientService(IClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> execute() {
        return this.repository.findAll();
    }
}
