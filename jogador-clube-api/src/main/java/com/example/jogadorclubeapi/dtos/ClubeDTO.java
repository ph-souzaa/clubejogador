package com.example.jogadorclubeapi.dtos;

import java.util.List;

public class ClubeDTO {
    private Long id;
    private String nome;

    // Apenas os IDs dos jogadores, para evitar duplicação
    private List<Long> jogadoresIds;

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

    public List<Long> getJogadoresIds() {
        return jogadoresIds;
    }

    public void setJogadoresIds(List<Long> jogadoresIds) {
        this.jogadoresIds = jogadoresIds;
    }
}
