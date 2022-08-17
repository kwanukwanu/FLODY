package com.ssafy.flody.domain.groups;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
    List<Groups> findByNameContainingIgnoreCase(String name);
}
