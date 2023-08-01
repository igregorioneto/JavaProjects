package com.backend.backend.controller;

import com.backend.backend.business.ShoppingCartBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.entity.ShoppingCart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController extends GenericControllerImpl<ShoppingCart, UUID, ShoppingCartBusiness> {
    public ShoppingCartController(ShoppingCartBusiness service) {
        super(service);
    }
}
