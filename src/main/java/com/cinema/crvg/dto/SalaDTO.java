package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Sala;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SalaDTO {

    public SalaDTO(Sala sala) {
        this.idSala = sala.getIdSala();
        this.numero = sala.getNumero();
        this.capacidade = sala.getCapacidade();
        this.idCinema = sala.getCinema().getIdCinema();
    }

    private Long idSala;

    @NotNull
    @Positive
    private Integer numero;

    @NotNull
    @Positive
    private Integer capacidade;

    @NotNull
    private Long idCinema;
}
