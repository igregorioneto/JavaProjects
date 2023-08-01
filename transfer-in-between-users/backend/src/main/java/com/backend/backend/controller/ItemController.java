package com.backend.backend.controller;

import com.backend.backend.business.ItemBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.entity.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/item")
public class ItemController extends GenericControllerImpl<Item, UUID, ItemBusiness> {
    public ItemController(ItemBusiness service) {
        super(service);
    }
}
