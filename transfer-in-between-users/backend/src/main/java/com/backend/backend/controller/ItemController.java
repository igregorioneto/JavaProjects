package com.backend.backend.controller;

import com.backend.backend.business.ItemBusiness;
import com.backend.backend.business.ShoppingCartBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.ItemShoppingCartDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Item;
import com.backend.backend.entity.ShoppingCart;
import com.backend.backend.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/item")
public class ItemController extends GenericControllerImpl<Item, UUID, ItemBusiness> {
    @Autowired
    private ShoppingCartBusiness shoppingCartBusiness;

    @Autowired
    private ResponseMessage<String> successMessage;

    @Autowired
    private ResponseMessage<String> errorMessage;

    public ItemController(ItemBusiness service) {
        super(service);
    }

    @PostMapping("/add-item-shopping-cart")
    public ResponseEntity<SuccessResponseDTO<?>> addItemShoppingCart(@RequestBody ItemShoppingCartDTO dto) {
        try {
            ShoppingCart shoppingCart = shoppingCartBusiness.getById(dto.getShopping_cart_id()).orElse(null);

            Item item = service.getById(dto.getItem_id()).orElse(null);

            item.setShoppingCart(shoppingCart);

            service.update(item.getId(), item);

            return ResponseEntity.ok().body(
              successMessage.MessageReturn(
                      "Success",
                      HttpStatus.OK.value(),
                      "Success! item " + item.getName() +" shipped to Shopping Cart!"
              )
            );
        } catch (InternalError e) {
            throw new InternalError(e.getMessage());
        }
    }
}
