package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.FilmeDTO;
import com.cinema.crvg.services.FilmeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> buscarPorId(@PathVariable Long id) {
        FilmeDTO filmeDTO = filmeService.buscarPorId(id);
        return ResponseEntity.ok(filmeDTO);
    }

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listarTodos() {
        List<FilmeDTO> filmes = filmeService.listarTodos();
        return ResponseEntity.ok(filmes);
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> criar(@RequestBody @Valid FilmeDTO filmeDTO) {
        FilmeDTO filmeCriado = filmeService.salvar(filmeDTO);
        URI location = URI.create("/filmes/" + filmeCriado.getIdFilme());
        return ResponseEntity.created(location).body(filmeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @RequestBody @Valid FilmeDTO filmeDTO) {
        FilmeDTO filmeAtualizado = filmeService.atualizar(id, filmeDTO);
        return ResponseEntity.ok(filmeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
