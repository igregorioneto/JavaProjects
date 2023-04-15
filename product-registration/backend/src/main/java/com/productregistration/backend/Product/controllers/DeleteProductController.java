package com.productregistration.backend.Product.controllers;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.ProductRepository;
import com.productregistration.backend.Product.services.DeleteProductService;
import com.productregistration.backend.Product.services.FindByIdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
public class DeleteProductController {
    @Autowired
    private ProductRepository repository;

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> findById(@PathVariable Long id) {
        try {
            DeleteProductService service = new DeleteProductService(repository);
            service.execute(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
