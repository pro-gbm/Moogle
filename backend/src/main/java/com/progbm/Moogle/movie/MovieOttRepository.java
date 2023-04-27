package com.progbm.Moogle.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieOttRepository extends JpaRepository<MovieOtt, Long> {
}
