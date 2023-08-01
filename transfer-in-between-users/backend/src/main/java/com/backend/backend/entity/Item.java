package com.backend.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Item extends BaseEntity{
    @Column
    private String name;

    @Column
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
