package com.ssafy.flody.domain.posts.scraps;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.posts.reports.PReports;
import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapsRepository extends JpaRepository<Scraps, Long> {
    Optional<Scraps> findByUserAndPost(Users user, Posts posts);
    List<Scraps> findAllByUser(Users user);
}
