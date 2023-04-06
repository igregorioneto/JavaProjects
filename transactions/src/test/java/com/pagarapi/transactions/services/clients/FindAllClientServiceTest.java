package com.pagarapi.transactions.services.clients;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientInMemoryRepository;
import com.pagarapi.transactions.modules.clients.services.CreatedClientService;
import com.pagarapi.transactions.modules.clients.services.FindAllClientService;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FindAllClientServiceTest {

    @Test
    public void should_be_able_find_all() {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setName("João Silva");
        client.setCpf("11111111111");

        ClientInMemoryRepository repository = new ClientInMemoryRepository();
        repository.save(client);
        FindAllClientService service = new FindAllClientService(repository);
        List<Client> clients = service.execute();

        assertNotNull(clients);


    }
}
