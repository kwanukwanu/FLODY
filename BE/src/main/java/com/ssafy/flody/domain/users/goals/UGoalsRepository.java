package com.ssafy.flody.domain.users.goals;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.schedules.USchedules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UGoalsRepository extends JpaRepository<UGoals, Long> {
    Optional<USchedules> findByUser(Users user);
}
