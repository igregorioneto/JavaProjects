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
    @Enumerated(EnumType.STRING)
    private MethodPayment methodPayment;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double fee;
    private Long cardId;

    public PaymentDTO(double valueTransaction, String description, MethodPayment methodPayment, Status status, double fee, Long cardId) {
        this.valueTransaction = valueTransaction;
        this.description = description;
        this.methodPayment = methodPayment;
        this.status = status;
        this.fee = fee;
        this.cardId = cardId;
    }

    public PaymentDTO() {}

}
