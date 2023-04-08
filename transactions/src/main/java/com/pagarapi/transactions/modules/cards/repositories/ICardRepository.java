package com.pagarapi.transactions.modules.cards.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;

import java.util.List;

public interface ICardRepository {
    public Card save(Card card);

    public List<Card> findAll();

    public Card findByNumbering(String numbering);
}
