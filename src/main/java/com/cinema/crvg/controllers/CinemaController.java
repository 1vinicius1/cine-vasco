package com.cinema.crvg.controllers;

import com.cinema.crvg.dto.CinemaDTO;
import com.cinema.crvg.services.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaDTO> buscarPorId(@PathVariable Long id) {
        CinemaDTO cinemaDTO = cinemaService.buscarPorId(id);
        return ResponseEntity.ok(cinemaDTO);
    }

    @GetMapping
    public ResponseEntity<List<CinemaDTO>> listarTodos() {
        List<CinemaDTO> cinemas = cinemaService.listarTodos();
        return ResponseEntity.ok(cinemas);
    }

    @PostMapping
    public ResponseEntity<CinemaDTO> criar(@RequestBody CinemaDTO cinemaDTO) {
        CinemaDTO cinemaCriado = cinemaService.salvar(cinemaDTO);
        URI location = URI.create("/cinemas/" + cinemaCriado.getIdCinema());
        return ResponseEntity.created(location).body(cinemaCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CinemaDTO> atualizar(@PathVariable Long id, @RequestBody CinemaDTO cinemaDTO) {
        CinemaDTO cinemaAtualizado = cinemaService.atualizar(id, cinemaDTO);
        return ResponseEntity.ok(cinemaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cinemaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
