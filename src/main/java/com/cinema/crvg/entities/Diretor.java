package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diretor")
@NoArgsConstructor
@AllArgsConstructor
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiretor;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToMany(mappedBy = "diretores")
    private List<Filme> filmes = new ArrayList<>();

    public Long getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(Long idDiretor) {
        this.idDiretor = idDiretor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
