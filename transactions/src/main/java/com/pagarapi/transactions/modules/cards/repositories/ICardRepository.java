package com.pagarapi.transactions.modules.cards.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ICardRepository {
    public Card save(Card card);

    public List<Card> findAll();

    public Card findByNumbering(String numbering);

    public Card findById(Long id);
}
