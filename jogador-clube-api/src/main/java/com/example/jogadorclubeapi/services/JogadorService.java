package com.example.jogadorclubeapi.services;

import com.example.jogadorclubeapi.models.Jogador;
import com.example.jogadorclubeapi.models.Clube;
import com.example.jogadorclubeapi.repositories.JogadorRepository;
import com.example.jogadorclubeapi.repositories.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private ClubeRepository clubeRepository;

    public List<Jogador> obterTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador obterJogadorPorId(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    public Jogador criarJogador(Jogador jogador) {
        Clube clube = clubeRepository.findById(jogador.getClube().getId()).orElse(null);
        if (clube != null) {
            jogador.setClube(clube);
            return jogadorRepository.save(jogador);
        }
        throw new RuntimeException("Clube não encontrado");
    }

    public Jogador atualizarJogador(Long id, Jogador jogadorAtualizado) {
        Jogador jogador = obterJogadorPorId(id);
        if (jogador != null) {
            jogador.setNome(jogadorAtualizado.getNome());
            return jogadorRepository.save(jogador);
        }
        return null;
    }

    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }
}
