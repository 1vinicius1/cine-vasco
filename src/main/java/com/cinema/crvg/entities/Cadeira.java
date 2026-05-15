package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cadeira")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cadeira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCadeira;

    private char fila;
    private Integer numero;
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala sala;

    private boolean status;

    @OneToOne
    @JoinColumn(name = "ingresso_id", nullable = false, unique = true)
    private Ingresso ingresso;


}
