package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Cidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CidadeDTO {

    public CidadeDTO(Cidade cidade) {
        this.idCidade = cidade.getIdCidade();
        this.nome = cidade.getNome();
        this.idEstado = cidade.getEstado().getIdEstado();
    }

    private Long idCidade;

    @NotBlank
    private String nome;

    @NotNull
    private Long idEstado;
}
