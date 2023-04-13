package com.pagarapi.transactions.modules.clients.repositories;

import com.pagarapi.transactions.modules.clients.entities.Client;

import java.util.List;
import java.util.UUID;

public interface IClientRepository {
    public Client findByCpf(String cpf);

    public Client save(Client client);

    public List<Client> findAll();

    public Client findById(Long id);
}
