package com.gregaux.backend.service;

import com.gregaux.backend.model.Client;
import com.gregaux.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends GenericService<Client, Long> {
    private final ClientRepository repository;
    public ClientService(ClientRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
