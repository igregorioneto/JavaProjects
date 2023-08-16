package com.backend.backend.dto;

import java.util.UUID;

public class ItemShoppingCartDTO {
    private UUID item_id;
    private UUID shopping_cart_id;

    public UUID getItem_id() {
        return item_id;
    }

    public void setItem_id(UUID item_id) {
        this.item_id = item_id;
    }

    public UUID getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(UUID shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }
}
