package com.cinema.crvg.repositories;

import com.cinema.crvg.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
