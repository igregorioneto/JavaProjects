package com.pagarapi.transactions.modules.payment.entities;

public enum MethodPayment {
    DEBIT_CARD("debit_card"),
    CREDIT_CARD("credit_card");

    MethodPayment(String type) {

    }

    MethodPayment() {}
}
