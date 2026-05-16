package com.cinema.crvg.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {

    private Long idSala;

    @NotNull
    @Positive
    private Integer numero;

    @NotNull
    @Positive
    private Integer capacidade;

    @NotNull
    private Long idCinema;
}
