package com.ssafy.flody.dto.request.posts;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLikeRequestDto {
    public PLikes toEntity(Users user, Posts post){
        return PLikes.builder()
                .user(user)
                .post(post)
                .build();
    }
}
