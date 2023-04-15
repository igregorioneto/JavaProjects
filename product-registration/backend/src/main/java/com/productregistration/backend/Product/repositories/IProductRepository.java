package com.productregistration.backend.Product.repositories;

import com.productregistration.backend.Product.entities.Product;

import java.util.List;

public interface IProductRepository {
    public Product save(Product product);

    public List<Product> findAll();

    public Product findById(Long id);

    public Product update(Long id, Product product);

    public void delete(Long id);
}
