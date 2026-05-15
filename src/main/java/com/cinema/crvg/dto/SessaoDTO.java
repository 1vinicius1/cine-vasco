package com.cinema.crvg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessaoDTO {

    private Long idSessao;
    private LocalDateTime dataInicioExibicao;
    private LocalDateTime dataFimExibicao;
    private LocalDateTime horaDataSessao;
    private Double preco;
    private Long idFilme;
    private Long idSala;
}
