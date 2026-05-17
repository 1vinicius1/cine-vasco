package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Sala;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SalaDTO {

    public SalaDTO(Sala sala) {
        this.idSala = sala.getIdSala();
        this.numero = sala.getNumero();
        this.capacidade = sala.getCapacidade();
        this.idCinema = sala.getCinema().getIdCinema();
    }

    public SalaDTO(){}

    private Long idSala;

    @NotNull
    @Positive
    private Integer numero;

    @NotNull
    @Positive
    private Integer capacidade;

    @NotNull
    private Long idCinema;

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }
}
