package com.ssafy.flody.domain.users.goals;

import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UGoalsRepository extends JpaRepository<UGoals, Long> {
    List<UGoals> findAllByUser(Users user);
}
