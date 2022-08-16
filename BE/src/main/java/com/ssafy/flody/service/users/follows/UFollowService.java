package com.ssafy.flody.service.users.follows;

import com.ssafy.flody.dto.response.users.UserFollowResponseDto;

import java.util.List;

public interface UFollowService {
    public List<UserFollowResponseDto> findUserFollowings(String email) throws Exception;
    public Long addUserFollow(String followerEmail, String followingEmail) throws Exception;
    public String removeUserFollow(String email);
}
