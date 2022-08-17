package com.ssafy.flody.domain.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column
    private String introduction;
    @Column(nullable = false)
    private String nickname;
    @Column
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column
    private Boolean admin;

    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL)
    private List<Users> children;


    public void update(String profile, String nickname, String address, String phone, String introduction) {
        if (profile != null)
            this.profile = profile;
        if (nickname != null)
            this.nickname = nickname;
        if (address != null)
            this.address = address;
        if (phone != null)
            this.phone = phone;
        if (introduction != null)
            this.introduction = introduction;
    }

    public void changePassword(String password) {
        this.password = password;
    }

}
