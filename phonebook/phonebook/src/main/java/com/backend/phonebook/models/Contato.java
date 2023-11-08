package com.backend.phonebook.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private int idade;

    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    public Contato() {
    }

    public Contato(Long id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
