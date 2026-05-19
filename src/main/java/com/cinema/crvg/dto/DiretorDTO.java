package com.cinema.crvg.dto;

import com.cinema.crvg.entities.Diretor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DiretorDTO {

    public DiretorDTO(Diretor diretor) {
        this.idDiretor = idDiretor;
        this.nome = nome;
    }

    public DiretorDTO(){}

    private Long idDiretor;

    @NotBlank
    @Size(max = 100)
    private String nome;

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
}
