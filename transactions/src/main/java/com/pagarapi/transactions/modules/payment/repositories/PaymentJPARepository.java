package com.pagarapi.transactions.modules.payment.repositories;

import com.pagarapi.transactions.modules.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentJPARepository extends JpaRepository<Payment, UUID> {
}
