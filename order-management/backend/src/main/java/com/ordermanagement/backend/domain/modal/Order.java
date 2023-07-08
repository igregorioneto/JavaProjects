package com.ordermanagement.backend.domain.modal;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private String nameCLient;
    private Date orderData;
    private List<Item> items;

    public Order() {}
    public Order(UUID id, String nameClient, Date orderData, List<Item> items) {
        this.id = id;
        this.nameCLient = nameClient;
        this.orderData = orderData;
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public String getNameCLient() {
        return nameCLient;
    }

    public Date getOrderData() {
        return orderData;
    }

    public List<Item> getItems() {
        return items;
    }
}
