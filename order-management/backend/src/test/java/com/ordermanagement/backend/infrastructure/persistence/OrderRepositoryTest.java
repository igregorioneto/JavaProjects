package com.ordermanagement.backend.infrastructure.persistence;

import com.ordermanagement.backend.domain.modal.Item;
import com.ordermanagement.backend.domain.modal.Order;
import com.ordermanagement.backend.infrastructure.persistence.order.OrderInMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class OrderRepositoryTest {

    @Test
    void should_be_able_create_order_repository() {
        UUID id = UUID.randomUUID();
        String nameClient = "João";
        LocalDate date = LocalDate.now();
        Date orderData = java.sql.Date.valueOf(date);

        Item item1 = new Item(UUID.randomUUID(), "Notebook", 3000);
        Item item2 = new Item(UUID.randomUUID(), "Geladeira", 4000);
        List<Item> items = new ArrayList<>();
        items.addAll(List.of(item1, item2));

        Order order = new Order(id, nameClient, orderData, items);

        OrderInMemoryRepository repository = new OrderInMemoryRepository();
        repository.save(order);

        List<Order> allOrders = repository.getAll();

        Order orderList = allOrders.get(0);

        Assertions.assertEquals(1, allOrders.size());
        Assertions.assertTrue(allOrders.contains(orderList));
    }

    @Test
    void should_be_able_list_orders_repository() {
        UUID id = UUID.randomUUID();
        String nameClient = "João";
        LocalDate date = LocalDate.now();
        Date orderData = java.sql.Date.valueOf(date);

        Item item1 = new Item(UUID.randomUUID(), "Notebook", 3000);
        Item item2 = new Item(UUID.randomUUID(), "Geladeira", 4000);
        List<Item> items = new ArrayList<>();
        items.addAll(List.of(item1, item2));

        Order order = new Order(id, nameClient, orderData, items);

        OrderInMemoryRepository repository = new OrderInMemoryRepository();

        repository.getAll().addAll(List.of(order));

        List<Order> allOrders = repository.getAll();

        Assertions.assertEquals(1, allOrders.size());
        Assertions.assertTrue(allOrders.contains(order));

    }

}
