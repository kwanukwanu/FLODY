package com.ssafy.flody.dto.request.comments;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentCreateRequestDto {
    private Long upper;
    private String content;
    private int kids = 0;

    @Builder
    public CommentCreateRequestDto(Long upper, String content, int kids){
        this.upper = upper;
        this.content = content;
    }

    //dto to entity
    public Comments toEntity(Users user, Posts post){
        return Comments.builder()
                .user(user)
                .post(post)
                .upper(upper)
                .content(content)
                .kids(kids)
                .build();
    }
}
