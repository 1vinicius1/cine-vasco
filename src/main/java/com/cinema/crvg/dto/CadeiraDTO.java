package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cadeira;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CadeiraDTO {

    public CadeiraDTO(Cadeira cadeira) {
        this.idCadeira = cadeira.getIdCadeira();
        this.idSala = cadeira.getSala().getIdSala();
        this.fila = cadeira.getFila();
        this.numero = cadeira.getNumero();
        this.tipo = cadeira.getTipo();
        this.status = cadeira.isStatus();
    }

    private Long idCadeira;

    @NotNull
    private Long idSala;

    private char fila;

    @NotNull
    @Positive
    private Integer numero;

    @NotBlank
    private String tipo;

    private boolean status;
}
