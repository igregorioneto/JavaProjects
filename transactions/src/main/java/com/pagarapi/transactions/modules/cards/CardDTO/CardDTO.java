package com.pagarapi.transactions.modules.cards.CardDTO;

import lombok.Getter;

@Getter
public class CardDTO {
    private String numbering;
    private String validity;
    private String clientCPF;

    public CardDTO(String numbering, String validity, String clientCPF) {
        this.numbering = numbering;
        this.validity = validity;
        this.clientCPF = clientCPF;
    }

    public CardDTO() {}
}
