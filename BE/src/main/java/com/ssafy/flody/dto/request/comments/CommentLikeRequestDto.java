package com.ssafy.flody.dto.request.comments;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.comments.likes.CLikes;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentLikeRequestDto {
    public CLikes toEntity(Comments comment, Users user){
        return CLikes.builder()
                .comment(comment)
                .user(user)
                .build();
    }
}
