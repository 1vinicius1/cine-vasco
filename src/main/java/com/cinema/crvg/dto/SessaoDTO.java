package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Sessao;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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
}
