package com.ordermanagement.backend.infrastructure.persistence.order;

import com.ordermanagement.backend.domain.interfaces.IOrderRepository;
import com.ordermanagement.backend.domain.modal.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderRepository implements IOrderRepository {

    @Autowired
    private OrderJPARepository repository;


    @Override
    public void save(Order order) {
        this.repository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return this.repository.findAll();
    }
}
