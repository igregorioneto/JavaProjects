package com.pagarapi.transactions.services.payments;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.services.CreatedCardService;
import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.payment.entities.MethodPayment;
import com.pagarapi.transactions.modules.payment.entities.Payment;
import com.pagarapi.transactions.modules.payment.repositories.PaymentInMemoryRepository;
import com.pagarapi.transactions.modules.payment.services.CreatedPaymentService;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class CreatedPaymentServiceTest {

    @Test
    public void should_be_able_created_payment() {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setName("João Silva");
        client.setCpf("11111111111");

        Card card = new Card();
        card.setId(UUID.randomUUID());
        card.setNumbering("555544443333222");
        card.setValidity(new Date());
        card.setClient(client);

        Payment payment = new Payment();
        payment.setId(UUID.randomUUID());
        payment.setDescription("New Payment");
        payment.setValueTransaction(80.0);
        payment.setMethodPayment(MethodPayment.DEBIT_CARD);
        payment.setCard(card);

        PaymentInMemoryRepository repository = new PaymentInMemoryRepository();
        CreatedPaymentService service = new CreatedPaymentService(repository);

        Payment newPayment = service.execute(payment);

        assertNotNull(newPayment);
    }
}
