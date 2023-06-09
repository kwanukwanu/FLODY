package com.ssafy.flody.domain.users.follows;

import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowsRepository extends JpaRepository<Follows, Long> {
    Optional<Follows> findByFollower(Users follower);
}
