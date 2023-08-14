package com.backend.backend.entity.enums;

public enum PaymentStatus {
    SUCCESS("success"),
    ERROR("error");

    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
