package com.backend.cashflow.domain.user;

import com.backend.cashflow.domain.core.BaseEntity;
import com.backend.cashflow.domain.account.Account;
import com.backend.cashflow.domain.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_users")
public class User extends BaseEntity {

    private String name;
    private Double balance;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Account account;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactions;

    public User() {
    }

    public User(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
