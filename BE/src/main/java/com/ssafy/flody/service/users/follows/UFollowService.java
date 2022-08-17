package com.ssafy.flody.service.users.follows;

import com.ssafy.flody.dto.response.users.UserFollowResponseDto;

import java.util.List;

public interface UFollowService {
    public List<UserFollowResponseDto> findUserFollows(String email) throws Exception;
    public Long addUserFollow(String followerEmail, String followingEmail) throws Exception;
    public Long removeUserFollow(Long folNo);
}
