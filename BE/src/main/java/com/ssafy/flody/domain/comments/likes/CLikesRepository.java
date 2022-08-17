package com.ssafy.flody.domain.comments.likes;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CLikesRepository extends JpaRepository<CLikes, Long> {
    Optional<CLikes> findByUserAndComment(Users user, Comments comments);
    List<CLikes> findAllByUser(Users user);
}
