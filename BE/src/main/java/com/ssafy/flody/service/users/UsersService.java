package com.ssafy.flody.service.users;

import com.ssafy.flody.dto.request.Users.UserCreateRequestDto;
import com.ssafy.flody.dto.response.Users.UserInfoResponseDto;

import java.util.List;

public interface UsersService {
    public List<UserInfoResponseDto> findUsers(String keyword);

    public Long addUser(UserCreateRequestDto requestDto);
}
