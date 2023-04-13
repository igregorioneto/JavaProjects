package com.pagarapi.transactions.modules.payment.repositories;

import com.pagarapi.transactions.modules.clients.entities.Client;
import com.pagarapi.transactions.modules.payment.entities.Payment;

import java.util.List;

public interface IPaymentRepository {
    public Payment save(Payment payment);

    public List<Payment> findAll();

    public Payment findById(Long id);

}
