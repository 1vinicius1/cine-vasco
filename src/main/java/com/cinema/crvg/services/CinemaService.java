package com.cinema.crvg.services;

import com.cinema.crvg.dto.CinemaDTO;
import com.cinema.crvg.entities.Cidade;
import com.cinema.crvg.entities.Cinema;
import com.cinema.crvg.repositories.CidadeRepository;
import com.cinema.crvg.repositories.CinemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CidadeRepository cidadeRepository;

    public CinemaService(CinemaRepository cinemaRepository, CidadeRepository cidadeRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cidadeRepository = cidadeRepository;
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
