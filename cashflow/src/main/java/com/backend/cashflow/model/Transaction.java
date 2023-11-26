package com.backend.cashflow.model;

import com.backend.cashflow.enums.TypeTransaction;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transactions")
public class Transaction extends BaseEntity {

    private Double price;
    private String date;
    private TypeTransaction type;
    private Long toUser;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Construtores, getters e setters podem ser adicionados conforme necessário


    public Transaction() {
    }

    public Transaction(Double price, String date, TypeTransaction type, Long toUser, User user) {
        this.price = price;
        this.date = date;
        this.type = type;
        this.toUser = toUser;
        this.user = user;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
