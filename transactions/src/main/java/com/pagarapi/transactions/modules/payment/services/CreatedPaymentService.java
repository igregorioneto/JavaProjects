package com.pagarapi.transactions.modules.payment.services;

import com.pagarapi.transactions.modules.payment.entities.Payment;
import com.pagarapi.transactions.modules.payment.repositories.IPaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatedPaymentService {
    private IPaymentRepository repository;

    public CreatedPaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    public Payment execute(Payment payment) {
        return this.repository.save(payment);
    }
}
