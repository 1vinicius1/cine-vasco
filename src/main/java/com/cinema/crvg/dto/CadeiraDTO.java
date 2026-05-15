package com.cinema.crvg.dto;

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
    private Long idSala;
    private char fila;
    private Integer numero;
    private String tipo;
    private boolean status;
}
