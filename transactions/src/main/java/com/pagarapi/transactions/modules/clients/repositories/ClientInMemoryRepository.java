package com.pagarapi.transactions.modules.clients.repositories;

import com.pagarapi.transactions.modules.clients.entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientInMemoryRepository implements IClientRepository {
    private List<Client> clients;

    public ClientInMemoryRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Client findByCpf(String cpf) {
        Optional<Client> optional = this.clients.stream().filter(client -> client.getCpf().equals(cpf)).findFirst();
        return optional.orElse(null);
    }

    @Override
    public Client save(Client client) {
        this.clients.add(client);
        return client;
    }

    @Override
    public List<Client> findAll() {
        return this.clients;
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> optional = this.clients.stream().filter(client -> client.getId().equals(id)).findFirst();
        return optional.orElse(null);
    }
}
