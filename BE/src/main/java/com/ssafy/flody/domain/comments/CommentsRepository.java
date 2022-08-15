package com.ssafy.flody.domain.comments;

import com.ssafy.flody.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findAllByPostAndUpper(Posts post, Long upper);
    List<Comments> findAllByUpper(Long upper);
}
