package com.cinema.crvg.repositories;

import com.cinema.crvg.entities.Cadeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadeiraRepository extends JpaRepository<Cadeira, Long> {
}
