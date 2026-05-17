package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cadeira;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CadeiraDTO {

    public CadeiraDTO(Cadeira cadeira) {
        this.idCadeira = cadeira.getIdCadeira();
        this.idSala = cadeira.getSala().getIdSala();
        this.fila = cadeira.getFila();
        this.numero = cadeira.getNumero();
        this.tipo = cadeira.getTipo();
        this.status = cadeira.isStatus();
    }

    public CadeiraDTO(){}

    private Long idCadeira;

    @NotNull
    private Long idSala;

    private char fila;

    @NotNull
    @Positive
    private Integer numero;

    @NotBlank
    private String tipo;

    private boolean status;

    public Long getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(Long idCadeira) {
        this.idCadeira = idCadeira;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
