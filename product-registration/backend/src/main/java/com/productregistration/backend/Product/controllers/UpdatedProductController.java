package com.productregistration.backend.Product.controllers;

import com.productregistration.backend.Product.dto.CreatedProductDTO;
import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.ProductRepository;
import com.productregistration.backend.Product.services.CreatedProductService;
import com.productregistration.backend.Product.services.UpdatedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class UpdatedProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Product> created(@PathVariable Long id, @RequestBody CreatedProductDTO productDTO) {
        try {
            UpdatedProductService service = new UpdatedProductService(repository);
            Product product = new Product(productDTO.getName(), productDTO.getProvider(), productDTO.getAmount());
            return new ResponseEntity<>(service.execute(id, product), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
