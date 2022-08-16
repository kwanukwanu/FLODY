package com.ssafy.flody.domain.groups.goals;

import com.ssafy.flody.domain.groups.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GGoalsRepository extends JpaRepository<GGoals, Long> {
    List<GGoals> findAllByGroup(Groups groups);
}
