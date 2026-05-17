package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingresso")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngresso;

    @OneToOne
    @JoinColumn(name = "id_cadeira", nullable = false, unique = true)
    private Cadeira cadeira;

    private Double valorPago;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao")
    private Sessao sessao;

    public Long getIdIngresso() {
        return idIngresso;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public String getStatus() {
        return status;
    }

    public Sessao getSessao() {
        return sessao;
    }
}
