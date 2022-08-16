package com.ssafy.flody.domain.users.follows;

import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowsRepository extends JpaRepository<Follows, Long> {
    List<Follows> findAllByFollower(Users follower);
    Optional<Follows> findByFollowing(Users following);
}
