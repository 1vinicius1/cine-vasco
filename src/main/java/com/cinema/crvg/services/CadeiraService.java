package com.cinema.crvg.services;

import com.cinema.crvg.dto.CadeiraDTO;
import com.cinema.crvg.dto.SalaDTO;
import com.cinema.crvg.entities.Cadeira;
import com.cinema.crvg.entities.Sala;
import com.cinema.crvg.repositories.CadeiraRepository;
import com.cinema.crvg.repositories.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadeiraService {

    private final CadeiraRepository cadeiraRepository;
    private final SalaRepository salaRepository;

    public CadeiraService(CadeiraRepository cadeiraRepository, SalaRepository salaRepository) {
        this.cadeiraRepository = cadeiraRepository;
        this.salaRepository = salaRepository;
    }

    @Transactional
    public CadeiraDTO salvar(CadeiraDTO dto) {
        Sala sala = salaRepository.findById(dto.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        Cadeira cadeira = new Cadeira();
        cadeira.setFila(dto.getFila());
        cadeira.setNumero(dto.getNumero());
        cadeira.setTipo(dto.getTipo());
        cadeira.setStatus(dto.isStatus());
        cadeira.setSala(sala);
        Cadeira cadeiraSalva = cadeiraRepository.save(cadeira);
        return new CadeiraDTO(cadeiraSalva);
    }

    public List<CadeiraDTO> listarTodos() {
        return cadeiraRepository.findAll()
                .stream()
                .map(CadeiraDTO::new)
                .toList();
    }

    @Transactional
    public CadeiraDTO atualizar(Long id, CadeiraDTO cadeiraDTO) {
        Cadeira existente = cadeiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadeira não encontrada"));
        existente.setFila(cadeiraDTO.getFila());
        existente.setNumero(cadeiraDTO.getNumero());
        existente.setTipo(cadeiraDTO.getTipo());
        existente.setStatus(cadeiraDTO.isStatus());

        Sala sala = salaRepository.findById(cadeiraDTO.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        existente.setSala(sala);

        Cadeira atualizada = cadeiraRepository.save(existente);
        return new CadeiraDTO(atualizada);
    }

    public CadeiraDTO buscarPorId(Long id) {
        Cadeira cadeira = cadeiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadeira não encontrada"));
        return new CadeiraDTO(cadeira);
    }

    @Transactional
    public void deletar(Long id) {
        Cadeira cadeira = cadeiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadeira não encontrada"));
        cadeiraRepository.delete(cadeira);
    }

}
