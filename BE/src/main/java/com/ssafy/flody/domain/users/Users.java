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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long useNo;
    @Column(unique = true, nullable = false)
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
        this.profile = profile;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
    }

    public void changePassword(String password) {
        this.password = password;
    }

}
