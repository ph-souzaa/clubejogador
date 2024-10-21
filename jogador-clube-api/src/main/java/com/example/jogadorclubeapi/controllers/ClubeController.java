// controllers/ClubeController.java
package com.example.jogadorclubeapi.controllers;

import com.example.jogadorclubeapi.models.Clube;
import com.example.jogadorclubeapi.services.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    @Autowired
    private ClubeService clubeService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Collection<Clube> obterTodosClubes() {
        return clubeService.obterTodosClubes();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Clube obterClubePorId(@PathVariable Long id) {
        return clubeService.obterClubePorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Clube criarClube(@RequestBody Clube clube) {
        return clubeService.criarClube(clube);
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Clube atualizarClube(@PathVariable Long id, @RequestBody Clube clube) {
        return clubeService.atualizarClube(id, clube);
    }

    @DeleteMapping("/{id}")
    public void deletarClube(@PathVariable Long id) {
        clubeService.deletarClube(id);
    }
}
