package com.pagarapi.transactions.modules.payment.dto;

import com.pagarapi.transactions.modules.payment.entities.MethodPayment;
import com.pagarapi.transactions.modules.payment.entities.Status;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class PaymentDTO {
    private double valueTransaction;
    private String description;
    private String methodPayment;
    private Long cardId;

    public PaymentDTO(double valueTransaction, String description, String methodPayment, Long cardId) {
        this.valueTransaction = valueTransaction;
        this.description = description;
        this.methodPayment = methodPayment;
        this.cardId = cardId;
    }

    public PaymentDTO() {}

}
