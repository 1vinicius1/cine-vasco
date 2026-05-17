package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cinema;
import com.cinema.crvg.entities.enums.FranquiaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CinemaDTO {

    public CinemaDTO(Cinema cinema) {
        this.idCinema = cinema.getIdCinema();
        this.nome = cinema.getNome();
        this.endereco = cinema.getEndereco();
        this.idCidade = cinema.getCidade().getIdCidade();
        this.franquia = cinema.getFranquia();
    }

    private Long idCinema;

    @NotBlank
    @Size(max = 20)
    private String nome;

    @NotBlank
    @Size(max = 250)
    private String endereco;

    @NotNull
    private Long idCidade;

    @NotNull
    private FranquiaEnum franquia;
}
