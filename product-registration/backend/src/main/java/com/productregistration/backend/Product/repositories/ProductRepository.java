package com.productregistration.backend.Product.repositories;

import com.productregistration.backend.Product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepository implements IProductRepository{

    @Autowired
    private ProductJPARepository repository;

    @Override
    public Product save(Product product) {
        return this.repository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Product update(Long id, Product product) {
        Product updatedProduct = this.repository.findById(id).orElse(null);
        updatedProduct.setName(product.getName());
        updatedProduct.setProvider(product.getProvider());
        updatedProduct.setAmount(product.getAmount());
        return this.repository.save(updatedProduct);
    }

    @Override
    public void delete(Long id) {
        Product product = this.repository.findById(id).orElse(null);
        this.repository.delete(product);
    }
}
