package com.ordermanagement.backend.aplication;

import com.ordermanagement.backend.domain.modal.Order;
import com.ordermanagement.backend.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public static ResponseEntity<Void> create(@RequestBody Order order) {
        service.create(order);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
