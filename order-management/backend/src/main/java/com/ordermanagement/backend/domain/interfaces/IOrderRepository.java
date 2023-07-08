package com.ordermanagement.backend.domain.interfaces;

import com.ordermanagement.backend.domain.modal.Order;

import java.util.List;

public interface IOrderRepository {
    void save(Order order);

    List<Order> getAll();
}
