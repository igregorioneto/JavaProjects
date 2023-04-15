package com.productregistration.backend.Product.services;

import com.productregistration.backend.Product.repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {
    private IProductRepository repository;

    public DeleteProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        this.repository.delete(id);
    }
}
