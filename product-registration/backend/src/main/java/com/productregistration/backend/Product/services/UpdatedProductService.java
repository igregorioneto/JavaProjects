package com.productregistration.backend.Product.services;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdatedProductService {
    private IProductRepository repository;

    public UpdatedProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(Long id, Product product) {
        return this.repository.update(id, product);
    }
}
