package com.backend.backend.entity.enums;

public enum FormOfPayment {
    VOUCHER("voucher"),
    CARD("card"),
    TICKET("ticket");

    private final String value;

    FormOfPayment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
