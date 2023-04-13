package com.pagarapi.transactions.modules.cards.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardInMemoryRepository implements ICardRepository{
    List<Card> cards;

    public CardInMemoryRepository() {
        this.cards = new ArrayList<>();
    }

    @Override
    public Card save(Card card) {
        this.cards.add(card);
        return card;
    }

    @Override
    public List<Card> findAll() {
        return this.cards;
    }

    @Override
    public Card findByNumbering(String numbering) {
        Optional<Card> optional = this.cards.stream().filter(card -> card.getNumbering().equals(numbering)).findFirst();
        return optional.orElse(null);
    }

    @Override
    public Card findById(Long id) {
        Optional<Card> optional = this.cards.stream().filter(card -> card.getId().equals(id)).findFirst();
        return optional.orElse(null);
    }
}
