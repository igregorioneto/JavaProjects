package com.backend.backend.entity;

public enum TypeCard {
    CREDIT("credit"),
    DEBIT("debit");

    private final String value;

    TypeCard(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
