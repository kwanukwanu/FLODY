package com.ssafy.flody.dto.request.Users;

// 정보수정 : id 제외하고 변경 가능
// 추가 기능 : 비밀번호 찾기 및 수정 따로 빼야하지 않을까?
public class UserUpdateRequest {
    private String password;
    private String profile;
    private String nickname;
    private String address;
    private String phone;
    private String admin;
}
