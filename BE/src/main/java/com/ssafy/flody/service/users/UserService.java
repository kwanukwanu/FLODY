package com.ssafy.flody.service.users;

import com.ssafy.flody.dto.request.users.UserCreateRequestDto;
import com.ssafy.flody.dto.request.users.UserLoginRequestDto;
import com.ssafy.flody.dto.request.users.UserPasswordUpdateRequestDto;
import com.ssafy.flody.dto.request.users.UserUpdateRequestDto;
import com.ssafy.flody.dto.response.posts.PostLikeListResponseDto;
import com.ssafy.flody.dto.response.posts.ScrapListResponseDto;
import com.ssafy.flody.dto.response.users.UserInfoResponseDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    UserDetails findUserForToken(String id) throws UsernameNotFoundException;

    public List<UserInfoResponseDto> findUsers();

    UserInfoResponseDto findUserById(String email);

    public Boolean validateEmail(String email);
    public String addUser(UserCreateRequestDto requestDto);

    String modifyUser(String email, UserUpdateRequestDto requestDto) throws Exception;

    String modifyUserPassword(String email, UserPasswordUpdateRequestDto requestDto) throws Exception;

    public String removeUser(String email) throws Exception;

    public String loginUser(UserLoginRequestDto requestDto);

    public List<PostLikeListResponseDto> findPostLikes(String email);

    public List<ScrapListResponseDto> findPostScraps(String email);
}
