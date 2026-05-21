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

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 250)
    private String endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private FranquiaEnum franquia;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> salas;

    @ManyToMany
    @JoinTable(name = "cinema_recurso", joinColumns = @JoinColumn(name = "id_cinema", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_recurso", nullable = false))
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
