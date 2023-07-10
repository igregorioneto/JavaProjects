package com.ordermanagement.backend.domain.service;

import com.ordermanagement.backend.domain.interfaces.IOrderRepository;
import com.ordermanagement.backend.domain.modal.Order;

import java.util.List;

public class OrderService {
    private IOrderRepository repository;
    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    public void create(Order order) {
        this.repository.save(order);
    }

    public List<Order> getAll() {
        return this.repository.getAll();
    }
}
