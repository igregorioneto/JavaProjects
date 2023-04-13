package com.pagarapi.transactions.modules.cards.CardDTO;

import lombok.Getter;

@Getter
public class CardDTO {
    private Long id;
    private String numbering;
    private String validity;
    private String clientCPF;

    public CardDTO(Long id,String numbering, String validity, String clientCPF) {
        this.id = id;
        this.numbering = numbering;
        this.validity = validity;
        this.clientCPF = clientCPF;
    }

    public CardDTO() {}
}
