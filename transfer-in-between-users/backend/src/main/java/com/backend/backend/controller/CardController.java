package com.backend.backend.controller;

import com.backend.backend.business.AccountBusiness;
import com.backend.backend.business.CardBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.CardDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Account;
import com.backend.backend.entity.Card;
import com.backend.backend.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/card")
public class CardController extends GenericControllerImpl<Card, UUID, CardBusiness> {

    @Autowired
    private AccountBusiness accountBusiness;

    @Autowired
    private ResponseMessage<Card> successResponse;

    @Autowired
    private ResponseMessage<String> errorResponse;

    public CardController(CardBusiness service) {
        super(service);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDTO<?>> create(@RequestBody CardDTO cardDTO) {
        try {
            Account account = accountBusiness.getById(cardDTO.getAccount_id()).orElse(null);

            if(account == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorResponse.MessageReturn("Error", HttpStatus.NOT_FOUND.value(), "Account not exists")
                );
            }

            Card card = new Card(
                    cardDTO.getNumeration(),
                    cardDTO.getValidity(),
                    cardDTO.getSecurityCode(),
                    cardDTO.getType(),
                    account
            );

            account.getCards().add(card);
            accountBusiness.save(account);

            Card c = service.save(card);

            return ResponseEntity.ok(
                    successResponse.MessageReturn("Success", HttpStatus.OK.value(), c)
            );
        } catch (Exception e) {
            if (!response.is)
            throw new InternalError(e.getMessage());
        }
    }
}
