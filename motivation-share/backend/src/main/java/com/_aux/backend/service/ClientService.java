package com._aux.backend.service;

import com._aux.backend.model.Client;
import com._aux.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends GenericService<Client, Long> {
    private final ClientRepository repository;
    public ClientService(ClientRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
