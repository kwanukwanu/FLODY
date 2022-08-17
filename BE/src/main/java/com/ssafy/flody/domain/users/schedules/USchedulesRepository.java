package com.ssafy.flody.domain.users.schedules;

import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface USchedulesRepository extends JpaRepository<USchedules, Long> {
    Optional<USchedules> findByUser(Users user);
}
