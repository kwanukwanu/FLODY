package com.ssafy.flody.dto.request.dmessages;

import com.ssafy.flody.domain.dmessages.DirectMessages;
import com.ssafy.flody.domain.dmessages.likes.DLikes;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DMessagesLikeRequestDto {
    public DLikes toEntity(DirectMessages directMessage, Users user){
        return DLikes.builder()
                .directMessage(directMessage)
                .user(user)
                .build();
    }

}
