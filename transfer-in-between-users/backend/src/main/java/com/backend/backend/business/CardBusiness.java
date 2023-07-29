package com.backend.backend.business;

import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.Card;
import com.backend.backend.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardBusiness extends GenericServiceImpl<Card, UUID, CardRepository> {
    public CardBusiness(CardRepository repository) {
        super(repository);
    }
}
