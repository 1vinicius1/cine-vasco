package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.CadeiraDTO;
import com.cinema.crvg.services.CadeiraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cadeiras")
public class CadeiraController {

    private final CadeiraService cadeiraService;

    public CadeiraController(CadeiraService cadeiraService) {
        this.cadeiraService = cadeiraService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadeiraDTO> buscarPorId(@PathVariable Long id) {
        CadeiraDTO cadeiraDTO = cadeiraService.buscarPorId(id);
        return ResponseEntity.ok(cadeiraDTO);
    }

    @GetMapping
    public ResponseEntity<List<CadeiraDTO>> listarTodas() {
        List<CadeiraDTO> cadeiras = cadeiraService.listarTodas();
        return ResponseEntity.ok(cadeiras);
    }

    @PostMapping
    public ResponseEntity<CadeiraDTO> criar(@RequestBody @Valid CadeiraDTO cadeiraDTO) {
        CadeiraDTO cadeiraCriada = cadeiraService.salvar(cadeiraDTO);
        URI location = URI.create("/cadeiras/" + cadeiraCriada.getIdCadeira());
        return ResponseEntity.created(location).body(cadeiraCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadeiraDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CadeiraDTO cadeiraDTO) {
        CadeiraDTO cadeiraAtualizada = cadeiraService.atualizar(id, cadeiraDTO);
        return ResponseEntity.ok(cadeiraAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cadeiraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
