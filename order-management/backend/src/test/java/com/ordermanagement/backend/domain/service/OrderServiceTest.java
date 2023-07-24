package com.ordermanagement.backend.domain.service;

import com.ordermanagement.backend.domain.modal.Item;
import com.ordermanagement.backend.domain.modal.Order;
import com.ordermanagement.backend.infrastructure.persistence.memory.OrderInMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderServiceTest {

    @Test
    void should_be_able_created_order() {
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
        OrderService service = new OrderService(repository);

        service.create(order);

        List<Order> allOrders = repository.getAll();

        Order orderList = allOrders.get(0);

        assertThat(orderList.getId()).isEqualTo(id);
        assertThat(orderList.getNameCLient()).isEqualTo(nameClient);
        assertThat(orderList.getOrderData()).isEqualTo(orderData);
        assertThat(orderList.getItems()).isEqualTo(items);

        Assertions.assertEquals(1, allOrders.size());
        Assertions.assertEquals(order, allOrders.get(0));

    }

    @Test
    void should_be_able_list_orders() {
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
        OrderService service = new OrderService(repository);

        service.create(order);

        List<Order> allOrders = repository.getAll();

        Order orderList = allOrders.get(0);

        Assertions.assertNotNull(allOrders);

        Assertions.assertEquals(1, allOrders.size());
        Assertions.assertEquals(order, allOrders.get(0));
    }

}
