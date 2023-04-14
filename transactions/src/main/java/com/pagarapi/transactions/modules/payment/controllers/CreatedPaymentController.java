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
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/payments")
public class CreatedPaymentController {
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/")
    public ResponseEntity<Payment> createdPayment(@RequestBody PaymentDTO paymentDTO) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            CreatedPaymentService service = new CreatedPaymentService(repository);

            if (paymentDTO.getCardId().equals(null))
                throw new Exception("Valor do id do Cartão não pode ser nulo");

            Card card = this.cardRepository.findById(paymentDTO.getCardId());

            String status;
            double valueTransaction = 0;
            String paymentDate = dateFormat.format(date);

            if (paymentDTO.getMethodPayment().equals("debit_card")){
                status = "paid";
                valueTransaction = paymentDTO.getValueTransaction() - paymentDTO.getValueTransaction() * 0.03;
                paymentDate = dateFormat.format(date);
            }
            else {
                status = "waiting_funds";
                valueTransaction = paymentDTO.getValueTransaction() - paymentDTO.getValueTransaction() * 0.05;
                cal.setTime(date);
                cal.add(Calendar.DAY_OF_MONTH, 30);
                date = cal.getTime();
                paymentDate = dateFormat.format(date);
            }

            Payment payment = new Payment(
                    valueTransaction,
                    paymentDTO.getDescription(),
                    paymentDTO.getMethodPayment(),
                    status,
                    paymentDate,
                    card
            );

            return new ResponseEntity<>(service.execute(payment), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", e);
        }
    }
}
