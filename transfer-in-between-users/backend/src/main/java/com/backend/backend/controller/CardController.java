package com.backend.backend.controller;

import com.backend.backend.business.CardBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.entity.Card;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(name = "card")
public class CardController extends GenericControllerImpl<Card, UUID, CardBusiness> {
    public CardController(CardBusiness service) {
        super(service);
    }
}
