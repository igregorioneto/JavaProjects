package com.productregistration.backend.Product.controllers;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.ProductRepository;
import com.productregistration.backend.Product.services.FindAllProductService;
import com.productregistration.backend.Product.services.FindByIdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class FindByIdProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        try {
            FindByIdProductService service = new FindByIdProductService(repository);
            return new ResponseEntity<>(service.execute(id), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
