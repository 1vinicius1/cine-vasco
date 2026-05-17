package com.cinema.crvg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cidade")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private List<Cinema> cinemas;

    public Long getIdCidade() {
        return idCidade;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
