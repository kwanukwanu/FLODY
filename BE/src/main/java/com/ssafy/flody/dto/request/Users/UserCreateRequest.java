package com.ssafy.flody.dto.request.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//유저 회원가입
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    private String id;
    private String password;
    private String profile;
    private String nickname;
    private String address;
    private String phone;
    private String admin;
}