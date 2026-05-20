package com.cinema.crvg.services;

import com.cinema.crvg.dto.CidadeDTO;
import com.cinema.crvg.entities.Cidade;
import com.cinema.crvg.entities.Estado;
import com.cinema.crvg.repositories.CidadeRepository;
import com.cinema.crvg.repositories.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public CidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    @Transactional
    public CidadeDTO salvar(CidadeDTO dto) {
        Estado estado = estadoRepository.findById(dto.getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        Cidade cidade = new Cidade();
        cidade.setNome(dto.getNome());
        cidade.setEstado(estado);
        Cidade cidadeSalva = cidadeRepository.save(cidade);
        return new CidadeDTO(cidadeSalva);
    }

    public List<CidadeDTO> listarTodas() {
        return cidadeRepository.findAll()
                .stream()
                .map(CidadeDTO::new)
                .toList();
    }

    @Transactional
    public CidadeDTO atualizar(Long id, CidadeDTO cidadeDTO) {
        Cidade existente = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        existente.setNome(cidadeDTO.getNome());

        Estado estado = estadoRepository.findById(cidadeDTO.getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
        existente.setEstado(estado);

        Cidade atualizada = cidadeRepository.save(existente);
        return new CidadeDTO(atualizada);
    }

    public CidadeDTO buscarPorId(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        return new CidadeDTO(cidade);
    }

    @Transactional
    public void deletar(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        cidadeRepository.delete(cidade);
    }
}
