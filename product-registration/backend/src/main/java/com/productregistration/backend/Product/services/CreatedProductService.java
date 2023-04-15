package com.productregistration.backend.Product.services;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatedProductService {
    private IProductRepository repository;

    public CreatedProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(Product product) {
        return this.repository.save(product);
    }
}
