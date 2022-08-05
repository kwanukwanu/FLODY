package com.ssafy.flody.service.users;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.dto.request.Users.UserCreateRequestDto;
import com.ssafy.flody.dto.request.Users.UserLoginRequestDto;
import com.ssafy.flody.dto.request.Users.UserPasswordUpdateRequestDto;
import com.ssafy.flody.dto.request.Users.UserUpdateRequestDto;
import com.ssafy.flody.dto.response.Users.UserInfoResponseDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsersService {
    public List<UserInfoResponseDto> findUsers();

    UserInfoResponseDto findUser(Long id);

    public Long addUser(UserCreateRequestDto requestDto);

    public Boolean findUserEmail(String email);
    UserDetails loadUserByUserid(String id) throws UsernameNotFoundException;

    public String loginUser(UserLoginRequestDto requestDto);

    Users modifyUser(String token, UserUpdateRequestDto requestDto) throws Exception;

    Users modifyUserPassword(String token, UserPasswordUpdateRequestDto requestDto) throws Exception;

    public String removeUser(String token) throws Exception;
}
