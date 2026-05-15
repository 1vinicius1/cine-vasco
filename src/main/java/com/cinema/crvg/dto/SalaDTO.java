package com.cinema.crvg.dto;

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
    private Integer numero;
    private Integer capacidade;
    private Long idCinema;
}
