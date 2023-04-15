package com.productregistration.backend.Product.services;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductService {
    private IProductRepository repository;

    public FindAllProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> execute() {
        return this.repository.findAll();
    }
}
