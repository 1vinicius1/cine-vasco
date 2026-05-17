package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sessao")
@Setter
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
}
