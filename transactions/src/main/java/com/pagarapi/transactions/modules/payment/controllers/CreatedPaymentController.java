package com.pagarapi.transactions.modules.payment.controllers;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.CardRepository;
import com.pagarapi.transactions.modules.payment.dto.PaymentDTO;
import com.pagarapi.transactions.modules.payment.entities.Payment;
import com.pagarapi.transactions.modules.payment.repositories.PaymentRepository;
import com.pagarapi.transactions.modules.payment.services.CreatedPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class CreatedPaymentController {
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/")
    public ResponseEntity<Payment> createdPayment(@RequestBody PaymentDTO paymentDTO) {
        CreatedPaymentService service = new CreatedPaymentService(repository);
        Card card = this.cardRepository.findById(paymentDTO.getCardId());
        Payment payment = new Payment(
                paymentDTO.getValueTransaction(),
                paymentDTO.getDescription(),
                paymentDTO.getMethodPayment(),
                paymentDTO.getStatus(),
                paymentDTO.getFee(),
                card
        );
        return new ResponseEntity<>(service.execute(payment), HttpStatus.CREATED);
    }
}
