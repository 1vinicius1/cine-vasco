package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingresso")
@NoArgsConstructor
@AllArgsConstructor
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngresso;

    @OneToOne
    @JoinColumn(name = "id_cadeira", nullable = false, unique = true)
    private Cadeira cadeira;

    @Column(nullable = false)
    private Double valorPago;

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao", nullable = false)
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

    public void setIdIngresso(Long idIngresso) {
        this.idIngresso = idIngresso;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
}
