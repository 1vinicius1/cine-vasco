package com.cinema.crvg.services;

import com.cinema.crvg.dto.RecursoDTO;
import com.cinema.crvg.entities.Recurso;
import com.cinema.crvg.repositories.RecursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Transactional
    public RecursoDTO salvar(RecursoDTO dto) {
        Recurso recurso = new Recurso();
        recurso.setNome(dto.getNome());
        Recurso recursoSalvo = recursoRepository.save(recurso);
        return new RecursoDTO(recursoSalvo);
    }

    public List<RecursoDTO> listarTodos() {
        return recursoRepository.findAll()
                .stream()
                .map(RecursoDTO::new)
                .toList();
    }

    @Transactional
    public RecursoDTO atualizar(Long id, RecursoDTO recursoDTO) {
        Recurso existente = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        existente.setNome(recursoDTO.getNome());

        Recurso atualizado = recursoRepository.save(existente);
        return new RecursoDTO(atualizado);
    }

    public RecursoDTO buscarPorId(Long id) {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        return new RecursoDTO(recurso);
    }

    @Transactional
    public void deletar(Long id) {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        recursoRepository.delete(recurso);
    }
}
