package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.SessaoDTO;
import com.cinema.crvg.services.SessaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessaoDTO> buscarPorId(@PathVariable Long id) {
        SessaoDTO sessaoDTO = sessaoService.buscarPorId(id);
        return ResponseEntity.ok(sessaoDTO);
    }

    @GetMapping
    public ResponseEntity<List<SessaoDTO>> listarTodas() {
        List<SessaoDTO> sessoes = sessaoService.listarTodas();
        return ResponseEntity.ok(sessoes);
    }

    @PostMapping
    public ResponseEntity<SessaoDTO> criar(@RequestBody @Valid SessaoDTO sessaoDTO) {
        SessaoDTO sessaoCriada = sessaoService.salvar(sessaoDTO);
        URI location = URI.create("/sessoes/" + sessaoCriada.getIdSessao());
        return ResponseEntity.created(location).body(sessaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessaoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid SessaoDTO sessaoDTO) {
        SessaoDTO sessaoAtualizada = sessaoService.atualizar(id, sessaoDTO);
        return ResponseEntity.ok(sessaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sessaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
