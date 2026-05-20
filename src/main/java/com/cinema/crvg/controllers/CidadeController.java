package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.CidadeDTO;
import com.cinema.crvg.services.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarPorId(@PathVariable Long id) {
        CidadeDTO cidadeDTO = cidadeService.buscarPorId(id);
        return ResponseEntity.ok(cidadeDTO);
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> listarTodas() {
        List<CidadeDTO> cidades = cidadeService.listarTodas();
        return ResponseEntity.ok(cidades);
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> criar(@RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidadeCriada = cidadeService.salvar(cidadeDTO);
        URI location = URI.create("/cidades/" + cidadeCriada.getIdCidade());
        return ResponseEntity.created(location).body(cidadeCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeDTO> atualizar(@PathVariable Long id, @RequestBody CidadeDTO cidadeDTO) {
        CidadeDTO cidadeAtualizada = cidadeService.atualizar(id, cidadeDTO);
        return ResponseEntity.ok(cidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
