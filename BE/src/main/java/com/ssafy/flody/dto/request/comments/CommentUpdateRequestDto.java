package com.ssafy.flody.dto.request.comments;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    private Long upper;
    private String comment;
    private Integer kids;

    @Builder
    public CommentUpdateRequestDto(Long upper, String comment, Integer kids
    ){
        this.upper = upper;
        this.comment = comment;
        this.kids = kids;
    }
}
