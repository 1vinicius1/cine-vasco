package com.cinema.crvg.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessaoDTO {

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
