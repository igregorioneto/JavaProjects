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
    private String status;
    private double fee;
    private Long cardId;

    public PaymentDTO(double valueTransaction, String description, String methodPayment, String status, double fee, Long cardId) {
        this.valueTransaction = valueTransaction;
        this.description = description;
        this.methodPayment = methodPayment;
        this.status = status;
        this.fee = fee;
        this.cardId = cardId;
    }

    public PaymentDTO() {}

}
