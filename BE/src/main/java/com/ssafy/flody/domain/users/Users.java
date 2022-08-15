package com.ssafy.flody.domain.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String profile;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nickname;
    @Column
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private Boolean admin;

    public void update(String profile, String nickname, String address, String phone) {
        if (profile != null)
            this.profile = profile;
        if (nickname != null)
            this.nickname = nickname;
        if (address != null)
            this.address = address;
        if (phone != null)
            this.phone = phone;
    }

    public void changePassword(String password) {
        this.password = password;
    }

}
