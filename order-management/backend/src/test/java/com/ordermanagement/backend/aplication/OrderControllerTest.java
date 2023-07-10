package com.ordermanagement.backend.aplication;

import com.ordermanagement.backend.domain.modal.Item;
import com.ordermanagement.backend.domain.modal.Order;
import com.ordermanagement.backend.domain.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderControllerTest {

    @Mock
    private OrderService service;

    private OrderController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new OrderController(service);
    }

    @Test
    void should_be_able_create_order_controller() {
        UUID id = UUID.randomUUID();
        String nameClient = "João";
        LocalDate date = LocalDate.now();
        Date orderData = java.sql.Date.valueOf(date);

        Item item1 = new Item(UUID.randomUUID(), "Notebook", 3000);
        Item item2 = new Item(UUID.randomUUID(), "Geladeira", 4000);
        List<Item> items = new ArrayList<>();
        items.addAll(List.of(item1, item2));

        Order order = new Order(id, nameClient, orderData, items);

        OrderController.create(order);

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(service).create(orderCaptor.capture());
        Order orderSaved = orderCaptor.getValue();
        Assertions.assertEquals(order, orderSaved);

    }

    @Test
    void should_be_able_list_oders_controller() {
        UUID id = UUID.randomUUID();
        String nameClient = "João";
        LocalDate date = LocalDate.now();
        Date orderData = java.sql.Date.valueOf(date);

        Item item1 = new Item(UUID.randomUUID(), "Notebook", 3000);
        Item item2 = new Item(UUID.randomUUID(), "Geladeira", 4000);
        List<Item> items = new ArrayList<>();
        items.addAll(List.of(item1, item2));

        Order order = new Order(id, nameClient, orderData, items);
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        when(service.getAll()).thenReturn(orders);
        ResponseEntity<List<Order>> response = controller.getAll();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(orders, response.getBody());
    }

}
