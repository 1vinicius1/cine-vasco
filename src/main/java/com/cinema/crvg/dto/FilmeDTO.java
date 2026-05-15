package com.cinema.crvg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {

    private Long idFilme;
    private String titulo;
    private String sinopse;
    private String duracao;
    private Integer faixaEtaria;
    private String genero;
}
