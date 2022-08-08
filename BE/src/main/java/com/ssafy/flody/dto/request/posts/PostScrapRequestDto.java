package com.ssafy.flody.dto.request.posts;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.scraps.Scraps;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostScrapRequestDto {
    public Scraps toEntity(Users user, Posts post){
        return Scraps.builder()
                .user(user)
                .post(post)
                .build();
    }
}
