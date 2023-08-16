package com.backend.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart extends BaseEntity {

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "total_payment")
    private double totalPayment;

    @Column(name = "successful_payment", columnDefinition = "boolean default false")
    private boolean successfulPayment;

    public ShoppingCart() {}

    public ShoppingCart(Account account) {
        this.account = account;
    }

    public ShoppingCart(List<Item> items, Account account, double totalPayment) {
        this.items = items;
        this.account = account;
        this.totalPayment = totalPayment;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public boolean getSuccessfulPayment() {
        return successfulPayment;
    }

    public void setSuccessfulPayment(boolean successfulPayment) {
        this.successfulPayment = successfulPayment;
    }
}
