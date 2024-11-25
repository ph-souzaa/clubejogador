package com.example.jogadorclubeapi.services;

import com.example.jogadorclubeapi.models.Clube;
import com.example.jogadorclubeapi.repositories.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubeService {

    @Autowired
    private ClubeRepository clubeRepository;

    public List<Clube> obterTodosClubes() {
        return clubeRepository.findAll();
    }

    public Clube obterClubePorId(Long id) {
        return clubeRepository.findById(id).orElse(null);
    }

    public Clube criarClube(Clube clube) {
        return clubeRepository.save(clube);
    }

    public Clube atualizarClube(Long id, Clube clubeAtualizado) {
        Clube clube = obterClubePorId(id);
        if (clube != null) {
            clube.setNome(clubeAtualizado.getNome());
            return clubeRepository.save(clube);
        }
        return null;
    }

    public void deletarClube(Long id) {
        clubeRepository.deleteById(id);
    }
}
