package com.cinema.crvg.services;

import com.cinema.crvg.dto.DiretorDTO;
import com.cinema.crvg.entities.Diretor;
import com.cinema.crvg.repositories.DiretorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {

    private final DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    @Transactional
    public DiretorDTO salvar(DiretorDTO dto) {

        Diretor diretor = new Diretor();
        diretor.setNome(dto.getNome());
        Diretor diretorSalvo = diretorRepository.save(diretor);
        return new DiretorDTO(diretorSalvo);
    }

    public List<DiretorDTO> listarTodos() {
        return diretorRepository.findAll()
                .stream()
                .map(DiretorDTO::new)
                .toList();
    }

    @Transactional
    public DiretorDTO atualizar(Long id, DiretorDTO diretorDTO) {
        Diretor existente = diretorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diretor não encontrado"));
        existente.setNome(diretorDTO.getNome());

        Diretor atualizado = diretorRepository.save(existente);
        return new DiretorDTO(atualizado);
    }

    public DiretorDTO buscarPorId(Long id) {
        Diretor diretor = diretorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diretor não encontrado"));
        return new DiretorDTO(diretor);
    }

    @Transactional
    public void deletar(Long id) {
        Diretor diretor = diretorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diretor não encontrado"));
        diretorRepository.delete(diretor);
    }
}
