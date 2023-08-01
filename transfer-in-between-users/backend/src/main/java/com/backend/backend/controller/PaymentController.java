package com.backend.backend.controller;

import com.backend.backend.business.PaymentBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.entity.Payment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController extends GenericControllerImpl<Payment, UUID, PaymentBusiness> {
    public PaymentController(PaymentBusiness service) {
        super(service);
    }
}
