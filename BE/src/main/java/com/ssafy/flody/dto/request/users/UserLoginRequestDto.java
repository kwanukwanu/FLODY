package com.ssafy.flody.dto.request.users;

//login > response token

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequestDto {
    private String email;
    private String password;

    @Builder
    public UserLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //Entity에 직접 접근이 가능해야하는지 잘 모르겠기에 만들고 주석처리
/*    public Users toEntity(){
        return Users.builder()
                .email(email)
                .password(password)
                .build();
    }*/
}
