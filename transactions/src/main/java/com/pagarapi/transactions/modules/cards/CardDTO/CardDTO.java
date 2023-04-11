package com.pagarapi.transactions.modules.cards.CardDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

public class CardDTO {
    private UUID id;
    private String numbering;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date validity;
    private String clientCPF;

    public CardDTO(UUID id,String numbering, Date validity, String clientCPF) {
        this.id = id;
        this.numbering = numbering;
        this.validity = validity;
        this.clientCPF = clientCPF;
    }

    public CardDTO() {}

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getClientCPF() {
        return clientCPF;
    }

    public void setClientCPF(String clientCPF) {
        this.clientCPF = clientCPF;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
