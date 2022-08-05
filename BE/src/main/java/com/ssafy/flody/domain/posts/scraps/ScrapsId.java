package com.ssafy.flody.domain.posts.scraps;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ScrapsId implements Serializable {
    private Users user;
    private Posts post;
}
