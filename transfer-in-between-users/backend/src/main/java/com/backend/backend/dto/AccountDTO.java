package com.backend.backend.dto;

import java.util.UUID;

public class AccountDTO {
    private UUID user_id;

    private Double balance;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
