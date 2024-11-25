package com.example.jogadorclubeapi.controllers;

import com.example.jogadorclubeapi.dtos.ClubeDTO;
import com.example.jogadorclubeapi.models.Clube;
import com.example.jogadorclubeapi.services.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @Autowired
    private ClubeService clubeService;

    @GetMapping
    public List<ClubeDTO> obterTodosClubes() {
        return clubeService.obterTodosClubes().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClubeDTO obterClubePorId(@PathVariable Long id) {
        Clube clube = clubeService.obterClubePorId(id);
        return converterParaDTO(clube);
    }

    @PostMapping
    public ClubeDTO criarClube(@RequestBody Clube clube) {
        Clube novoClube = clubeService.criarClube(clube);
        return converterParaDTO(novoClube);
    }

    @PutMapping("/{id}")
    public ClubeDTO atualizarClube(@PathVariable Long id, @RequestBody Clube clube) {
        Clube clubeAtualizado = clubeService.atualizarClube(id, clube);
        return converterParaDTO(clubeAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarClube(@PathVariable Long id) {
        clubeService.deletarClube(id);
    }

    // Conversão de Clube para DTO
    private ClubeDTO converterParaDTO(Clube clube) {
        ClubeDTO dto = new ClubeDTO();
        dto.setId(clube.getId());
        dto.setNome(clube.getNome());
        dto.setJogadoresIds(
                clube.getJogadores().stream().map(jogador -> jogador.getId()).collect(Collectors.toList())
        );
        return dto;
    }
}
