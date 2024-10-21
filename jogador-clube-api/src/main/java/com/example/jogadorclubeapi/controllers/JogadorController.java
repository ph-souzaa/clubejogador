// controllers/JogadorController.java
package com.example.jogadorclubeapi.controllers;

import com.example.jogadorclubeapi.models.Jogador;
import com.example.jogadorclubeapi.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Collection<Jogador> obterTodosJogadores() {
        return jogadorService.obterTodosJogadores();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Jogador obterJogadorPorId(@PathVariable Long id) {
        return jogadorService.obterJogadorPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorService.criarJogador(jogador);
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Jogador atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        return jogadorService.atualizarJogador(id, jogador);
    }

    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Long id) {
        jogadorService.deletarJogador(id);
    }
}
