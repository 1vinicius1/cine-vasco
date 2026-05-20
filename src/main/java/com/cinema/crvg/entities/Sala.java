package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer capacidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cinema", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cadeira> cadeiras;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)
    private List<Sessao> sessoes;

    public Long getIdSala() {
        return idSala;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public List<Cadeira> getCadeiras() {
        return cadeiras;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setCadeiras(List<Cadeira> cadeiras) {
        this.cadeiras = cadeiras;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
}
