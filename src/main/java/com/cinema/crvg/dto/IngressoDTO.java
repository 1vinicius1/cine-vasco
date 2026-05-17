package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Ingresso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngressoDTO {

    public IngressoDTO(Ingresso ingresso) {
        this.idIngresso = ingresso.getIdIngresso();
        this.valorPago = ingresso.getValorPago();
        this.status = ingresso.getStatus();
        this.idSessao = ingresso.getSessao().getIdSessao();
        this.idCadeira = ingresso.getCadeira().getIdCadeira();
    }

    private Long idIngresso;

    @NotNull
    @PositiveOrZero
    private Double valorPago;

    @NotBlank
    private String status;

    @NotNull
    private Long idSessao;

    @NotNull
    private Long idCadeira;
}
