package com.ordermanagement.backend.domain.service;

import com.ordermanagement.backend.domain.interfaces.IOrderRepository;
import com.ordermanagement.backend.domain.modal.Order;

public class OrderService {
    private IOrderRepository repository;
    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    public void create(Order order) {
        this.repository.save(order);
    }
}
