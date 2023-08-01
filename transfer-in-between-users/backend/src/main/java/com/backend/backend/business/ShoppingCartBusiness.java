package com.backend.backend.business;

import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.ShoppingCart;
import com.backend.backend.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShoppingCartBusiness extends GenericServiceImpl<ShoppingCart, UUID, ShoppingCartRepository> {
    public ShoppingCartBusiness(ShoppingCartRepository repository) {
        super(repository);
    }
}
