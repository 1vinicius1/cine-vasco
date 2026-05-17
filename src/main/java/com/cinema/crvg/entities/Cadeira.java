package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cadeira")
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

    public void setIdCadeira(Long idCadeira) {
        this.idCadeira = idCadeira;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
