package com.cinema.crvg.services;

import com.cinema.crvg.dto.FilmeDTO;
import com.cinema.crvg.entities.Diretor;
import com.cinema.crvg.entities.Filme;
import com.cinema.crvg.repositories.DiretorRepository;
import com.cinema.crvg.repositories.FilmeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final DiretorRepository diretorRepository;

    public FilmeService(FilmeRepository filmeRepository, DiretorRepository diretorRepository) {
        this.filmeRepository = filmeRepository;
        this.diretorRepository = diretorRepository;
    }

    @Transactional
    public FilmeDTO salvar(FilmeDTO dto) {
        Filme filme = new Filme();

        filme.setTitulo(dto.getTitulo());
        filme.setSinopse(dto.getSinopse());
        filme.setDuracao(dto.getDuracao());
        filme.setFaixaEtaria(dto.getFaixaEtaria());
        filme.setGenero(dto.getGenero());

        if (dto.getIdDiretores() != null && !dto.getIdDiretores().isEmpty()) {
            for (Long idDiretor : dto.getIdDiretores()) {
                Diretor diretor = diretorRepository.findById(idDiretor)
                        .orElseThrow(() -> new RuntimeException("Diretor com ID " + idDiretor + " não encontrado"));
                filme.getDiretores().add(diretor);
            }
        }

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

        existente.getDiretores().clear();
        if (filmeDTO.getIdDiretores() != null && !filmeDTO.getIdDiretores().isEmpty()) {
            for (Long idDiretor : filmeDTO.getIdDiretores()) {
                Diretor diretor = diretorRepository.findById(idDiretor)
                        .orElseThrow(() -> new RuntimeException("Diretor com ID " + idDiretor + " não encontrado"));
                existente.getDiretores().add(diretor);
            }
        }

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
