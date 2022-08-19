package com.ssafy.flody.domain.licenses.serieses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesesRepository extends JpaRepository<Serieses, Long> {
    Optional<Serieses> findBySeriesnm(String seriesnm);
}
