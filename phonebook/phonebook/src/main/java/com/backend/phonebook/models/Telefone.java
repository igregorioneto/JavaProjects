package com.backend.phonebook.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_contato")
    private Contato contato;

    public Telefone() {
    }

    public Telefone(Long id, String numero, Contato contato) {
        this.id = id;
        this.numero = numero;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
