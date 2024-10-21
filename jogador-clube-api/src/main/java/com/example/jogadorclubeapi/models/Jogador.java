package com.example.jogadorclubeapi.models;

public class Jogador {
    private Long id;
    private String nome;
    private Long clubeId;

    public Jogador() {
    }

    public Jogador(Long id, String nome, Long clubeId) {
        this.id = id;
        this.nome = nome;
        this.clubeId = clubeId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getClubeId() {
        return clubeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClubeId(Long clubeId) {
        this.clubeId = clubeId;
    }
}
