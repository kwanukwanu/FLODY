package com.ssafy.flody.dto.request.Users;

import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//유저 회원가입
@Getter
@NoArgsConstructor
public class UserCreateRequestDto {
    private String id;
    private String password;
    private String profile;
    private String nickname;
    private String address;
    private String phone;
    private Boolean admin;

    @Builder
    public UserCreateRequestDto(
            String id, String password, String profile, String nickname,
            String address, String phone, Boolean admin ){
                this.id = id;
                this.password = password;
                this.profile = profile;
                this.nickname = nickname;
                this.address = address;
                this.phone = phone;
                this.admin = admin;
    }

    //dto to entity
    public Users toEntity(){
                return Users.builder()
                        .id(id)
                        .password(password)
                        .profile(profile)
                        .nickname(nickname)
                        .address(address)
                        .phone(phone)
                        .admin(admin)
                        .build();
    }
}