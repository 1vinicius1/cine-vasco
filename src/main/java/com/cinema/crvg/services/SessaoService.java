package com.cinema.crvg.services;

import com.cinema.crvg.dto.SessaoDTO;
import com.cinema.crvg.entities.Filme;
import com.cinema.crvg.entities.Sala;
import com.cinema.crvg.entities.Sessao;
import com.cinema.crvg.repositories.FilmeRepository;
import com.cinema.crvg.repositories.SalaRepository;
import com.cinema.crvg.repositories.SessaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final SalaRepository salaRepository;
    private final FilmeRepository filmeRepository;

    public SessaoService(SessaoRepository sessaoRepository, SalaRepository salaRepository, FilmeRepository filmeRepository) {
        this.sessaoRepository = sessaoRepository;
        this.salaRepository = salaRepository;
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public SessaoDTO salvar(SessaoDTO dto) {
        Sala sala = salaRepository.findById(dto.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        Filme filme = filmeRepository.findById(dto.getIdFilme())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        Sessao sessao = new Sessao();
        sessao.setDataInicioExibicao(dto.getDataInicioExibicao());
        sessao.setDataFimExibicao(dto.getDataFimExibicao());
        sessao.setHoraDataSessao(dto.getHoraDataSessao());
        sessao.setPreco(dto.getPreco());
        sessao.setSala(sala);
        sessao.setFilme(filme);
        Sessao sessaoSalva = sessaoRepository.save(sessao);
        return new SessaoDTO(sessaoSalva);
    }

    public List<SessaoDTO> listarTodas() {
        return sessaoRepository.findAll()
                .stream()
                .map(SessaoDTO::new)
                .toList();
    }

    @Transactional
    public SessaoDTO atualizar(Long id, SessaoDTO sessaoDTO) {
        Sessao existente = sessaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        existente.setDataInicioExibicao(sessaoDTO.getDataInicioExibicao());
        existente.setDataFimExibicao(sessaoDTO.getDataFimExibicao());
        existente.setHoraDataSessao(sessaoDTO.getHoraDataSessao());
        existente.setPreco(sessaoDTO.getPreco());

        Sala sala = salaRepository.findById(sessaoDTO.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        Filme filme = filmeRepository.findById(sessaoDTO.getIdFilme())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        existente.setSala(sala);
        existente.setFilme(filme);

        Sessao atualizada = sessaoRepository.save(existente);
        return new SessaoDTO(atualizada);
    }

    public SessaoDTO buscarPorId(Long id) {
        Sessao sessao = sessaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        return new SessaoDTO(sessao);
    }

    @Transactional
    public void deletar(Long id) {
        Sessao sessao = sessaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        sessaoRepository.delete(sessao);
    }
}
