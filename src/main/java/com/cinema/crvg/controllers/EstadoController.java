package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.EstadoDTO;
import com.cinema.crvg.services.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscarPorId(@PathVariable Long id) {
        EstadoDTO estadoDTO = estadoService.buscarPorId(id);
        return ResponseEntity.ok(estadoDTO);
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listarTodos() {
        List<EstadoDTO> estados = estadoService.listarTodos();
        return ResponseEntity.ok(estados);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> criar(@RequestBody EstadoDTO estadoDTO) {
        EstadoDTO estadoCriado = estadoService.salvar(estadoDTO);
        URI location = URI.create("/estados/" + estadoCriado.getIdEstado());
        return ResponseEntity.created(location).body(estadoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO) {
        EstadoDTO estadoAtualizado = estadoService.atualizar(id, estadoDTO);
        return ResponseEntity.ok(estadoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
