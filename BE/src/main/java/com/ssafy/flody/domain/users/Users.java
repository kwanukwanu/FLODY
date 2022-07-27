package com.ssafy.flody.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long useNo;

    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String profile;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    private String address;

    @Column(nullable = false)
    private String phone;

    private Boolean admin;

    @Builder
    public Users(String id, String password, String profile, String name, String nickname, String address, String phone, Boolean admin) {
        this.id = id;
        this.password = password;
        this.profile = profile;
        this.name = name;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
        this.admin = admin;
    }
}
