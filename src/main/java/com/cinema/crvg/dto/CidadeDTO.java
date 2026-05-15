package com.cinema.crvg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {

    private Long idCidade;
    private String nome;
    private Long idEstado;
}
