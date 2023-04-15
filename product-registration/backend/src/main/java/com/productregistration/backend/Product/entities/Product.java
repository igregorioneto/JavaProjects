package com.productregistration.backend.Product.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String provider;
    private double amount;

    public Product(String name, String provider, double amount) {
        this.name = name;
        this.provider = provider;
        this.amount = amount;
    }
}
