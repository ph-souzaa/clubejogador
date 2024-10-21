package com.example.jogadorclubeapi.services;

import com.example.jogadorclubeapi.models.Jogador;
import com.example.jogadorclubeapi.models.Clube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JogadorService {

    private Map<Long, Jogador> jogadores = new HashMap<>();
    private Long contadorId = 1L;

    @Autowired
    private ClubeService clubeService;

    public Collection<Jogador> obterTodosJogadores() {
        return jogadores.values();
    }

    public Jogador obterJogadorPorId(Long id) {
        return jogadores.get(id);
    }

    public Jogador criarJogador(Jogador jogador) {
        jogador.setId(contadorId++);
        jogadores.put(jogador.getId(), jogador);

        // Adiciona o jogador à lista de jogadores do clube
        Clube clube = clubeService.obterClubePorId(jogador.getClubeId());
        if (clube != null) {
            clube.getJogadores().add(jogador);
        }
        return jogador;
    }

    public Jogador atualizarJogador(Long id, Jogador jogador) {
        jogador.setId(id);
        jogadores.put(id, jogador);
        return jogador;
    }

    public void deletarJogador(Long id) {
        Jogador jogador = jogadores.remove(id);
        if (jogador != null) {
            // Remove o jogador da lista de jogadores do clube
            Clube clube = clubeService.obterClubePorId(jogador.getClubeId());
            if (clube != null) {
                clube.getJogadores().removeIf(j -> j.getId().equals(id));
            }
        }
    }
}
