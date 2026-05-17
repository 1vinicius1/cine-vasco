package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estado")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column(name = "sigla", length = 2)
    private String sigla;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Cidade> cidades;

    public Long getIdEstado() {
        return idEstado;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
}
