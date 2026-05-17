package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cinema;
import com.cinema.crvg.entities.enums.FranquiaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CinemaDTO {

    public CinemaDTO(Cinema cinema) {
        this.idCinema = cinema.getIdCinema();
        this.nome = cinema.getNome();
        this.endereco = cinema.getEndereco();
        this.idCidade = cinema.getCidade().getIdCidade();
        this.franquia = cinema.getFranquia();
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
}
