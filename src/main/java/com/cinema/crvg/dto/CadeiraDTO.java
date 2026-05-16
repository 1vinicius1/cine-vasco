package com.cinema.crvg.dto;

import jakarta.validation.constraints.NotBlank;
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
public class CadeiraDTO {

    private Long idCadeira;

    @NotNull
    private Long idSala;

    @NotNull
    private char fila;

    @NotNull
    @Positive
    private Integer numero;

    @NotBlank
    private String tipo;

    private boolean status;
}
