package com.cinema.crvg.dto;

import com.cinema.crvg.entities.enums.FranquiaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
