package com.cinema.crvg.services;

import com.cinema.crvg.dto.EstadoDTO;
import com.cinema.crvg.entities.Estado;
import com.cinema.crvg.repositories.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Transactional
    public EstadoDTO salvar(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());
        estado = estadoRepository.save(estado);
        return new EstadoDTO(estado);
    }

    public EstadoDTO buscarPorId(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
        return new EstadoDTO(estado);
    }

    public List<EstadoDTO> listarTodos() {
        return estadoRepository.findAll()
                .stream()
                .map(EstadoDTO::new)
                .toList();
    }

    @Transactional
    public EstadoDTO atualizar(Long id, EstadoDTO dto) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());
        estado = estadoRepository.save(estado);
        return new EstadoDTO(estado);
    }

    @Transactional
    public void deletar(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
        estadoRepository.delete(estado);
    }
}
