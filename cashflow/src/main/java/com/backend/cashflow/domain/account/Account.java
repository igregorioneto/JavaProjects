package com.backend.cashflow.domain.account;

import com.backend.cashflow.domain.core.BaseEntity;
import com.backend.cashflow.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_accounts")
public class Account extends BaseEntity {

    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Construtores, getters e setters podem ser adicionados conforme necessário


    public Account() {
    }

    public Account(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}