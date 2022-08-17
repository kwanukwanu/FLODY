package com.ssafy.flody.domain.posts.likes;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
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
@Table(name = "P_Likes")
@IdClass(PLikesId.class)
public class PLikes {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Posts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_no")
    private Posts post;
}
