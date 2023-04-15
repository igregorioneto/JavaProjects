package com.productregistration.backend.Product.services;

import com.productregistration.backend.Product.entities.Product;
import com.productregistration.backend.Product.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindByIdProductService {
    private IProductRepository repository;

    public FindByIdProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(Long id) {
        return this.repository.findById(id);
    }
}
