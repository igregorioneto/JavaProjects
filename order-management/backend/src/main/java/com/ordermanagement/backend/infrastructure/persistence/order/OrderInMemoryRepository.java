package com.ordermanagement.backend.infrastructure.persistence.order;

import com.ordermanagement.backend.domain.interfaces.IOrderRepository;
import com.ordermanagement.backend.domain.modal.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderInMemoryRepository implements IOrderRepository {
    List<Order> orders;

    public OrderInMemoryRepository() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void save(Order order) {
        this.orders.add(order);
    }

    @Override
    public List<Order> getAll() {
        return this.orders;
    }
}
