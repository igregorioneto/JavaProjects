package com.backend.backend.dto;

import java.util.List;
import java.util.UUID;

public class ShoppingCartDTO {
    private UUID account_id;
    private List<UUID> items;

    public UUID getAccount_id() {
        return account_id;
    }

    public void setAccount_id(UUID account_id) {
        this.account_id = account_id;
    }

    public List<UUID> getItems() {
        return items;
    }

    public void setItems(List<UUID> items) {
        this.items = items;
    }
}
