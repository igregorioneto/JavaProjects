package com.backend.backend.business;

import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.Payment;
import com.backend.backend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentBusiness extends GenericServiceImpl<Payment, UUID, PaymentRepository> {
    public PaymentBusiness(PaymentRepository repository) {
        super(repository);
    }
}
