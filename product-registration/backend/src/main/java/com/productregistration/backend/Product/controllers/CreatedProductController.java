package com.productregistration.backend.Product.controllers;

import com.productregistration.backend.Product.dto.CreatedProductDTO;
import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.ProductRepository;
import com.productregistration.backend.Product.services.CreatedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class CreatedProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<Product> created(@RequestBody CreatedProductDTO productDTO) {
        try {
            CreatedProductService service = new CreatedProductService(repository);
            Product product = new Product(productDTO.getName(), productDTO.getProvider(), productDTO.getAmount());
            return new ResponseEntity<>(service.execute(product), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
