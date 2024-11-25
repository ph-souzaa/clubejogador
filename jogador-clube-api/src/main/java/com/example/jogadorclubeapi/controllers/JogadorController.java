package com.example.jogadorclubeapi.controllers;

import com.example.jogadorclubeapi.dtos.JogadorDTO;
import com.example.jogadorclubeapi.models.Jogador;
import com.example.jogadorclubeapi.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public List<JogadorDTO> obterTodosJogadores() {
        return jogadorService.obterTodosJogadores().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public JogadorDTO obterJogadorPorId(@PathVariable Long id) {
        Jogador jogador = jogadorService.obterJogadorPorId(id);
        return converterParaDTO(jogador);
    }

    @PostMapping
    public JogadorDTO criarJogador(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.criarJogador(jogador);
        return converterParaDTO(novoJogador);
    }

    @PutMapping("/{id}")
    public JogadorDTO atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        Jogador jogadorAtualizado = jogadorService.atualizarJogador(id, jogador);
        return converterParaDTO(jogadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Long id) {
        jogadorService.deletarJogador(id);
    }

    // Conversão de Jogador para DTO
    private JogadorDTO converterParaDTO(Jogador jogador) {
        JogadorDTO dto = new JogadorDTO();
        dto.setId(jogador.getId());
        dto.setNome(jogador.getNome());
        dto.setClubeId(jogador.getClube().getId());
        return dto;
    }
}
