package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Recurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RecursoDTO {

    public RecursoDTO(Recurso recurso) {
        this.idRecurso = idRecurso;
        this.nome = nome;
    }

    public RecursoDTO(){}

    private Long idRecurso;

    @NotBlank
    @Size(max = 50)
    private String nome;

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
