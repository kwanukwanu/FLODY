package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.follows.Follows;
import lombok.Getter;

@Getter
public class UserFollowResponseDto {
    private String following;

    public UserFollowResponseDto(Follows follow) {
        this.following = follow.getFollowing().getEmail();
    }
}
