package com.ssafy.flody.domain.posts.likes;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PLikesRepository extends JpaRepository<PLikes, Long> {
    Optional<PLikes> findByUserAndPost(Users user, Posts posts);
    List<PLikes> findAllByUser(Users user);
}
