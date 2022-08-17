package com.ssafy.flody.domain.groups.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GRolesRepository extends JpaRepository<GRoles, Long> {
    Optional<GRoles> findByName(String name);
}
