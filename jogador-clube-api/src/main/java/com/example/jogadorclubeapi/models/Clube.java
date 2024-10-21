package com.example.jogadorclubeapi.models;

import java.util.ArrayList;
import java.util.List;

public class Clube {
    private Long id;
    private String nome;
    private List<Jogador> jogadores = new ArrayList<>();

    public Clube() {
    }

    public Clube(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
