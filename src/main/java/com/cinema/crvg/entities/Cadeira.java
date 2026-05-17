package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cadeira")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cadeira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCadeira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala sala;

    private char fila;
    private Integer numero;
    private String tipo;
    private boolean status;

    public Long getIdCadeira() {
        return idCadeira;
    }

    public Sala getSala() {
        return sala;
    }

    public char getFila() {
        return fila;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isStatus() {
        return status;
    }
}
