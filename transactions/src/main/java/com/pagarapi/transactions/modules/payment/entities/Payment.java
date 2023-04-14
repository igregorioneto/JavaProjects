package com.pagarapi.transactions.modules.payment.entities;

import com.pagarapi.transactions.modules.cards.entities.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String methodPayment;
    private String status;
    private double fee;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    public Payment( double valueTransaction, String description, String methodPayment, String status, double fee, Card card) {
        this.valueTransaction = valueTransaction;
        this.description = description;
        this.methodPayment = methodPayment;
        this.status = status;
        this.fee = fee;
        this.card = card;
    }
}
