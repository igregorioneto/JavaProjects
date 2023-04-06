package com.pagarapi.transactions.modules.clients.repositories;

import com.pagarapi.transactions.modules.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientJPARepository extends JpaRepository<Client, UUID> {
    public Client findByCpf(String cpf);
}
