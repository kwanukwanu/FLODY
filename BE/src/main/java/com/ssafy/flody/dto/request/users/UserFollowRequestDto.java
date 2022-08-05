package com.ssafy.flody.dto.request.users;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.follows.Follows;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserFollowRequestDto {
    public Follows toEntity(Users follower, Users following){
        return Follows.builder()
                .follower(follower)
                .following(following)
                .build();
    }

}
