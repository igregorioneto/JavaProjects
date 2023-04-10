package com.pagarapi.transactions.modules.payment.services;

import com.pagarapi.transactions.modules.payment.entities.Payment;
import com.pagarapi.transactions.modules.payment.repositories.IPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPaymentService {
    private IPaymentRepository repository;

    public FindAllPaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    public java.util.List<Payment> execute() {
        return this.repository.findAll();
    }
}
