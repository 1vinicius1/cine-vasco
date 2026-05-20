package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.SalaDTO;
import com.cinema.crvg.services.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> buscarPorId(@PathVariable Long id) {
        SalaDTO salaDTO = salaService.buscarPorId(id);
        return ResponseEntity.ok(salaDTO);
    }

    @GetMapping
    public ResponseEntity<List<SalaDTO>> listarTodas() {
        List<SalaDTO> salas = salaService.listarTodas();
        return ResponseEntity.ok(salas);
    }

    @PostMapping
    public ResponseEntity<SalaDTO> criar(@RequestBody SalaDTO salaDTO) {
        SalaDTO salaCriada = salaService.salvar(salaDTO);
        URI location = URI.create("/salas/" + salaCriada.getIdSala());
        return ResponseEntity.created(location).body(salaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> atualizar(@PathVariable Long id, @RequestBody SalaDTO salaDTO) {
        SalaDTO salaAtualizada = salaService.atualizar(id, salaDTO);
        return ResponseEntity.ok(salaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
