package com.backend.cashflow.enums;

public enum StringLength {
    NAME(3, 80),
    PASSWORD(6, 20),
    BALANCE(50, 1000);

    private final int minLength;
    private final int maxLength;

    StringLength(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
