package com.ssafy.flody.domain.groups.schedules;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.schedules.USchedules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GSchedulesRepository extends JpaRepository<GSchedules, Long> {
    List<GSchedules> findAllByGroup(Groups group);
    List<GSchedules> findAllByGroupAndStartDateBeforeAndEndDateAfter(Groups group, Date from, Date upto);

}
