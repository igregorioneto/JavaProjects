package com.pagarapi.transactions.modules.payment.entities;

public enum Status {
    PAID("paid"),
    WAITING_FUNDS("waiting_funds");

    Status(String type) {

    }

    Status() {}
}
