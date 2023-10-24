package com._aux.backend.model;

import com._aux.backend.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Collections;

@Entity
@Table(name = "tb_users_client")
public class Client extends User<UserRole> {

    @Column
    private String favoriteQuote;

    @Column
    private int motivationalPoints;

    public Client() {
        setRoles(Collections.singleton(UserRole.CLIENT));
    }

    public String getFavoriteQuote() {
        return favoriteQuote;
    }

    public void setFavoriteQuote(String favoriteQuote) {
        this.favoriteQuote = favoriteQuote;
    }

    public int getMotivationalPoints() {
        return motivationalPoints;
    }

    public void setMotivationalPoints(int motivationalPoints) {
        this.motivationalPoints = motivationalPoints;
    }
}
