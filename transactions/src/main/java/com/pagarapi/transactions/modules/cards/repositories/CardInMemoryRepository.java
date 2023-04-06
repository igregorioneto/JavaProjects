package com.pagarapi.transactions.modules.cards.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardInMemoryRepository implements ICardRepository{
    List<Card> cards;

    public CardInMemoryRepository() {
        this.cards = new ArrayList<>();
    }

    @Override
    public Card save(Card card) {
        this.cards.add(card);
        card.setId(UUID.randomUUID());
        return card;
    }

    @Override
    public List<Card> findAll() {
        return this.cards;
    }
}
