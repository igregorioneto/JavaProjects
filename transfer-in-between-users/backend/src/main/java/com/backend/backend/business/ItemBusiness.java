package com.backend.backend.business;

import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.Item;
import com.backend.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemBusiness extends GenericServiceImpl<Item, UUID, ItemRepository> {
    public ItemBusiness(ItemRepository repository) {
        super(repository);
    }
}
