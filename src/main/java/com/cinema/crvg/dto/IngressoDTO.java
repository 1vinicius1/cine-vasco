package com.cinema.crvg.dto;

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
    private Double valorPago;
    private String status;
    private Long idSessao;
    private Long idCadeira;
}
