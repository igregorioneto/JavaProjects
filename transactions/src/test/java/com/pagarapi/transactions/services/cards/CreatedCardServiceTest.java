package com.pagarapi.transactions.services.cards;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.CardInMemoryRepository;
import com.pagarapi.transactions.modules.cards.services.CreatedCardService;
import com.pagarapi.transactions.modules.clients.entities.Client;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;

public class CreatedCardServiceTest {

    @Test
    public void should_be_able_created_card() {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setName("João Silva");
        client.setCpf("11111111111");

        Card card = new Card();
        card.setId(UUID.randomUUID());
        card.setNumbering("555544443333222");
        card.setValidity(new Date());
        card.setClient(client);

        CardInMemoryRepository repository = new CardInMemoryRepository();
        CreatedCardService service = new CreatedCardService(repository);

        Card cardCreated = service.execute(card);

        assertNotNull(cardCreated);
    }

}
