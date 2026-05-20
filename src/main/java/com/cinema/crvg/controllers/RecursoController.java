package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.RecursoDTO;
import com.cinema.crvg.services.RecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> buscarPorId(@PathVariable Long id) {
        RecursoDTO recursoDTO = recursoService.buscarPorId(id);
        return ResponseEntity.ok(recursoDTO);
    }

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> listarTodos() {
        List<RecursoDTO> recursos = recursoService.listarTodos();
        return ResponseEntity.ok(recursos);
    }

    @PostMapping
    public ResponseEntity<RecursoDTO> criar(@RequestBody RecursoDTO recursoDTO) {
        RecursoDTO recursoCriado = recursoService.salvar(recursoDTO);
        URI location = URI.create("/recursos/" + recursoCriado.getIdRecurso());
        return ResponseEntity.created(location).body(recursoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoDTO> atualizar(@PathVariable Long id, @RequestBody RecursoDTO recursoDTO) {
        RecursoDTO recursoAtualizado = recursoService.atualizar(id, recursoDTO);
        return ResponseEntity.ok(recursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        recursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
