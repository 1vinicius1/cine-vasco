package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.IngressoDTO;
import com.cinema.crvg.services.IngressoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngressoDTO> buscarPorId(@PathVariable Long id) {
        IngressoDTO ingressoDTO = ingressoService.buscarPorId(id);
        return ResponseEntity.ok(ingressoDTO);
    }

    @GetMapping
    public ResponseEntity<List<IngressoDTO>> listarTodos() {
        List<IngressoDTO> ingressos = ingressoService.listarTodos();
        return ResponseEntity.ok(ingressos);
    }

    @PostMapping
    public ResponseEntity<IngressoDTO> criar(@RequestBody @Valid IngressoDTO ingressoDTO) {
        IngressoDTO ingressoCriado = ingressoService.salvar(ingressoDTO);
        URI location = URI.create("/ingressos/" + ingressoCriado.getIdIngresso());
        return ResponseEntity.created(location).body(ingressoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngressoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid IngressoDTO ingressoDTO) {
        IngressoDTO ingressoAtualizado = ingressoService.atualizar(id, ingressoDTO);
        return ResponseEntity.ok(ingressoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ingressoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
