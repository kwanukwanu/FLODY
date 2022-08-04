package com.ssafy.flody.dto.request.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPasswordUpdateRequestDto {
    private String currentPassword;
    private String newPassword;
    private String checkNewPassword;

    @Builder
    public UserPasswordUpdateRequestDto(
        String newPassword
    ){
        this.newPassword = newPassword;
    }
}
