package com.ssafy.flody.domain.groups;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
    List<Groups> findByNameContainingIgnoreCaseOrderByGroNoDesc(String name, Pageable pageable);
}
