package com.backend.backend.entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
public class Card extends BaseEntity {

    @Column(length = 16)
    private String numeration;

    @Column(length = 4)
    private String validity;

    @Column(name = "security_code",length = 4)
    private String securityCode;

    @Column(columnDefinition = "varchar(10)")
    private String type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public TypeCard getType() {
        return TypeCard.valueOf(type.toUpperCase());
    }

    public void setType(TypeCard type) {
        this.type = type.getValue();
    }

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
}
