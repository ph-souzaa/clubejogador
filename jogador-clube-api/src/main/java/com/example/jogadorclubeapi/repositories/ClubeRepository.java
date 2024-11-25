package com.example.jogadorclubeapi.repositories;

import com.example.jogadorclubeapi.models.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
}
