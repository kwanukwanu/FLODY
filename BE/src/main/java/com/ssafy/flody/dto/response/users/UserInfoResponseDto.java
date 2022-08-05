package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.Users;
import lombok.Getter;

@Getter
public class UserInfoResponseDto {
    private String email;
    private String password;
    private String profile;
    private String name;
    private String nickname;
    private String address;
    private String phone;

    public UserInfoResponseDto(Users entity){
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.profile = entity.getProfile();
        this.name = entity.getName();
        this.nickname = entity.getNickname();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
    }
}
