package com.backend.cashflow.enums;

public enum TypeTransaction {
    WITHDRAW("withdraw"),
    TRANSFER("transfer"),
    DEPOSIT("deposit");

    private final String type;

    TypeTransaction(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
