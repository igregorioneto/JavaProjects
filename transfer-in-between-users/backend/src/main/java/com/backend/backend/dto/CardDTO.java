package com.backend.backend.dto;

import com.backend.backend.entity.enums.TypeCard;

import java.util.UUID;

public class CardDTO {
    private String numeration;
    private String validity;
    private String securityCode;

    private Double availableValue;

    private TypeCard type;
    private UUID account_id;

    public String getNumeration() {
        return numeration;
    }

    public void setNumeration(String numeration) {
        this.numeration = numeration;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Double getAvailableValue() {
        return availableValue;
    }

    public void setAvailableValue(Double availableValue) {
        this.availableValue = availableValue;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    public UUID getAccount_id() {
        return account_id;
    }

    public void setAccount_id(UUID account_id) {
        this.account_id = account_id;
    }
}
