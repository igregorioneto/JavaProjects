package com.pagarapi.transactions.modules.cards.services;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.ICardRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatedCardService {
    private ICardRepository repository;

    public CreatedCardService(ICardRepository repository) {
        this.repository = repository;
    }

    public Card execute(Card card) {
        return this.repository.save(card);
    }
}
