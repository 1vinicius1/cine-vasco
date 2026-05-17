package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sala")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;

    private Integer numero;
    private Integer capacidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cinema")
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
}
