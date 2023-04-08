package com.pagarapi.transactions.modules.cards.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardRepository implements ICardRepository {
    @Autowired
    private CardJPARepository repository;

    @Override
    public Card save(Card card) {
        return this.repository.save(card);
    }

    @Override
    public List<Card> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Card findByNumbering(String numbering) {
        return this.repository.findByNumbering(numbering);
    }
}
