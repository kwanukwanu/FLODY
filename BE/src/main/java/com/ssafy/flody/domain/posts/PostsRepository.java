package com.ssafy.flody.domain.posts;

import com.ssafy.flody.domain.posts.categories.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findAllByCategory(Categories category);
}
