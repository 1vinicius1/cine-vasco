package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sessao")
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSessao;

    private LocalDateTime dataInicioExibicao;
    private LocalDateTime dataFimExibicao;
    private LocalDateTime horaDataSessao;
    private Double preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_filme")
    private Filme filme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @OneToMany(mappedBy = "sessao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    public Long getIdSessao() {
        return idSessao;
    }

    public LocalDateTime getDataInicioExibicao() {
        return dataInicioExibicao;
    }

    public LocalDateTime getDataFimExibicao() {
        return dataFimExibicao;
    }

    public LocalDateTime getHoraDataSessao() {
        return horaDataSessao;
    }

    public Double getPreco() {
        return preco;
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public void setDataInicioExibicao(LocalDateTime dataInicioExibicao) {
        this.dataInicioExibicao = dataInicioExibicao;
    }

    public void setDataFimExibicao(LocalDateTime dataFimExibicao) {
        this.dataFimExibicao = dataFimExibicao;
    }

    public void setHoraDataSessao(LocalDateTime horaDataSessao) {
        this.horaDataSessao = horaDataSessao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}
