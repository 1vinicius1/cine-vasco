package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Filme;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmeDTO {

    public FilmeDTO(Filme filme) {
        this.idFilme = filme.getIdFilme();
        this.titulo = filme.getTitulo();
        this.sinopse = filme.getSinopse();
        this.duracao = filme.getDuracao();
        this.faixaEtaria = filme.getFaixaEtaria();
        this.genero = filme.getGenero();
    }

    private Long idFilme;

    @NotBlank
    @Size(max = 50)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String sinopse;

    @NotBlank
    @Size(max = 15)
    private String duracao;

    @NotNull
    @PositiveOrZero
    private Integer faixaEtaria;

    @NotBlank
    @Size(max = 15)
    private String genero;
}
