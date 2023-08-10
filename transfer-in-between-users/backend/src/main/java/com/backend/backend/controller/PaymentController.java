package com.backend.backend.controller;

import com.backend.backend.business.PaymentBusiness;
import com.backend.backend.business.ShoppingCartBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.PaymentDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Payment;
import com.backend.backend.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController extends GenericControllerImpl<Payment, UUID, PaymentBusiness> {
    @Autowired
    private ShoppingCartBusiness shoppingCartBusiness;

    @Autowired
    private ResponseMessage<Payment> successMessage;

    @Autowired
    private ResponseMessage<String> errorMessage;


    public PaymentController(PaymentBusiness service) {
        super(service);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDTO<?>> create(@RequestBody PaymentDTO dto) {
        try {
            Payment payment = new Payment();
            return ResponseEntity.ok(
                    successMessage.MessageReturn("Success", HttpStatus.OK.value(), payment)
            );
        } catch (InternalError e) {
            throw new InternalError(e.getMessage());
        }
    }
}
