package com.productregistration.backend.Product.controllers;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.ProductRepository;
import com.productregistration.backend.Product.services.FindAllProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class FindAllProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        try {
            FindAllProductService service = new FindAllProductService(repository);
            return new ResponseEntity<>(service.execute(), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
