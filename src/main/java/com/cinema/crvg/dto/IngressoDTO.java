package com.cinema.crvg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngressoDTO {

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
}
