package com.backend.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10)")
    private TypeCard type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Card() {}

    public Card(String numeration, String validity, String securityCode, TypeCard type, Account account) {
        this.numeration = numeration;
        this.validity = validity;
        this.securityCode = securityCode;
        this.type = type;
        this.account = account;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
