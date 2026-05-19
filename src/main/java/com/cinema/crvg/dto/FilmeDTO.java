package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Filme;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class FilmeDTO {

    public FilmeDTO(Filme filme) {
        this.idFilme = filme.getIdFilme();
        this.titulo = filme.getTitulo();
        this.sinopse = filme.getSinopse();
        this.duracao = filme.getDuracao();
        this.faixaEtaria = filme.getFaixaEtaria();
        this.genero = filme.getGenero();

        if (filme.getDiretores() != null) {
            filme.getDiretores().forEach(diretor -> this.idDiretores.add(diretor.getIdDiretor()));
        }
    }

    public FilmeDTO(){}

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

    private List<Long> idDiretores = new ArrayList<>();

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Integer getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(Integer faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Long> getIdDiretores() {
        return idDiretores;
    }

    public void setIdDiretores(List<Long> idDiretores) {
        this.idDiretores = idDiretores;
    }
}
