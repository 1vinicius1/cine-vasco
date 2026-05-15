package com.cinema.crvg.dto;

import com.cinema.crvg.entities.enums.FranquiaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {

    private Long idCinema;
    private String nome;
    private String endereco;
    private Long idCidade;
    private FranquiaEnum franquia;
}
