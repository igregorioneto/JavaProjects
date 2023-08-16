package com.backend.backend.dto;

import java.util.UUID;

public class ShoppingCartCreateDTO {
    private UUID account_id;

    public UUID getAccount_id() {
        return account_id;
    }

    public void setAccount_id(UUID account_id) {
        this.account_id = account_id;
    }
}
