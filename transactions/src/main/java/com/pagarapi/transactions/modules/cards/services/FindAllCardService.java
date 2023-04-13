package com.pagarapi.transactions.modules.cards.services;

import com.pagarapi.transactions.modules.cards.entities.Card;
import com.pagarapi.transactions.modules.cards.repositories.ICardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FindAllCardService {
    private ICardRepository repository;

    public FindAllCardService(ICardRepository repository) {
        this.repository = repository;
    }

    public List<Card> execute() {
        return this.repository.findAll();
    }
}
