package com.pagarapi.transactions.modules.clients.repositories;

import com.pagarapi.transactions.modules.clients.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientRepository implements IClientRepository {
    @Autowired
    private ClientJPARepository repository;

    @Override
    public Client findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public Client save(Client client) {
        return this.repository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return this.repository.findById(id);
    }
}
