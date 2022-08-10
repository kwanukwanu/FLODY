package com.ssafy.flody.domain.users.schedules;

import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface USchedulesRepository extends JpaRepository<USchedules, Long> {
    List<USchedules> findAllByUser(Users user);
}
