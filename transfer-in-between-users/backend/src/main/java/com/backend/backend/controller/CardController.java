package com.backend.backend.controller;

import com.backend.backend.business.AccountBusiness;
import com.backend.backend.business.CardBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.CardDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Account;
import com.backend.backend.entity.Card;
import com.backend.backend.util.ResponseMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Card card = new Card();

            card.setType(cardDTO.getType());
            card.setValidity(cardDTO.getValidity());
            card.setSecurityCode(cardDTO.getSecurityCode());
            card.setNumeration(cardDTO.getNumeration());
            card.setAvailableValue(cardDTO.getAvailableValue());

            if(account != null) {
                card.setAccount(account);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorResponse.MessageReturn("Error", HttpStatus.NOT_FOUND.value(), "Account not exists")
                );
            }

            Card c = service.save(card);

            return ResponseEntity.ok(
                    successResponse.MessageReturn("Success", HttpStatus.OK.value(), c)
            );
        } catch (Exception e) {
            throw new InternalError(e.getMessage());
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
