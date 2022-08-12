package com.ssafy.flody.domain.groups.members;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GMembersRepository extends JpaRepository<GMembers, Long> {
    List<GMembers> findAllByGroup(Groups group);
    Optional<GMembers> findByUserAndGroup(Users user, Groups group);
}
