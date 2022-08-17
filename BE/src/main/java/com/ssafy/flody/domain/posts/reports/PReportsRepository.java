package com.ssafy.flody.domain.posts.reports;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PReportsRepository extends JpaRepository<PReports, Long> {
    Optional<PReports> findByUserAndPost(Users user, Posts posts);
}
