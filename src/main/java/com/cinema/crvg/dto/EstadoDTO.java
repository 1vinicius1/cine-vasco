package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstadoDTO {

    public EstadoDTO(Estado estado) {
        this.idEstado = estado.getIdEstado();
        this.sigla = estado.getSigla();
        this.nome = estado.getNome();
    }

    private Long idEstado;

    @NotBlank
    @Size(min = 2, max = 2)
    private String sigla;

    @NotBlank
    @Size(max = 20)
    private String nome;
}
