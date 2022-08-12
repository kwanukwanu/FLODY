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
public class PLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Posts.class)
    @JoinColumn(name = "pos_no")
    private Posts post;
}
