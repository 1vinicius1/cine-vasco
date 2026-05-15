package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "filme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    private String titulo;
    private String sinopse;
    private String duracao;
    private Integer faixaEtaria;
    private String genero;

    @OneToMany(mappedBy = "filme", fetch = FetchType.LAZY)
    private List<Sessao> sessoes;
}
