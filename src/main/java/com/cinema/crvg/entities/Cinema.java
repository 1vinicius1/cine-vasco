package com.cinema.crvg.entities;

import com.cinema.crvg.entities.enums.FranquiaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema")
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCinema;
    private String nome;
    private String endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @Enumerated(EnumType.STRING)
    private FranquiaEnum franquia;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> salas;

    @ManyToMany
    @JoinTable(name = "cinema_recurso", joinColumns = @JoinColumn(name = "id_cinema"),
            inverseJoinColumns = @JoinColumn(name = "id_recurso"))
    private List<Recurso> recursos = new ArrayList<>();

    public Long getIdCinema() {
        return idCinema;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public FranquiaEnum getFranquia() {
        return franquia;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setFranquia(FranquiaEnum franquia) {
        this.franquia = franquia;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
}
