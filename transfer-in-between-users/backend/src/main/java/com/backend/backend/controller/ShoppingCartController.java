package com.backend.backend.controller;

import cats.data.Op;
import com.backend.backend.business.AccountBusiness;
import com.backend.backend.business.ItemBusiness;
import com.backend.backend.business.ShoppingCartBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.ShoppingCartDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Account;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController extends GenericControllerImpl<ShoppingCart, UUID, ShoppingCartBusiness> {

    @Autowired
    private AccountBusiness accountBusiness;

    @Autowired
    private ItemBusiness itemBusiness;

    @Autowired
    private ResponseMessage<ShoppingCart> successMessage;

    @Autowired
    private ResponseMessage<String> errorMessage;

    public ShoppingCartController(ShoppingCartBusiness service) {
        super(service);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDTO<?>> create(@RequestBody ShoppingCartDTO dto) {
        try {
            Account account = accountBusiness.getById(dto.getAccount_id()).orElse(null);
            if(account == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorMessage.MessageReturn("Error", HttpStatus.NO_CONTENT.value(), "Not found account!")
                );
            }

            if (dto.getItems() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorMessage.MessageReturn("Error", HttpStatus.NO_CONTENT.value(),"Not found items")
                );
            }

            List<Item> items = new ArrayList<>();
            double totalPayment = 0;
            for (UUID i: dto.getItems()) {
                Item item = itemBusiness.getById(i).orElse(null);
                if (item != null) {
                    items.add((item));
                    totalPayment += item.getPrice();
                }
            }

            ShoppingCart shoppingCart = new ShoppingCart(items, account, totalPayment);

            return ResponseEntity.ok(
                    successMessage.MessageReturn("Success", HttpStatus.OK.value(),shoppingCart)
            );
        } catch (InternalError e) {
            throw new InternalError(e.getMessage());
        }
    }
}
