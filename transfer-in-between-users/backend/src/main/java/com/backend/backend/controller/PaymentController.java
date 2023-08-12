package com.backend.backend.controller;

import com.backend.backend.business.CardBusiness;
import com.backend.backend.business.PaymentBusiness;
import com.backend.backend.business.ShoppingCartBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.PaymentDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Card;
import com.backend.backend.entity.Payment;
import com.backend.backend.entity.ShoppingCart;
import com.backend.backend.entity.enums.FormOfPayment;
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
@RequestMapping("/api/payment")
public class PaymentController extends GenericControllerImpl<Payment, UUID, PaymentBusiness> {
    @Autowired
    private ShoppingCartBusiness shoppingCartBusiness;

    @Autowired
    private CardBusiness cardBusiness;

    @Autowired
    private ResponseMessage<Payment> successMessage;

    @Autowired
    private ResponseMessage<String> errorMessage;


    public PaymentController(PaymentBusiness service) {
        super(service);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDTO<?>> create(@RequestBody PaymentDTO dto) {
        try {
            Payment payment = new Payment();

            ShoppingCart shoppingCart = shoppingCartBusiness.getById(dto.getShopping_cart_id()).orElse(null);
            if (shoppingCart == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorMessage.MessageReturn(
                                "Error",
                                HttpStatus.NO_CONTENT.value(),
                                "Dont found shopping cart"
                        )
                );
            }

            switch (dto.getFormOfPayment()) {
                case CARD:
                    Card cardSelected = (Card) shoppingCart
                            .getAccount()
                            .getCards()
                            .stream()
                            .map(c -> c.getId().equals(dto.getCard_selected()));

                    if (cardSelected.getAvailableValue() >= shoppingCart.getTotalPayment()) {
                        // successful payment
                        // discount the value of card
                    }
                    break;
                case VOUCHER:
                    if (shoppingCart.getAccount().getVoucher() >= shoppingCart.getTotalPayment()) {
                        // successful payment
                        // discount the value of the voucher
                    }
                    break;
                case TICKET:
                    break;
                default:
                    break;
            }

            return ResponseEntity.ok(
                    successMessage.MessageReturn("Success", HttpStatus.OK.value(), payment)
            );
        } catch (InternalError e) {
            throw new InternalError(e.getMessage());
        }
    }
}
