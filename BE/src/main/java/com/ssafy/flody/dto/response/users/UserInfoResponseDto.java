package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.Users;
import lombok.Getter;

@Getter
public class UserInfoResponseDto {
    private String email;
    private String password;

    private String introduction;
    private String profile;
    private String name;
    private String nickname;
    private String address;
    private String phone;
    private int followers;
    private int followings;
    private int posts;

    public UserInfoResponseDto(Users entity, int followers, int followings, int posts){
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.introduction = entity.getIntroduction();
        this.profile = entity.getProfile();
        this.name = entity.getName();
        this.nickname = entity.getNickname();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
        this.followers = followers;
        this.followings = followings;
        this.posts = posts;
    }
}
