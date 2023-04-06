package com.pagarapi.transactions.modules.cards.repositories;

import com.pagarapi.transactions.modules.cards.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardJPARepository extends JpaRepository<Card, UUID> {
}
