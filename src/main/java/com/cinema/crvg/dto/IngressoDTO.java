package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Ingresso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class IngressoDTO {

    public IngressoDTO(Ingresso ingresso) {
        this.idIngresso = ingresso.getIdIngresso();
        this.valorPago = ingresso.getValorPago();
        this.status = ingresso.getStatus();
        this.idSessao = ingresso.getSessao().getIdSessao();
        this.idCadeira = ingresso.getCadeira().getIdCadeira();
    }

    public IngressoDTO(){}

    private Long idIngresso;

    @NotNull
    @PositiveOrZero
    private Double valorPago;

    @NotBlank
    private String status;

    @NotNull
    private Long idSessao;

    @NotNull
    private Long idCadeira;

    public Long getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(Long idIngresso) {
        this.idIngresso = idIngresso;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public Long getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(Long idCadeira) {
        this.idCadeira = idCadeira;
    }
}
