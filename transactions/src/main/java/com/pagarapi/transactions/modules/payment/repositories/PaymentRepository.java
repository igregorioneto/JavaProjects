package com.pagarapi.transactions.modules.payment.repositories;

import com.pagarapi.transactions.modules.payment.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentRepository implements IPaymentRepository {
    @Autowired
    private PaymentJPARepository reporitoy;


    @Override
    public Payment save(Payment payment) {
        return this.reporitoy.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return this.reporitoy.findAll();
    }
}
