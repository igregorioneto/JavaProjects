package com.pagarapi.transactions.services.clients;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.clients.repositories.ClientInMemoryRepository;
import com.pagarapi.transactions.modules.clients.services.CreatedClientService;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.UUID;

public class CreatedClientServiceTest {

    @Test
    public void should_be_able_created_client() {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setName("João Silva");
        client.setCpf("11111111111");

        ClientInMemoryRepository repository = new ClientInMemoryRepository();
        CreatedClientService service = new CreatedClientService(repository);

        Client createdClient = service.execute(client);

        assertNotNull(createdClient.getId());
    }

}
