package com.cinema.crvg.services;

import com.cinema.crvg.dto.CinemaDTO;
import com.cinema.crvg.dto.SalaDTO;
import com.cinema.crvg.entities.Cinema;
import com.cinema.crvg.entities.Sala;
import com.cinema.crvg.repositories.CinemaRepository;
import com.cinema.crvg.repositories.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaService {

    private final SalaRepository salaRepository;
    private final CinemaRepository cinemaRepository;

    public SalaService(SalaRepository salaRepository, CinemaRepository cinemaRepository) {
        this.salaRepository = salaRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Transactional
    public SalaDTO salvar(SalaDTO dto) {
        Cinema cinema = cinemaRepository.findById(dto.getIdCinema())
                .orElseThrow(() -> new RuntimeException("Cinema não encontrado"));

        Sala sala = new Sala();
        sala.setNumero(dto.getNumero());
        sala.setCapacidade(dto.getCapacidade());
        sala.setCinema(cinema);
        Sala salaSalva = salaRepository.save(sala);
        return new SalaDTO(salaSalva);
    }

    public List<SalaDTO> listarTodos() {
        return salaRepository.findAll()
                .stream()
                .map(SalaDTO::new)
                .toList();
    }

    @Transactional
    public SalaDTO atualizar(Long id, SalaDTO salaDTO) {
        Sala existente = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        existente.setNumero(salaDTO.getNumero());
        existente.setCapacidade(salaDTO.getCapacidade());

        Cinema cinema = cinemaRepository.findById(salaDTO.getIdCinema())
                .orElseThrow(() -> new RuntimeException("Cinema não encontrado"));
        existente.setCinema(cinema);

        Sala atualizada = salaRepository.save(existente);
        return new SalaDTO(atualizada);
    }

    public SalaDTO buscarPorId(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        return new SalaDTO(sala);
    }

    @Transactional
    public void deletar(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        salaRepository.delete(sala);
    }

}
