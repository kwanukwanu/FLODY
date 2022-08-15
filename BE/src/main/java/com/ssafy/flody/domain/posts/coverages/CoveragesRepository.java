package com.ssafy.flody.domain.posts.coverages;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoveragesRepository extends JpaRepository<Coverages, Long> {
    Optional<Coverages> findByName(String name);
}
