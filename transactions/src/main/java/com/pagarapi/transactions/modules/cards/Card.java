package com.pagarapi.transactions.modules.cards;

import com.pagarapi.transactions.modules.clients.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String numbering;
    private Date validity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
