package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filme")
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String sinopse;

    @Column(nullable = false, length = 15)
    private String duracao;

    @Column(nullable = false)
    private Integer faixaEtaria;

    @Column(nullable = false, length = 15)
    private String genero;

    @OneToMany(mappedBy = "filme", fetch = FetchType.LAZY)
    private List<Sessao> sessoes;

    @ManyToMany
    @JoinTable(name = "filme_diretor", joinColumns = @JoinColumn(name = "id_filme", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_diretor", nullable = false))
    private List<Diretor> diretores = new ArrayList<>();

    public Long getIdFilme() {
        return idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getDuracao() {
        return duracao;
    }

    public Integer getFaixaEtaria() {
        return faixaEtaria;
    }

    public String getGenero() {
        return genero;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setFaixaEtaria(Integer faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }
}
