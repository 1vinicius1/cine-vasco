package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.DiretorDTO;
import com.cinema.crvg.services.DiretorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorService diretorService;

    public DiretorController(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> buscarPorId(@PathVariable Long id) {
        DiretorDTO diretorDTO = diretorService.buscarPorId(id);
        return ResponseEntity.ok(diretorDTO);
    }

    @GetMapping
    public ResponseEntity<List<DiretorDTO>> listarTodos() {
        List<DiretorDTO> diretores = diretorService.listarTodos();
        return ResponseEntity.ok(diretores);
    }

    @PostMapping
    public ResponseEntity<DiretorDTO> criar(@RequestBody @Valid DiretorDTO diretorDTO) {
        DiretorDTO diretorCriado = diretorService.salvar(diretorDTO);
        URI location = URI.create("/diretores/" + diretorCriado.getIdDiretor());
        return ResponseEntity.created(location).body(diretorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiretorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid DiretorDTO diretorDTO) {
        DiretorDTO diretorAtualizado = diretorService.atualizar(id, diretorDTO);
        return ResponseEntity.ok(diretorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        diretorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
