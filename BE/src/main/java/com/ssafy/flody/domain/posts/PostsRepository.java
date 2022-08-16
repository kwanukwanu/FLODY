package com.ssafy.flody.domain.posts;

import com.ssafy.flody.domain.posts.categories.Categories;
import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findAllByCategory(Categories category);
    List<Posts> findAllByUser(Users users);
}
