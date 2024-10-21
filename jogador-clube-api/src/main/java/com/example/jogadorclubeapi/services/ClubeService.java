package com.example.jogadorclubeapi.services;

import com.example.jogadorclubeapi.models.Clube;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClubeService {

    private Map<Long, Clube> clubes = new HashMap<>();
    private Long contadorId = 1L;

    public Collection<Clube> obterTodosClubes() {
        return clubes.values();
    }

    public Clube obterClubePorId(Long id) {
        return clubes.get(id);
    }

    public Clube criarClube(Clube clube) {
        clube.setId(contadorId++);
        clubes.put(clube.getId(), clube);
        return clube;
    }

    public Clube atualizarClube(Long id, Clube clube) {
        clube.setId(id);
        clubes.put(id, clube);
        return clube;
    }

    public void deletarClube(Long id) {
        clubes.remove(id);
    }
}
