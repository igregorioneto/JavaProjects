package com.pagarapi.transactions.modules.payment.controllers;

import com.pagarapi.transactions.modules.payment.entities.Payment;
import com.pagarapi.transactions.modules.payment.repositories.PaymentRepository;
import com.pagarapi.transactions.modules.payment.services.FindAllPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments/")
public class FindAllPaymentController {
    @Autowired
    private PaymentRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Payment>> findAll() {
        FindAllPaymentService service = new FindAllPaymentService(repository);
        return new ResponseEntity<>(service.execute(), HttpStatus.OK);
    }
}
