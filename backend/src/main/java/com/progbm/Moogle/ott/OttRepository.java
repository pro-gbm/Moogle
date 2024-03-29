package com.progbm.Moogle.ott;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OttRepository extends JpaRepository<Ott, Long> {
    Optional<Ott> findByProviderId(Integer providerId);
}
