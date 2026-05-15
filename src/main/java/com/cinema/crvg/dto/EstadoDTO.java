package com.cinema.crvg.dto;

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
    private String sigla;
    private String nome;
}
