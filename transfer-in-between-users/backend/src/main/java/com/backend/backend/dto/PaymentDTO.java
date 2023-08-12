package com.backend.backend.dto;

import com.backend.backend.entity.enums.FormOfPayment;

import java.util.UUID;

public class PaymentDTO {
    private UUID shopping_cart_id;
    private FormOfPayment formOfPayment;
    private UUID card_selected;

    public UUID getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(UUID shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public FormOfPayment getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPayment formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public UUID getCard_selected() {
        return card_selected;
    }

    public void setCard_selected(UUID card_selected) {
        this.card_selected = card_selected;
    }
}
