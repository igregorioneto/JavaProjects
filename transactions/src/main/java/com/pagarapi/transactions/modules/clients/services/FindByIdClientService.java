package com.pagarapi.transactions.modules.clients.services;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindByIdClientService {
    private IClientRepository repository;

    public FindByIdClientService(IClientRepository repository) {
        this.repository = repository;
    }

    public Client execute(Long id) {
        return this.repository.findById(id);
    }
}
