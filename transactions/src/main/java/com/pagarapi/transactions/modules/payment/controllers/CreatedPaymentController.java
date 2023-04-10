package com.pagarapi.transactions.modules.payment.controllers;

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

    @PostMapping("/")
    public ResponseEntity<Payment> createdPayment(@RequestBody Payment payment) {
        CreatedPaymentService service = new CreatedPaymentService(repository);
        return new ResponseEntity<>(service.execute(payment), HttpStatus.CREATED);
    }
}
