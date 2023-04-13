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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;
}
