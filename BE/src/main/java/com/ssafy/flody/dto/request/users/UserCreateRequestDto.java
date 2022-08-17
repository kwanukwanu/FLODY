package com.ssafy.flody.dto.request.users;

import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//유저 회원가입
@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequestDto {
    private String email;
    private String password;

    private String introduction;
    private String profile = "basic profile.jpg";
    private String name;
    private String nickname = "익명";
    private String address;
    private String phone;
    private Boolean admin = false;

    @Builder
    public UserCreateRequestDto(
            String email, String password, String profile, String name, String nickname,
            String address, String phone, Boolean admin, String introduction){
                this.email = email;
                this.password = password;
                this.introduction = introduction;
                this.profile = profile;
                this.name = name;
                this.nickname = nickname;
                this.address = address;
                this.phone = phone;
                this.admin = admin;
    }

    //dto to entity
    public Users toEntity(){
                return Users.builder()
                        .email(email)
                        .password(password)
                        .introduction(introduction)
                        .profile(profile)
                        .name(name)
                        .nickname(nickname)
                        .address(address)
                        .phone(phone)
                        .admin(admin)
                        .build();
    }
}