package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CidadeDTO {

    public CidadeDTO(Cidade cidade) {
        this.idCidade = cidade.getIdCidade();
        this.nome = cidade.getNome();
        this.idEstado = cidade.getEstado().getIdEstado();
    }

    public CidadeDTO(){}

    private Long idCidade;

    @NotBlank
    private String nome;

    @NotNull
    private Long idEstado;

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
