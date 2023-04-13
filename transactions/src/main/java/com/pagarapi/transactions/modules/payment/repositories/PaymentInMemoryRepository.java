package com.pagarapi.transactions.modules.payment.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.payment.entities.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PaymentInMemoryRepository implements IPaymentRepository{
    private List<Payment> payments;

    public PaymentInMemoryRepository() {
        this.payments = new ArrayList<>();
    }

    @Override
    public Payment save(Payment payment) {
        this.payments.add(payment);
        return payment;
    }

    @Override
    public List<Payment> findAll() {
        return this.payments;
    }

    @Override
    public Payment findById(Long id) {
        Optional<Payment> optional = this.payments.stream().filter(payment -> payment.getId().equals(id)).findFirst();
        return optional.orElse(null);
    }
}
