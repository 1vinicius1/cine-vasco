package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Sessao;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

public class SessaoDTO {

    public SessaoDTO(Sessao sessao) {
        this.idSessao = sessao.getIdSessao();
        this.dataInicioExibicao = sessao.getDataInicioExibicao();
        this.dataFimExibicao = sessao.getDataFimExibicao();
        this.horaDataSessao = sessao.getHoraDataSessao();
        this.preco = sessao.getPreco();
        this.idFilme = sessao.getFilme().getIdFilme();
        this.idSala = sessao.getSala().getIdSala();
    }

    public SessaoDTO(){}

    private Long idSessao;

    @NotNull
    @FutureOrPresent
    private LocalDateTime dataInicioExibicao;

    @NotNull
    @FutureOrPresent
    private LocalDateTime dataFimExibicao;

    @NotNull
    @FutureOrPresent
    private LocalDateTime horaDataSessao;

    @NotNull
    @PositiveOrZero
    private Double preco;

    @NotNull
    private Long idFilme;

    @NotNull
    private Long idSala;

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public LocalDateTime getDataInicioExibicao() {
        return dataInicioExibicao;
    }

    public void setDataInicioExibicao(LocalDateTime dataInicioExibicao) {
        this.dataInicioExibicao = dataInicioExibicao;
    }

    public LocalDateTime getDataFimExibicao() {
        return dataFimExibicao;
    }

    public void setDataFimExibicao(LocalDateTime dataFimExibicao) {
        this.dataFimExibicao = dataFimExibicao;
    }

    public LocalDateTime getHoraDataSessao() {
        return horaDataSessao;
    }

    public void setHoraDataSessao(LocalDateTime horaDataSessao) {
        this.horaDataSessao = horaDataSessao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }
}
