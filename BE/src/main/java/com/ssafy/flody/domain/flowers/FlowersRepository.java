package com.ssafy.flody.domain.flowers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlowersRepository extends JpaRepository<Flowers, Long> {
    Optional<Flowers> findByName(String name);
}
