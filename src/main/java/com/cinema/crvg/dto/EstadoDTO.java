package com.cinema.crvg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO {

    private Long idEstado;

    @NotBlank
    @Size(min = 2, max = 2)
    private String sigla;

    @NotBlank
    @Size(max = 20)
    private String nome;
}
