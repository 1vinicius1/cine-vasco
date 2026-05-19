package com.cinema.crvg.services;

import com.cinema.crvg.dto.IngressoDTO;
import com.cinema.crvg.entities.Cadeira;
import com.cinema.crvg.entities.Ingresso;
import com.cinema.crvg.entities.Sessao;
import com.cinema.crvg.repositories.CadeiraRepository;
import com.cinema.crvg.repositories.IngressoRepository;
import com.cinema.crvg.repositories.SessaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngressoService {

    private final IngressoRepository ingressoRepository;
    private final SessaoRepository sessaoRepository;
    private final CadeiraRepository cadeiraRepository;

    public IngressoService(IngressoRepository ingressoRepository, SessaoRepository sessaoRepository, CadeiraRepository cadeiraRepository) {
        this.ingressoRepository = ingressoRepository;
        this.sessaoRepository = sessaoRepository;
        this.cadeiraRepository = cadeiraRepository;
    }

    @Transactional
    public IngressoDTO salvar(IngressoDTO dto) {
        Sessao sessao = sessaoRepository.findById(dto.getIdSessao())
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        Cadeira cadeira = cadeiraRepository.findById(dto.getIdCadeira())
                .orElseThrow(() -> new RuntimeException("Cadeira não encontrada"));

        Ingresso ingresso = new Ingresso();
        ingresso.setValorPago(dto.getValorPago());
        ingresso.setStatus(dto.getStatus());
        ingresso.setSessao(sessao);
        ingresso.setCadeira(cadeira);
        Ingresso ingressoSalvo = ingressoRepository.save(ingresso);
        return new IngressoDTO(ingressoSalvo);
    }

    public List<IngressoDTO> listarTodos() {
        return ingressoRepository.findAll()
                .stream()
                .map(IngressoDTO::new)
                .toList();
    }

    @Transactional
    public IngressoDTO atualizar(Long id, IngressoDTO ingressoDTO) {
        Ingresso existente = ingressoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingresso não encontrado"));
        existente.setValorPago(ingressoDTO.getValorPago());
        existente.setStatus(ingressoDTO.getStatus());

        Sessao sessao = sessaoRepository.findById(ingressoDTO.getIdSessao())
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        Cadeira cadeira = cadeiraRepository.findById(ingressoDTO.getIdCadeira())
                .orElseThrow(() -> new RuntimeException("Cadeira não encontrada"));
        existente.setSessao(sessao);
        existente.setCadeira(cadeira);

        Ingresso atualizado = ingressoRepository.save(existente);
        return new IngressoDTO(atualizado);
    }

    public IngressoDTO buscarPorId(Long id) {
        Ingresso ingresso = ingressoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingresso não encontrado"));
        return new IngressoDTO(ingresso);
    }

    @Transactional
    public void deletar(Long id) {
        Ingresso ingresso = ingressoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingresso não encontrado"));
        ingressoRepository.delete(ingresso);
    }
}
