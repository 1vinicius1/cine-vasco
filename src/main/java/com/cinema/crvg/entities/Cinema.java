package com.cinema.crvg.entities;

import com.cinema.crvg.entities.enums.FranquiaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cinema")
@Getter
@Setter
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

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
    private List<Sala> salas;
}
