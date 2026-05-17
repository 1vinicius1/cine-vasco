package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstadoDTO {

    public EstadoDTO(Estado estado) {
        this.idEstado = estado.getIdEstado();
        this.sigla = estado.getSigla();
        this.nome = estado.getNome();
    }

    public EstadoDTO() {
    }

    private Long idEstado;

    @NotBlank
    @Size(min = 2, max = 2)
    private String sigla;

    @NotBlank
    @Size(max = 20)
    private String nome;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
