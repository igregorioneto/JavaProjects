package com.productregistration.backend.Product.repositories;

import com.productregistration.backend.Product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Long> {

    void delete(Long id);
}
