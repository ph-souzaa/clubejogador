package com.example.jogadorclubeapi.repositories;

import com.example.jogadorclubeapi.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
