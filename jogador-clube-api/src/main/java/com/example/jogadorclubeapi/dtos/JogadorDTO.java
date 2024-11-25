package com.example.jogadorclubeapi.dtos;

public class JogadorDTO {
    private Long id;
    private String nome;
    private Long clubeId; // Apenas o ID do clube

    // Getters e Setters
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

    public Long getClubeId() {
        return clubeId;
    }

    public void setClubeId(Long clubeId) {
        this.clubeId = clubeId;
    }
}
