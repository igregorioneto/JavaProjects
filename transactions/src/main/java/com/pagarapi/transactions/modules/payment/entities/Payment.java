package com.pagarapi.transactions.modules.payment.entities;

import com.pagarapi.transactions.modules.cards.entities.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valueTransaction;
    private String description;
    @Enumerated(EnumType.STRING)
    private MethodPayment methodPayment;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double fee;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    public Payment(double valueTransaction, String description, MethodPayment methodPayment, Status status, double fee, Card card) {
        this.valueTransaction = valueTransaction;
        this.description = description;
        this.methodPayment = methodPayment;
        this.status = status;
        this.fee = fee;
        this.card = card;
    }
}
