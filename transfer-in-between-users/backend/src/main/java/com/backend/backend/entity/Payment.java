package com.backend.backend.entity;

import com.backend.backend.entity.enums.FormOfPayment;
import com.backend.backend.entity.enums.PaymentStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Payment extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = true)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "form_of_payment")
    private FormOfPayment formOfPayment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_selected_id", nullable = true)
    private Card cardSelected;

    public Payment() {}

    public Payment(PaymentStatus paymentStatus, FormOfPayment formOfPayment, ShoppingCart shoppingCart, Card cardSelected) {
        this.paymentStatus = paymentStatus;
        this.formOfPayment = formOfPayment;
        this.shoppingCart = shoppingCart;
        setCardSelected(cardSelected);
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public FormOfPayment getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPayment formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Card getCardSelected() {
        return cardSelected;
    }

    public void setCardSelected(Card cardSelected) {
        if(cardSelected != null)
            this.cardSelected = cardSelected;
    }
}
