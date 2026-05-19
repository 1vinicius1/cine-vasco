package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cinema;
import com.cinema.crvg.entities.enums.FranquiaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class CinemaDTO {

    public CinemaDTO(Cinema cinema) {
        this.idCinema = cinema.getIdCinema();
        this.nome = cinema.getNome();
        this.endereco = cinema.getEndereco();
        this.idCidade = cinema.getCidade().getIdCidade();
        this.franquia = cinema.getFranquia();

        if (cinema.getRecursos() != null) {
            cinema.getRecursos().forEach(recurso -> this.idRecursos.add(recurso.getIdRecurso()));
        }
    }

    public CinemaDTO(){}

    private Long idCinema;

    @NotBlank
    @Size(max = 20)
    private String nome;

    @NotBlank
    @Size(max = 250)
    private String endereco;

    @NotNull
    private Long idCidade;

    @NotNull
    private FranquiaEnum franquia;

    private List<Long> idRecursos = new ArrayList<>();

    public Long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public FranquiaEnum getFranquia() {
        return franquia;
    }

    public void setFranquia(FranquiaEnum franquia) {
        this.franquia = franquia;
    }

    public List<Long> getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(List<Long> idRecursos) {
        this.idRecursos = idRecursos;
    }
}
