package com.cinema.crvg.repositories;

import com.cinema.crvg.entities.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
