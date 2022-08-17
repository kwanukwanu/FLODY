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
    private String profile;
    private String name;
    private String nickname;
    private String address;
    private String phone;
    private Boolean admin;

    @Builder
    public UserCreateRequestDto(
            String email, String password, String profile, String name, String nickname,
            String address, String phone, Boolean admin ){
                this.email = email;
                this.password = password;
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
                        .profile(profile)
                        .name(name)
                        .nickname(nickname)
                        .address(address)
                        .phone(phone)
                        .admin(admin)
                        .build();
    }
}