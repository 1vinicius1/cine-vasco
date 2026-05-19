package com.cinema.crvg.services;

import com.cinema.crvg.dto.FilmeDTO;
import com.cinema.crvg.entities.Filme;
import com.cinema.crvg.repositories.FilmeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public FilmeDTO salvar(FilmeDTO dto) {
        Filme filme = new Filme();

        filme.setTitulo(dto.getTitulo());
        filme.setSinopse(dto.getSinopse());
        filme.setDuracao(dto.getDuracao());
        filme.setFaixaEtaria(dto.getFaixaEtaria());
        filme.setGenero(dto.getGenero());
        Filme filmeSavo = filmeRepository.save(filme);
        return new FilmeDTO(filmeSavo);
    }

    public List<FilmeDTO> listarTodos() {
        return filmeRepository.findAll()
                .stream()
                .map(FilmeDTO::new)
                .toList();
    }

    @Transactional
    public FilmeDTO atualizar(Long id, FilmeDTO filmeDTO) {
        Filme existente = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        existente.setTitulo(filmeDTO.getTitulo());
        existente.setSinopse(filmeDTO.getSinopse());
        existente.setDuracao(filmeDTO.getDuracao());
        existente.setFaixaEtaria(filmeDTO.getFaixaEtaria());
        existente.setGenero(filmeDTO.getGenero());

        Filme atualizado = filmeRepository.save(existente);
        return new FilmeDTO(atualizado);
    }

    public FilmeDTO buscarPorId(Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        return new FilmeDTO(filme);
    }

    @Transactional
    public void deletar(Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filmeRepository.delete(filme);
    }
}
