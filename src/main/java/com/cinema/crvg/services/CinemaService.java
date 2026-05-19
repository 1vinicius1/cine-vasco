package com.cinema.crvg.services;

import com.cinema.crvg.dto.CinemaDTO;
import com.cinema.crvg.entities.Cidade;
import com.cinema.crvg.entities.Cinema;
import com.cinema.crvg.entities.Recurso;
import com.cinema.crvg.repositories.CidadeRepository;
import com.cinema.crvg.repositories.CinemaRepository;
import com.cinema.crvg.repositories.RecursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CidadeRepository cidadeRepository;
    private final RecursoRepository recursoRepository;

    public CinemaService(CinemaRepository cinemaRepository, CidadeRepository cidadeRepository, RecursoRepository recursoRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cidadeRepository = cidadeRepository;
        this.recursoRepository = recursoRepository;
    }

    @Transactional
    public CinemaDTO salvar(CinemaDTO dto) {
        Cidade cidade = cidadeRepository.findById(dto.getIdCidade())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        Cinema cinema = new Cinema();
        cinema.setNome(dto.getNome());
        cinema.setEndereco(dto.getEndereco());
        cinema.setCidade(cidade);
        cinema.setFranquia(dto.getFranquia());

        if (dto.getIdRecursos() != null && !dto.getIdRecursos().isEmpty()) {
            for (Long idRecurso : dto.getIdRecursos()) {
                Recurso recurso = recursoRepository.findById(idRecurso)
                        .orElseThrow(() -> new RuntimeException("Recurso com ID " + idRecurso + " não encontrado"));
                cinema.getRecursos().add(recurso);
            }
        }

        Cinema cinemaSalvo = cinemaRepository.save(cinema);
        return new CinemaDTO(cinemaSalvo);
    }

    public List<CinemaDTO> listarTodos() {
        return cinemaRepository.findAll()
                .stream()
                .map(CinemaDTO::new)
                .toList();
    }

    @Transactional
    public CinemaDTO atualizar(Long id, CinemaDTO cinemaDTO) {
        Cinema existente = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema não encontrado"));
        existente.setNome(cinemaDTO.getNome());
        existente.setEndereco(cinemaDTO.getEndereco());
        existente.setFranquia(cinemaDTO.getFranquia());

        Cidade cidade = cidadeRepository.findById(cinemaDTO.getIdCidade())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        existente.setCidade(cidade);

        existente.getRecursos().clear();
        if (cinemaDTO.getIdRecursos() != null && !cinemaDTO.getIdRecursos().isEmpty()) {
            for (Long idRecurso : cinemaDTO.getIdRecursos()) {
                Recurso recurso = recursoRepository.findById(idRecurso)
                        .orElseThrow(() -> new RuntimeException("Recurso com ID " + idRecurso + " não encontrado"));
                existente.getRecursos().add(recurso);
            }
        }

        Cinema atualizado = cinemaRepository.save(existente);
        return new CinemaDTO(atualizado);
    }

    public CinemaDTO buscarPorId(Long id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema não encontrado"));
        return new CinemaDTO(cinema);
    }

    @Transactional
    public void deletar(Long id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema não encontrado"));
        cinemaRepository.delete(cinema);
    }
}
